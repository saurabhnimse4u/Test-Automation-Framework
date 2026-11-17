package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippmentPage extends BrowserUtility{

	
	private static final By TERMANDSERVICE_CHECKBOX= By.id("uniform-cgv");
	private static final By PROCEED_CHECKOUT= By.name("processCarrier");
	
	public ShippmentPage(WebDriver driver) {
		super(driver);
	}
	
	
	public PaymentPage goToPaymentPage() {
		clickOnCheckbox(TERMANDSERVICE_CHECKBOX);
		clickOn(PROCEED_CHECKOUT);
		return new PaymentPage(getDriver());
	}
	

}
