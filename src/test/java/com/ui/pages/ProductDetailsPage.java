package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.constant.Size;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {

	private static final By SIZE_DROP_DOWN = By.id("group_1");
	private static final By ADD_TO_CART = By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT = By.xpath("//a[@title='Proceed to checkout']");

	public ProductDetailsPage(WebDriver driver) {
		super(driver);

	}

	public ProductDetailsPage changeSize(Size size) {
		selectFromDropDownByVisibleText(SIZE_DROP_DOWN, size.toString());
		return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage changeSize(String value) {
		selectFromDropDownByValue(SIZE_DROP_DOWN, value);
		return new ProductDetailsPage(getDriver());
	}

	public ProductDetailsPage addProductToCart() {
		clickOn(ADD_TO_CART);
		return new ProductDetailsPage(getDriver());

	}

	public ShoopingCartPage proccedToCheckout() {
		
		clickOn(PROCEED_TO_CHECKOUT);
		return new ShoopingCartPage(getDriver());
	}


}
