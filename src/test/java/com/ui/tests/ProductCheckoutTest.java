package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;
import com.ui.pages.ShoopingCartPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM="Printed Summer Dress";
	private static SearchResultPage searchPage;

	@BeforeMethod(description = "Valid user log into application")
	public void setup() {
		searchPage = homePage2.goToLoginPage().doLoginWithValidCredentials("abcdopq@xyz.com", "oppa123").searchProduct(SEARCH_TERM);

	}

	@Test
	public void checkoutTest() {
	searchPage.ClickOnTheProductByIndex(2).changeSize("3").addProductToCart().proccedToCheckout();
		
	}
	
	@Test
	public void navigateToConfirmationAddress() {
	searchPage.ClickOnTheProductByIndex(2).changeSize("3").addProductToCart().proccedToCheckout().goToConfirmAddressPage();
		
	}
	
	@Test
	public void navigateToShippmentPage() {
	searchPage.ClickOnTheProductByIndex(2).changeSize("3").addProductToCart().proccedToCheckout().goToConfirmAddressPage().goToShippmentPage();
		
	}
	
	@Test
	public void confirmSuccessMessage() {
	String result=searchPage.ClickOnTheProductByIndex(2).changeSize("3").addProductToCart().proccedToCheckout().goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makePaymentByWire();
	System.out.println(result);	
	Assert.assertTrue(result.contains("Your order on My Shop is complete"));
	}


}
