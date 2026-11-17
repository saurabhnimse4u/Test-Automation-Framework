package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constant.Browser;
import com.utility.BrowserUtility;

public class ShoopingCartPage extends BrowserUtility{

	private static final By PROCEED_TO_CHECKOUT_BUTTON= By.xpath("//p[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
		
	public ShoopingCartPage(WebDriver webDriver) {
		super(webDriver);		
	}
	
	public ConfirmAddressPage goToConfirmAddressPage() {
		
		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		return new ConfirmAddressPage(getDriver());
	}

}
