package com.simplesurance.tests;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.simplesurance.helper.BaseTest;
import com.simplesurance.helper.Constants;
import com.simplesurance.helper.Utils;
import com.simplesurance.pages.CertificateListPageObject;
import com.simplesurance.pages.CreateCertificatePageObject;
import com.simplesurance.pages.LoginPageObject;
import com.simplesurance.pages.PaymentConfirmationPage;

import junit.framework.Assert;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public class CertificateListTest extends BaseTest{

		static LoginPageObject login = new LoginPageObject(driver);
		static CreateCertificatePageObject sellItem = new CreateCertificatePageObject(driver);
		static CertificateListPageObject certList = new CertificateListPageObject(driver);
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
		public void testCaseID016_ValidateCertificateListHeader() throws InterruptedException{
			//Thread.sleep(3000);
			certList.openCertificateList();
			Thread.sleep(2000);
			Assert.assertEquals("Certificate list",certList.returnCertificateListHeader());
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testCaseID017_ValidateCertificateListSearchValidID() throws Exception{
			Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"CertificateList");
			certList.searchCertificateValidId(Utils.getCellData(1, 1));
			Assert.assertEquals(Utils.getCellData(1, 1),certList.returnSearchedCertificate(Utils.getCellData(1, 1)));
		}
//		
		@SuppressWarnings("deprecation")
		@Test
		public void testCaseID018_ValidateCertificateListSearchINValidID() throws Exception{
			Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"CertificateList");
			certList.searchCertificateInValidId(Utils.getCellData(2, 1));
			Assert.assertTrue(certList.returnInvalidCertificateTextMessage());
		}
//		
		@SuppressWarnings("deprecation")
		@Test
		public void testCaseID019_ValidateCertificateListSearchValidEmail() throws Exception{
			Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"CertificateList");
			certList.searchbyEmailId(Utils.getCellData(3, 1));
			Assert.assertEquals("",certList.returnCertificateTextArea());
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testCaseID019_ValidateCertificateListSearchINValidEmail() throws Exception{
			Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"CertificateList");
			certList.searchbyEmailId(Utils.getCellData(4, 1));
			Assert.assertTrue(certList.returnInvalidCertificateTextMessage());
		}
}
