package com.simplesurance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simplesurance.helper.BaseTest;
import com.simplesurance.helper.Utils;

/**
 * A page for creating subagents
 */
public class CreateSubAgentPageObject extends BaseTest{
	
	/**
     *  Constructor to assign driver of type WebDriver
     */
	public CreateSubAgentPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    }
	
	/**
     * Explicit wait of 10 secs
     */
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	/**
     * Creating util Object of class Utils
     */
	Utils util = new Utils(driver);
	
	/**
     * Create sub agent button
     */
	private static final String CREATE_SUB_AGENT_BUTTON = "(.//*[normalize-space(text()) and normalize-space(.)='Certificate list'])[1]/following::span[2]";
	
	/**
     * Create sub agent header
     */
	private static final String CREATE_SUB_AGENT_HEADER = "(.//*[normalize-space(text()) and normalize-space(.)='Subagents'])[1]/following::h1[1]";
	
	/**
     * Create sub agent first name locator
     */
	private static final String SUB_AGENT_FIRST_NAME = "subagent-create-firstname";
	
	/**
     * Create sub agent last name locator
     */
	private static final String SUB_AGENT_LAST_NAME = "subagent-create-lastname";
	
	/**
     * Create sub agent email locator
     */
	private static final String SUB_AGENT_EMAIL = "subagent-create-email";
	
	/**
     * Create sub agent password locator
     */
	private static final String SUB_AGENT_PASSWORD = "subagent-create-password";
	
	/**
     * Create sub agent password confirm locator
     */
	private static final String SUB_AGENT_PASSWORD_CONFIRM ="subagent-create-password-confirm";
	
	/**
     * Create sub agent create button locator
     */
	private static final String SUB_AGENT_CREATE_BUTTON ="(.//*[normalize-space(text()) and normalize-space(.)='This form is not valid, please check again'])[1]/following::button[1]";
	
	/**
     * Create sub agent invalid form error message
     */
	private static final String INVALID_FORM_ERROR = "(.//*[normalize-space(text()) and normalize-space(.)='Subagents'])[1]/following::h1[1]";
	
	/**
     * Create sub agent invalid name error locator
     */
	private static final String INVALID_NAME_ERROR = "/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/subagent-create/form/div[1]/div/small/strong";
	
	/**
     * Create sub agent email already exist error message
     */
	private static final String EMAIL_ALREADY_EXIST = "/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/subagent-create/form/div[3]/div/small/strong";
	
	/**
     * PageFactory element assignments  
     */
	@FindBy(xpath = CREATE_SUB_AGENT_BUTTON)
	private WebElement createSubAgentButton;
	
	
	@FindBy(xpath = CREATE_SUB_AGENT_HEADER)
	private WebElement createSubAgentHeader;
	
	@FindBy(id = SUB_AGENT_FIRST_NAME)
	private WebElement subAgentFirstNameEdit;
	
	
	@FindBy(id = SUB_AGENT_LAST_NAME)
	private WebElement subAgentLastNameEdit;

	
	@FindBy(id = SUB_AGENT_EMAIL)
	private WebElement subAgentEmailEdit;
	
	
	@FindBy(id = SUB_AGENT_PASSWORD)
	private WebElement subAgentPwdEdit;
	
	
	@FindBy(id = SUB_AGENT_PASSWORD_CONFIRM)
	private WebElement subAgentPwdConfirmEdit;
	
	
	@FindBy(xpath = SUB_AGENT_CREATE_BUTTON)
	private WebElement subAgentCreateBttn;
	
	@FindBy(xpath = EMAIL_ALREADY_EXIST)
	private WebElement emailAlreadyExist;
	
	@FindBy(xpath = INVALID_FORM_ERROR)
	private WebElement invalidFormError;
	
	@FindBy(xpath = INVALID_NAME_ERROR)
	private WebElement invalidNameError;
	
	/**
     * Return Subagent header text
     * @throws InterruptedException
     */
	public String getSubAgentHeaderText() throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(createSubAgentButton));
		createSubAgentButton.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(createSubAgentHeader));
		return createSubAgentHeader.getText();
	}
	
	/**
     * Method to Create Subagent with valid params
     * @param firstname,lastname,email,password,confirmpassword
     * @throws InterruptedException
     */
	public void createSubAgentWithParams(String first_name, String last_name, String email, String pwd, String cnf_pwd) throws InterruptedException{
		subAgentFirstNameEdit.clear();
		subAgentFirstNameEdit.sendKeys(first_name);
		subAgentLastNameEdit.clear();
		subAgentLastNameEdit.sendKeys(last_name);
		subAgentEmailEdit.clear();
		subAgentEmailEdit.sendKeys(email);
		subAgentPwdEdit.clear();
		subAgentPwdEdit.sendKeys(pwd);
		subAgentPwdConfirmEdit.clear();
		subAgentPwdConfirmEdit.sendKeys(cnf_pwd);
		subAgentCreateBttn.click();
		Thread.sleep(2000);
	}
	
	/**
     * Return invalid form error  text
     * @return boolean
     */
	public boolean returnInvalidFormError(){
		return invalidFormError.isDisplayed();
	}
	
	/**
     * Return email already registered error text
     * @return boolean
     */
	public boolean returnEmailAlreadyExistError(){
		try{
			emailAlreadyExist.isDisplayed();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
     * Return email invalid name error text
     * @return boolean
     */
	public boolean returnInvalidNameError(){
		try{
			invalidNameError.isDisplayed();
			return true;
		}catch(Exception e){
			return false;
		}
		 
	}
		
	/**
     * Return created agent email id
     * @param email
     */
	public String returnCreatedAgentText(String email){
		return driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+email+"'])[1]/following::td[1]")).getText();
	}
}
