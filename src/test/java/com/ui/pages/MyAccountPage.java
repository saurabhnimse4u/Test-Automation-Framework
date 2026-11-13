package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {

	
	private static final By USER_NAME = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_BOX = By.id("search_query_top");
			public MyAccountPage(WebDriver driver) {
				super(driver); // Super is used to call the Parent class constructor

			}
			
			public String getUserName() {		
				return getVisibleText(USER_NAME);	
			}

			
			public void enterProduct(String searchProduct) {
				
			}
}
