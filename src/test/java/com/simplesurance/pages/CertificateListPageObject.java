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
 * A page class for insurance Certificate list definitions
 */
public class CertificateListPageObject extends BaseTest{

	/**
     *  Constructor to assign driver of type WebDriver
     */
	public CertificateListPageObject(WebDriver driver) {
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
	 * Certificate List header text
	 */
	private static final String CERTIFICATE_LIST_HEADER = "(.//*[normalize-space(text()) and normalize-space(.)='Certificate list'])[1]/following::h1[1]";
	
	/**
	 * Certificate List button 
	 */
	private static final String CERTIFICATE_LIST_BUTTON = "(.//*[normalize-space(text()) and normalize-space(.)='Create certificate'])[2]/following::span[2]";
	
	/**
	 * Certificate search by email edit area
	 */
	private static final String CERTIFICATE_SEARCH_EMAIL_TEXT="filterByEmail";
	
	/**
	 * Certificate List search by certificate id edit area
	 */
	private static final String CERTIFICATE_LIST_SEARCH_TEXT_BOX = "//*[@id=\"filterByCertNo\"]";
	
	/**
	 * Certificate List Search button 
	 */
	private static final String SEARCH_BTTN = "(.//*[normalize-space(text()) and normalize-space(.)='E-Mail-Adresse Kunde'])[1]/following::span[1]";
	
	/**
	 * Certificate List Cancel search button
	 */
	private static final String CANCEL_BTTN = "(.//*[normalize-space(text()) and normalize-space(.)='Suchen'])[1]/following::span[1]";
	
	/**
	 * Certificate List Invalid certificate error text
	 */
	private static final String INVALID_CERTIFICATE_ID_MESSAGE = "(.//*[normalize-space(text()) and normalize-space(.)='Clear search'])[1]/following::div[1]";
	
	
	/**
	 * Page factory model to locate the WebElements
	 */
	@FindBy(xpath = CERTIFICATE_LIST_HEADER)
	private WebElement certListHeader;
	
	@FindBy(xpath = CERTIFICATE_LIST_BUTTON)
	private WebElement certListBtton;
	
	@FindBy(xpath = CERTIFICATE_LIST_SEARCH_TEXT_BOX)
	private WebElement certListSearch;
	
	@FindBy(id = CERTIFICATE_SEARCH_EMAIL_TEXT)
	private WebElement certListSearchByEmail;
	
	@FindBy(xpath = SEARCH_BTTN)
	private WebElement certSearchbTTN;
	
	@FindBy(css = CANCEL_BTTN)
	private WebElement certCancelBttn;
	
	@FindBy(xpath = INVALID_CERTIFICATE_ID_MESSAGE)
	private WebElement invalidSearchMssge;
	
	
	/**
	 * Method to open Certificate List
	 */
	public void openCertificateList(){
		wait.until(ExpectedConditions.elementToBeClickable(certListBtton));
		certListBtton.click();
	}
	
	/**
	 * Method to enter certificate number into search area
	 * @param certificateNumber
	 */
	public void enterCertificateNum(String certificateNumber ){
		certListSearch.clear();
		certListSearch.sendKeys(certificateNumber);
	}
	
	/**
	 * Method to search for a valid certificate
	 * @param certificateNumber
	 */
	public void searchCertificateValidId(String certificateNumber){
		enterCertificateNum(certificateNumber);
		certListSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(certificateNumber))));
	}
	
	/**
	 * Method to search for a invalid certificate
	 * @param invalid certificateNumber 
	 */
	public void searchCertificateInValidId(String certificateNumber){
		enterCertificateNum(certificateNumber);
		certListSearch.click();
		wait.until(ExpectedConditions.visibilityOf(invalidSearchMssge));
	}
	
	/**
	 * Method to search for a valid certificate by email id
	 * @param  email 
	 */
	public void searchbyEmailId(String email){
		certListSearchByEmail.clear();
		certListSearchByEmail.sendKeys(email);
		certListSearch.click();
	}
	
	/**
	 * Method to return entered certificate number 
	 */
	public String returnCertificateTextArea(){
		return certListSearch.getText();
	}
	
	/**
	 * Method to return invalid certificate error message
	 * @return boolean
	 */
	public boolean returnInvalidCertificateTextMessage(){
		return invalidSearchMssge.isDisplayed();
	}
	
	/**
	 * Method to return searched certificate
	 * @param certificateNumber 
	 */
	public String returnSearchedCertificate(String certificateNumber){
		return driver.findElement(By.linkText(""+certificateNumber+"")).getText();
	}
	
	/**
	 * Method to return certificate list header
	 */
	public String returnCertificateListHeader(){
		wait.until(ExpectedConditions.elementToBeClickable(certListHeader));
		return certListHeader.getText();
	}
	
	/**
	 * Method to cancel entered certificate number certificate
	 * @param certificateNumber 
	 */
	public void cancelEnteredSearchCErtificateNum(String certificateNumber){
		enterCertificateNum(certificateNumber);
		certCancelBttn.click();
	}
	
}
