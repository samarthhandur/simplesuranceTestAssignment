package com.simplesurance.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simplesurance.helper.BaseTest;
import com.simplesurance.helper.Utils;


/**
 * A page for a Logging in to simplesurance assignment web app
 */
public class LoginPageObject extends BaseTest{
	
	/**
     *  Constructor to assign driver of type WebDriver
     */
	public LoginPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    }
	
	/**
     * Explicit wait of 10 secs
     */
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	/**
     * Creating util Object of class Utils
     */
	Utils util = new Utils(driver);
	
	
	/**
     * Username text edit area from the landing page
     */
	private static final String USER_NAME_TEXT_AREA = "input-email";
	
	/**
     *  Password text edit area from the landing page
     */
	private static final String PASSWORD_TEXT_AREA = "input-password";
	
	/**
     * Login button from the landing page
     */
	private static final String LOGIN_BUTTON = "//*[contains(text(), 'LOGIN')]";
	
	/**
     * Login button from the landing page
     */
	private static final String LOGOUT_BUTTON = "(.//*[normalize-space(text()) and normalize-space(.)='Dashboard'])[1]/preceding::button[1]";
	
	/**
     * Language selector button from the landing page
     */
	private static final String LANGUAGE_SELECTOR_BUTTON = "dropdownMenu1";
	
	/**
     * English Language from the landing page
     */
	private static final String LANGUAGE_CLASS = "lg-item";
	
	/**
     * Page header text locator
     */
	private static final String PAGE_HEADER= ".page-header h1";
	
	/**
     * Login error message locator
     */
	private static final String LOGIN_ERROR= "(.//*[normalize-space(text()) and normalize-space(.)='›'])[6]/following::div[2]";
	
	/**
     * PageFactory element assignments  
     */
	@FindBy(id = USER_NAME_TEXT_AREA)
	private WebElement user_name;
	
	@FindBy(id = PASSWORD_TEXT_AREA)
	private WebElement password;
	
	@FindBy(xpath = LOGIN_BUTTON)
	private WebElement loginBttn;
	
	@FindBy(xpath = LOGIN_ERROR)
	private WebElement loginErr;

	@FindBy(xpath = LOGOUT_BUTTON)
	private WebElement logoutBttn;

	@FindBy(id = LANGUAGE_SELECTOR_BUTTON)
	private WebElement selectLanguage;
	
	@FindBy(css = PAGE_HEADER)
	private WebElement pageHeader;
	
	@FindAll({@FindBy(className = LANGUAGE_CLASS)})
		private List<WebElement> languageClass;
	
	
	/**
     * Method to set English Language 
	 * @throws InterruptedException 
     */
	public void selectLanguageFromLandingPage() throws InterruptedException {
		selectLanguage.click();
		languageClass.get(7).click();
	}
	
	/**
     * Method to enter login credentials 
     */
	public void loginFromLandingPage(String user, String pwd) {
		user_name.clear();
		user_name.sendKeys(user);
		password.clear();
		password.sendKeys(pwd);
		//loginBttn.click();
	}

	/**
     * Method to submit the login credentials  
     */
	public void submitCredentials() {
		loginBttn.click();
		wait.until(ExpectedConditions.visibilityOf(pageHeader));
	}
	
	/**
     * Method to click submit 
     */
	public void submitLoginButton(){
		loginBttn.click();
	}
	/**
     * Method to logout 
     */
	public void logout() {
		logoutBttn.click();
		wait.until(ExpectedConditions.visibilityOf(loginBttn));
	}
	
	/**
     * Method to verify login failure  
     */
	public boolean verifyLoginFailure(){
		try{
			pageHeader.isDisplayed();
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
		
	}

	/**
     * Method to verify if logout button present  
     */
	public boolean verifyLogoutBttonPresent(){
		try{
			 logoutBttn.isDisplayed();
			 return true;
		}catch(Exception e){
			return false;
		}
	}
}
