package com.simplesurance.tests;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import com.simplesurance.helper.BaseTest;
import com.simplesurance.helper.Constants;
import com.simplesurance.helper.Log;
import com.simplesurance.helper.Utils;
import com.simplesurance.pages.CreateCertificatePageObject;
import com.simplesurance.pages.LoginPageObject;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
	LoginPageObject login = new LoginPageObject(driver);
	Utils util = new Utils(driver);

@Before
public void checkLogout(){
	if(login.verifyLogoutBttonPresent()){
		login.logout();
	}
}

@Test
	public void testCaseID001_ValidLoginCredentials() throws Exception {
		Log.startTestCase("Selenium_Test_001");
		login.selectLanguageFromLandingPage();
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Login");
		login.loginFromLandingPage(Utils.getCellData(1, 1), Utils.getCellData( 1, 2));
		login.submitCredentials();
	}
	
@Test	
public void testCaseID002_ValidateInvalidLoginCredentials() throws Exception{
		Log.startTestCase("Selenium_Test_002");
		login.selectLanguageFromLandingPage();
		Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Login");
		login.loginFromLandingPage(Utils.getCellData(2, 1), Utils.getCellData( 2, 2));
		login.submitLoginButton();
		Assert.assertFalse(login.verifyLoginFailure());
	}
	
}