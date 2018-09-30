package com.simplesurance.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import com.simplesurance.helper.BaseTest;
import com.simplesurance.helper.Constants;
import com.simplesurance.helper.Utils;
import com.simplesurance.pages.CreateCertificatePageObject;
import com.simplesurance.pages.LoginPageObject;
import com.simplesurance.pages.PaymentConfirmationPage;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateCertificateTest extends BaseTest{

	static LoginPageObject login = new LoginPageObject(driver);
	static CreateCertificatePageObject sellItem = new CreateCertificatePageObject(driver);
	static PaymentConfirmationPage pay = new PaymentConfirmationPage(driver);
	static Utils util = new Utils(driver);
	
	@BeforeClass
	public static void login() throws Exception
	{
		login.selectLanguageFromLandingPage();
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Login");
		login.loginFromLandingPage(Utils.getCellData(1, 1), Utils.getCellData( 1, 2));
		login.submitCredentials();
		login.selectLanguageFromLandingPage();

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID003_ValidateCertificateHeader() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(11, 1),sellItem.returnCertificateHeader());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID004_ValidateDefaultCountry() throws Exception{
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		Assert.assertEquals(Utils.getCellData(12, 1),sellItem.defaultCountry());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID005_ValidateDefaultOriginalPrice() throws InterruptedException{
		Assert.assertEquals("",sellItem.defaultOriginalPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCaseID006_CreateCertificate() throws Exception{
		sellItem.createCertificate();
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"ProductDetails");
		sellItem.enterProductDetails(Utils.getCellData(1, 1));
		sellItem.enterCustomerDetails(Utils.getCellData(2, 1), Utils.getCellData(3, 1), Utils.getCellData(4, 1), Utils.getCellData(5, 1), Utils.getCellData(6, 1), Utils.getCellData(7, 1), Utils.getCellData(8, 1));
		Assert.assertEquals("https://partner-de.sb-test2709.sisu.sh/#!/certificate/create", pay.currentPageURL());
	}
}
