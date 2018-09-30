package com.simplesurance.tests;
import org.junit.BeforeClass;
import org.junit.Test;

import com.simplesurance.helper.BaseTest;
import com.simplesurance.helper.Constants;
import com.simplesurance.helper.Utils;
import com.simplesurance.pages.CreateSubAgentPageObject;
import com.simplesurance.pages.LoginPageObject;

import junit.framework.Assert;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateSubAgentListTest extends BaseTest{
		static LoginPageObject login = new LoginPageObject(driver);
		static CreateSubAgentPageObject subAgent = new CreateSubAgentPageObject(driver);
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
		public void testCaseID020_ValidateSubAgentHeader() throws Exception{
			Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Subagents");
			Assert.assertEquals(Utils.getCellData(1, 1), subAgent.getSubAgentHeaderText());
		}

		@SuppressWarnings("deprecation")
		@Test
		public void testCaseID021_ValidateCreateAlreadyExistedSubAgent() throws Exception{
			Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Subagents");
			//subAgent.createSubAgentWithParams("TEST", "BERLIN", "test.berlin@simplesurance.com", "123456789", "123456789");
			subAgent.createSubAgentWithParams(Utils.getCellData(2, 1), Utils.getCellData(3, 1), Utils.getCellData(4, 1), Utils.getCellData(5, 1), Utils.getCellData(6, 1));
			Assert.assertTrue(subAgent.returnEmailAlreadyExistError());
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testCaseID022_ValidateCreateInValidSubAgent() throws Exception{
			Utils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Subagents");
			subAgent.createSubAgentWithParams(Utils.getCellData(7, 1), Utils.getCellData(8, 1), Utils.getCellData(9, 1), Utils.getCellData(5, 1), Utils.getCellData(6, 1));
			Assert.assertTrue(subAgent.returnInvalidNameError());
		}
}
