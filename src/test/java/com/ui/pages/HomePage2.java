package com.ui.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import static com.constant.Env.*;

import com.constant.Browser;
import com.utility.BrowserUtility;
import static com.utility.JSONUtility.*;

import static com.utility.PropertiesUtility.*;

import java.io.FileNotFoundException;

public final class HomePage2 extends BrowserUtility{  // We extends BrowserUtitlity class here so we can access method without creating a object
	
	private static final By SIGN_IN_LOCATOR = By.className("login");
	
	public HomePage2(Browser browser,boolean isHeadless ) {
		super(browser,isHeadless);      // Super is used to call the Parent class constructor
		maximizeWindow();
		try {
			goTo(getURL());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LoginPage goToLoginPage() { // do  not use void return type when method is related to pages 
		clickOn(SIGN_IN_LOCATOR);
		LoginPage lp = new LoginPage(getDriver());
		return lp;
	}
	
	
}
