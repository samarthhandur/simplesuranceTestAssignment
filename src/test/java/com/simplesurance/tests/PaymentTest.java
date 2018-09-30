package com.simplesurance.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import com.simplesurance.helper.BaseTest;
import com.simplesurance.helper.Constants;
import com.simplesurance.helper.Utils;
import com.simplesurance.pages.CreateCertificatePageObject;
import com.simplesurance.pages.LoginPageObject;
import com.simplesurance.pages.PaymentConfirmationPage;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import junit.framework.Assert;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaymentTest extends BaseTest{
	static LoginPageObject login = new LoginPageObject(driver);
	static CreateCertificatePageObject sellItem = new CreateCertificatePageObject(driver);
	static PaymentConfirmationPage pay = new PaymentConfirmationPage(driver);
	static Utils util = new Utils(driver);
	
	
	@BeforeClass
	public static void createCertificate() throws Exception
	{
		login.selectLanguageFromLandingPage();
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Login");
		login.loginFromLandingPage(Utils.getCellData(1, 1), Utils.getCellData( 1, 2));
		login.submitCredentials();
		login.selectLanguageFromLandingPage();
		sellItem.createCertificate();
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		sellItem.enterProductDetails(Utils.getCellData(1, 1));
		sellItem.enterCustomerDetails(Utils.getCellData(2, 1), Utils.getCellData(3, 1), Utils.getCellData(4, 1), Utils.getCellData(5, 1), Utils.getCellData(6, 1), Utils.getCellData(7, 1), Utils.getCellData(8, 1));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID007_ValidateProdCategory() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(10, 1), pay.returnProdCategory());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID008_ValidateDeviceOriginalPrice() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(9, 1), pay.returnDeviceOriginalPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID009_ValidateSerialNumber() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(1, 1), pay.returnSerialNumber());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID0011_ValidateCustomerDataStreetName() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(5, 1), pay.returnCustStreetName());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID0012_ValidateCustomerDataStreetNumber() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(6, 1), pay.returnCustStreetNumber());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID0013_ValidateCustomerDataZip() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(7, 1), pay.returnCustZip());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID014_ValidateCustomerDataCity() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(8, 1), pay.returnCustCity());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID015_ValidateCustomerData() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(2, 1), pay.returnCustEmail());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID016_SelectVisaPaymentModeAndVerifyCertificateNum(){
		pay.selectVisaPaymentMode();
		pay.confirmOrderAndPay();
		//Assert.assertEquals("English", pay.returnCurrentLanguage());
		Assert.assertTrue(pay.isDownloadCertificate());
	}
	
}
