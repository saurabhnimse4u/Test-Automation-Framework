package com.ui.tests;

import static com.constant.Browser.*;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginTest6 {
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		homePage = new HomePage(CHROME,false);
	}
    
	@Test(description = "Verify with valid user", groups = { "sanity", "e2e" })
	public void LoginTest() {
		assertEquals(
				homePage.goToLoginPage().doLoginWithValidCredentials("xihige9472@digeros.com", "Tim123").getUserName(),
				"Tim Alex");
	}

}
