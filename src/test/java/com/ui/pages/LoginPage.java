package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {

	private static final By EMAIL_LOCATOR = By.cssSelector("#email");
	private static final By PASSWORD = By.id("passwd");
	private static final By submitLocator = By.xpath("//button[@name='SubmitLogin']");

	public LoginPage(WebDriver driver) {
		super(driver); // Super is used to call the Parent class constructor

	}

	public MyAccountPage doLoginWithValidCredentials(String username, String password) {
		sendText(EMAIL_LOCATOR, username);
		sendText(PASSWORD, password);
		clickOn(submitLocator);
		MyAccountPage map = new MyAccountPage(getDriver());
		return map;
	}
}
