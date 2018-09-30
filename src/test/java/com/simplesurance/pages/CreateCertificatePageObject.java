package com.simplesurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simplesurance.helper.BaseTest;
import com.simplesurance.helper.Utils;


/**
 * A page for creating insurance Certificates
 */
public class CreateCertificatePageObject extends BaseTest{
	
	/**
     *  Constructor to assign driver of type WebDriver
     */
	public CreateCertificatePageObject(WebDriver driver) {
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
     * Create certificate button locator
     */
	private static final String CREATE_CERTIFICATE = "//*[@id=\"menu\"]/li[1]/a/span[2]";
	 
	/**
     * Create certificate header view
     */
	private static final String PAGE_HEADER= ".page-header h1";
	
	 /**
     * Create certificate default country code
     */
	private static final String DEFAULT_COUNTRY = "select2-chosen-4";
	 
	/**
     * Create certificate product category 
     */
	private static final String PRODUCT_CATEGORY_SELECT_BUTTON = "select2-chosen-2";
	
	/**
     * Create certificate select product form list 
     */
	private static final String PRODUCT_SELECT = "//*[@id=\"select2-results-2\"]/li[2]";
	
	/**
     * Create certificate device original price 
     */
	private static final String DEVICE_ORIGINAL_PRICE = "//*[@id=\"s2id_certificate-original-price\"]/a";
	
	/**
     * Create certificate product price range 
     */
	private static final String SELECT_PRODUCT_PRICE_RANGE = "//*[@id=\"select2-result-label-12\"]";
	
	/**
     * Select insurance period locator 
     */
	private static final String SELECT_PERIOD_UL_CLASS = "insurancePeriod";
	
	/**
     * Checkbox for theft protection option
     */
	private static final String SELECT_THEFT_PROTECTION_CLASS = "optionalTheft";
	
	/**
     * Poduct serial Nummber locator
     */
	private static final String PRODUCT_SERIAL_NUMBER = "//*[@id=\"certificate-product-serial\"]";
	
	/**
     * Customer first name text area
     */
	private static final String CUSTOMER_FIRST_NAME = "//*[@id=\"certificate-customer-firstname\"]";
	
	/**
     * Customer email text area
     */
	private static final String CUSTOMER_EMAIL_ID = "//*[@id=\"certificate-customer-email\"]";
	
	/**
     * Customer salutation select
     */
	private static final String CUSTOMER_SALUTATION_SELECT = "//*[@id=\"s2id_certificate-customer-salutation\"]/a";
	
	/**
     * Customer salutation locator
     */
	private static final String CUSTOMER_SALUTATION = "select2-result-label";
	
	/**
     * Customer last name text area
     */
	private static final String CUSTOMER_LAST_NAME = "//*[@id=\"certificate-customer-lastname\"]";
	
	/**
     * Customer address street name text area
     */
	private static final String CUSTOMER_ADDRESS_STREET_NAME = "//*[@id=\"certificate-customer-streetname\"]";
	
	/**
     * Customer address street number text area
     */
	private static final String CUSTOMER_ADDRESS_STREET_NUMBER = "//*[@id=\"certificate-customer-streetnumber\"]";
	
	/**
     * Customer address zip text area
     */
	private static final String CUSTOMER_ADDRESS_ZIP = "//*[@id=\"certificate-customer-zip\"]";
	
	/**
     * Customer address city text area
     */
	private static final String CUSTOMER_ADDRESS_CITY = "//*[@id=\"certificate-customer-city\"]";
	
	/**
     * Details correctness checkbox
     */
	private static final String DETAILS_CORRECTNESS_CHECKBOX = "[ng-model='certificate.confirmation']";
	
	/**
     * Terms and condition checkbox
     */
	private static final String TERMS_AND_CONDITIONS_CHECKBOX = "[ng-model='certificate.avb_confirm']";
	
	/**
     * Product age locator
     */
	private static final String CERTIFICATE_PRODUCT_AGE = "[ng-model='certificate.product_age']";
	
	/**
     * Customer consent checkbox
     */
	private static final String CUSTOMER_CONSENT_CHECKBOX = "[ng-model='certificate.gdpr_accept']";
	
	/**
     * Create certificate button locator
     */
	private static final String CREATE_CERTIFICATE_BUTTON = "[ng-click='validateCertificate(certificate)']";
	
	/**
     * Payement page confirmation page locator
     */
	private static final String PAYMENT_CONFIRMATION_PAGE_TRIAT = "//*[@id=\"certificate-change\"]/div/div/div/div[1]/div[1]";
	
	/**
     * PageFactory element assignments  
     */
	@FindBy(xpath = CREATE_CERTIFICATE)
	private WebElement createCertificateButton;
	
	@FindBy(css = PAGE_HEADER)
	private WebElement certificatePageHeader;
	
	@FindBy(id = DEFAULT_COUNTRY)
	private WebElement defaultCountry;
	
	@FindBy(id = PRODUCT_CATEGORY_SELECT_BUTTON)
	private WebElement selectProductCategory;
	
	@FindBy(xpath = PRODUCT_SELECT)
	private WebElement selectProduct;
	
	@FindBy(xpath = DEVICE_ORIGINAL_PRICE)
	private WebElement deviceOriginalPrice;
	
	@FindBy(xpath = SELECT_PRODUCT_PRICE_RANGE)
	private WebElement selectProdPriceRange;
	
	@FindBy(name = SELECT_PERIOD_UL_CLASS)
	private WebElement selectInsurancePeriod;
	
	@FindBy(id = SELECT_THEFT_PROTECTION_CLASS)
	private WebElement selectTheftProtection;
	
	@FindBy(xpath = PRODUCT_SERIAL_NUMBER)
	private WebElement prodSerialNumber;
	
	@FindBy(xpath = CUSTOMER_FIRST_NAME)
	private WebElement customerFirstName;
	
	@FindBy(xpath = CUSTOMER_LAST_NAME)
	private WebElement customerLastName;
	
	@FindBy(xpath = CUSTOMER_EMAIL_ID)
	private WebElement customerEmailId;

	@FindBy(xpath = CUSTOMER_SALUTATION_SELECT)
	private WebElement customerSalutation;
	
	@FindBy(className = CUSTOMER_SALUTATION)
	private WebElement customerSalutationSelect;
	
	@FindBy(xpath = CUSTOMER_ADDRESS_STREET_NAME)
	private WebElement customerAddressStreetName;
	
	@FindBy(xpath = CUSTOMER_ADDRESS_STREET_NUMBER)
	private WebElement customerAddressStreetNumber;
	
	@FindBy(xpath = CUSTOMER_ADDRESS_ZIP)
	private WebElement customerAddressZip;
	
	@FindBy(xpath = CUSTOMER_ADDRESS_CITY)
	private WebElement customerAddressCity;
	
	@FindBy(css = DETAILS_CORRECTNESS_CHECKBOX)
	private WebElement detailsCorrectnessCheckBox;
	
	@FindBy(css = TERMS_AND_CONDITIONS_CHECKBOX)
	private WebElement termsAndConditionsCheckBox;
	
	@FindBy(css = CERTIFICATE_PRODUCT_AGE)
	private WebElement certificateProductAgeCheckBox;
	
	@FindBy(css = CUSTOMER_CONSENT_CHECKBOX)
	private WebElement customerConsentCheckbox;
	
	@FindBy(css = CREATE_CERTIFICATE_BUTTON)
	private WebElement createCertificateBttn;
	
	
	@FindBy(xpath = PAYMENT_CONFIRMATION_PAGE_TRIAT)
	private WebElement paymentConfPage;
	
	/**
     * Method to return the page header in the list
	 * @throws InterruptedException 
     */
	@SuppressWarnings("deprecation")
	public String returnCertificateHeader() throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(createCertificateButton));
		createCertificateButton.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(certificatePageHeader));
		return certificatePageHeader.getText();
	}
	
	/**
     * Method to return the default country
     */
	public String defaultCountry(){
		return defaultCountry.getText();
	}
	
	/**
     * Method to return the default original price
     */
	public String defaultOriginalPrice(){
		return deviceOriginalPrice.getText();
	}
	
	/**
     * Method to create the certificates
     * @throws InterruptedException
     */
	public void createCertificate() throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(createCertificateButton));
		createCertificateButton.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(selectProductCategory));
		selectProductCategory.click();
		Thread.sleep(3000);
		selectProduct.click();
		Thread.sleep(3000);
		deviceOriginalPrice.click();
		selectProdPriceRange.click();
		selectInsurancePeriod.click();
		selectTheftProtection.click();
	}
	
	/**
     * Method to enter product details
     * @param productName
     */
	public void enterProductDetails(String prod){
		prodSerialNumber.clear();
		prodSerialNumber.sendKeys(prod);
	}
	
	/**
     * Method to enter the customer details
     * @param email,firstname,lastname,steetname,streetnumber,zip,city
     * @throws InterruptedException
     */
	public void enterCustomerDetails(String email, String first, String last, String street_name, String street_num, String zip, String city) throws InterruptedException{
		customerEmailId.clear();
		customerEmailId.sendKeys(email);
		customerSalutation.click();
		customerSalutationSelect.click();
		customerFirstName.clear();
		customerFirstName.sendKeys(first);
		customerLastName.clear();
		customerLastName.sendKeys(last);
		customerAddressStreetName.clear();
		customerAddressStreetName.sendKeys(street_name);
		customerAddressStreetNumber.clear();
		customerAddressStreetNumber.sendKeys(street_num);
		customerAddressZip.clear();
		customerAddressZip.sendKeys(zip);
		customerAddressCity.clear();
		customerAddressCity.sendKeys(city);
		detailsCorrectnessCheckBox.click();
		termsAndConditionsCheckBox.click();
		certificateProductAgeCheckBox.click();
		customerConsentCheckbox.click();
		createCertificateBttn.click();
		wait.until(ExpectedConditions.visibilityOf(paymentConfPage));
		Thread.sleep(4000);
	}
	
}
