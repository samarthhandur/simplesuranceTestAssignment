package com.simplesurance.helper;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * An abstract base for all of the Web tests within this package
 *
 * Responsible for setting up the Selenium WebDriver
 */

public abstract class BaseTest {
	  /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
	protected static WebDriver driver;
	//static final Log Log = 
	
    /**
     * This method runs before class loads.
     *
     * We are setting up our selenium webdriver in order to connect to test URL.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    
    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
    	
    	DOMConfigurator.configure("log4j.xml");
    	
    	  /**
         * Set the chromedriver property into system variable
         */
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    	
    	System.setProperty("log4j2.configurationFile", System.getProperty("user.dir").concat("/log4j2.properties"));
    	
    	Log.info("=====Browser Session Started=====");
		
        driver=new ChromeDriver();

        driver.get(Constants.URL);

        Log.info("=====Application Started=====");
   
      //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        /**
         * Maximise the test browser window
         */
        driver.manage().window().maximize();
    }
    
    /**
     * Always remember to quit
     */
    @AfterClass
    public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
