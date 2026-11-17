package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listener.TestListener.class })
public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;

	private static final String SEARCH_TERM ="PRINTED SUMMER DRESS";
	@BeforeMethod(description = "Valid user log into application")
	public void setup() {
		myAccountPage = homePage2.goToLoginPage().doLoginWithValidCredentials("xihige9472@digeros.com", "Tim123");
	}

	@Test(description = "User able to search product and valid search result displayed", groups = { "sanity" })
	public void verifyProductSearchTest() {
		String data = myAccountPage.searchProduct("PRINTED SUMMER DRESS").getSearchTitle();
		System.out.println(data);
	}

	@Test(description = "User able to search product and valid search result displayed", groups = { "sanity" })
	public void verifyGetSearchResult() {
		myAccountPage.searchProduct("PRINTED SUMMER DRESS").getAllDressName();
	}
	
	@Test(description = "User able to search product and valid search result displayed", groups = { "sanity" })
	public void verifyProductSearchTest1() {
	boolean result =	myAccountPage.searchProduct(SEARCH_TERM).isSearchTermPresent(SEARCH_TERM);
		Assert.assertEquals(result, true);	
	}

}
