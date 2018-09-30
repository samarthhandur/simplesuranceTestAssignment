package com.simplesurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simplesurance.helper.BaseTest;

/**
 * A page payment confirmation
 */

public class PaymentConfirmationPage extends BaseTest{
	
	/**
     *  Constructor to assign driver of type WebDriver
     */
	public PaymentConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    }
	
	/**
     * Explicit wait of 50 secs
     */
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	/**
     * Product category for certificate approve
     */
	private static final String PRODUCT_CATEGORY = "//*[@id=\"certificate-approve-category\"]";
	
	/**
     * Device original price for certificate approve
     */
	private static final String DEVICE_ORIGINAL_PRICE = "//*[@id=\"certificate-change\"]/div/div/div/div[1]/div[2]/div[2]/div[2]/span";
	
	/**
     * Certificate serial number for certificate approve
     */
	private static final String SERIAL_NUMBER = "//*[@id=\"certificate-change\"]/div/div/div/div[1]/div[2]/div[3]/div[2]/span";
	
	/**
     * Customer email  for certificate approve
     */
	private static final String CUST_EMAIL = "//*[@id=\"certificate-change\"]/div/div/div/div[2]/div[2]/div[1]/div[2]/span";
	
	/**
     * Customer street name for certificate approve
     */
	private static final String CUST_STREET_NAME = "//*[@id=\"certificate-change\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/span";
	
	/**
     * Customer street number for certificate approve
     */
	private static final String CUST_STREET_NUMBER = "//*[@id=\"certificate-change\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/span";
	
	/**
     * Customer zip number for certificate approve
     */
	private static final String CUST_ZIP = "//*[@id=\"certificate-change\"]/div/div/div/div[2]/div[2]/div[4]/div[2]/span";
	
	/**
     * Customer city for certificate approve
     */
	private static final String CUST_CITY = "//*[@id=\"certificate-change\"]/div/div/div/div[2]/div[2]/div[5]/div[2]/span";
	
	/**
     * Change certificate button 
     */
	private static final String CHANGE_CERTIFICATE_BTTN = "//*[@id=\"certificate-change\"]/button";
	
	/**
     * Payment by Visa checkbox
     */
	private static final String PAYMENT_BY_VISA = "//*[@id=\"payment-visa\"]";
	
	/**
     * Confirm order button
     */
	private static final String CONFIRM_ORDER = "//*[@id=\"certificate-payment\"]/button";
	
	/**
     * Payment redirection URL
     */
	private static final String redirectionURL = "https://test.saferpay.com/VT2/mpp/PaymentDataEntry/Index/h1c1pj04cymcpdh1ctbshz0p";
	
	/**
     * Payment buy button over 3rd party payment gateway
     */
	private static final String BUY_BTTN = "SubmitToNext";
	
	/**
     * Submit credit card info to payment gateway
     */
	private static final String SUBMIT_CC_PWD = "submitButton";
	
	/**
     * credit card payment gateway URL 
     */
	private static final String CREDIT_CARD_PWD_URL = "https://test.saferpay.com/Simulators/ThreeDS/EnterData/EnterCreditCardPassword";
	
	/**
     * Download certificate button
     */
	private static final String DOWNLOAD_CERTIFICATE = "Zertifikat herunterladen";
	
	/**
     * Certificate number after successful payment
     */
	private static final String CERTIFICATE_NUMBER = "/html/body/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div[2]";
	
	/**
     * Certificate created data header after  successful payment
     */
	private static final String CERTIFICATE_DATA_HEADER = "/html/body/div[2]/div[2]/div/div/div/div[3]/div/a";
	
	/**
     * Current language text
     */
	private static final String CURRENT_LANGUAGE_SET = "dropdownMenu1";
	
	/**
     * PageFactory element assignments  
     */
	@FindBy(id = CURRENT_LANGUAGE_SET)
	private WebElement currentLanguage;
	
	@FindBy(xpath = PRODUCT_CATEGORY)
	private WebElement prodCategory;
	
	@FindBy(xpath = DEVICE_ORIGINAL_PRICE)
	private WebElement deviceOriginalPrice;
	
	@FindBy(xpath = SERIAL_NUMBER)
	private WebElement serialNumber;
	
	@FindBy(xpath = CUST_EMAIL)
	private WebElement customerEmail;
	
	@FindBy(xpath = CUST_STREET_NAME)
	private WebElement customerStreetName;
	
	@FindBy(xpath = CUST_STREET_NUMBER)
	private WebElement customerStreetNumber;
	
	@FindBy(xpath = CUST_ZIP)
	private WebElement customerZip;
	
	@FindBy(xpath = CUST_CITY)
	private WebElement customerCity;
	
	@FindBy(xpath = CHANGE_CERTIFICATE_BTTN)
	private WebElement changeCertBttn;
	
	@FindBy(xpath = PAYMENT_BY_VISA)
	private WebElement visaPaymentCheckbox;
	
	@FindBy(xpath = CONFIRM_ORDER)
	private WebElement confirmOrderBttn;
	
	@FindBy(name = BUY_BTTN)
	private WebElement buyBttn;
	
	@FindBy(name = SUBMIT_CC_PWD)
	private WebElement ccPwdSubmit;
	
	@FindBy(linkText = DOWNLOAD_CERTIFICATE)
	private WebElement downloadCertificate;
	
	
	@FindBy(css = CERTIFICATE_NUMBER)
	private WebElement certNumber;
	
	@FindBy(xpath = CERTIFICATE_DATA_HEADER)
	private WebElement certificateDataHeader;
	
	public String currentPageURL(){
		return driver.getCurrentUrl();
	}
	
	/**
     * Method to return product category 
     */
	public String returnProdCategory(){
		return prodCategory.getText();
	}
	
	/**
     * Method to return original device price 
     */
	public String returnDeviceOriginalPrice(){
		return deviceOriginalPrice.getText();
	}
	
	/**
     * Method to return customer email
     */
	public String returnCustEmail(){
		return customerEmail.getText();
	}
	
	/**
     * Method to return certificate serial number 
     */
	public String returnSerialNumber(){
		return serialNumber.getText();
	}
	
	/**
     * Method to return current language 
     */
	public String returnCurrentLanguage(){
		return currentLanguage.getText();
	}
	
	/**
     * Method to return customer street name
     */
	public String returnCustStreetName(){
		return customerStreetName.getText();
	}

	/**
     * Method to return customer street number
     */
	public String returnCustStreetNumber(){
		return customerStreetNumber.getText();
	}
	
	/**
     * Method to return customer zip
     */
	public String returnCustZip(){
		return customerZip.getText();
	}
	
	/**
     * Method to return customer city
     */
	public String returnCustCity(){
		return customerCity.getText();
	}
	
	/**
     * Method to return certificate number text
     */
	public String returnCertNumber(){
		return certNumber.getText();
	}
	
	/**
     * Method to select Visa payment
     */
	public void selectVisaPaymentMode(){
		 visaPaymentCheckbox.click();
	}
	
	/**
     * Method to confirm order and pay
     */
	public void confirmOrderAndPay(){
		confirmOrderBttn.click();
		buyBttn.click();
		wait.until(ExpectedConditions.elementToBeClickable(ccPwdSubmit));
		ccPwdSubmit.click();
		isDownloadCertificate();
		//wait.until(ExpectedConditions.visibilityOf(downloadCertificate));
	}
	
	/**
     * Method to return is download certificate button present
     */
	public boolean isDownloadCertificate(){
		try{
			downloadCertificate.isDisplayed();
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
