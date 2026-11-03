package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import static com.constant.Env.*;

import com.constant.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtility.*;



public final class HomePage extends BrowserUtility{  // We extends BrowserUtitlity class here so we can access method without creating a object
	
	private static final By SIGN_IN_LOCATOR = By.className("login");
	Logger log = LoggerUtility.getLogger(getClass());
	public HomePage(Browser browser) {
		
		super(browser);      // Super is used to call the Parent class constructor
		maximizeWindow();
		goTo(ReadProperties(QA, "URL"));
	}
	
	public LoginPage goToLoginPage() { // do  not use void return type when method is related to pages 
		log.info("Browser open and navigate to the Home Page");
		clickOn(SIGN_IN_LOCATOR);
		log.info("Click on the Sign in ");
		LoginPage lp = new LoginPage(getDriver());
		return lp;
	}

	
	
}
