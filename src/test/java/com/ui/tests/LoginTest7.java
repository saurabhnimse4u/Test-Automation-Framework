package com.ui.tests;

import static com.constant.Browser.*;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage2;
@Listeners({com.ui.listener.TestListener.class})
public class LoginTest7 {
	HomePage2 homePage2;

	@BeforeMethod
	public void setUp() {
		homePage2 = new HomePage2(CHROME,true);
	}
    
	@Test(description = "Verify with valid user", groups = { "sanity", "e2e" })
	public void LoginTest() {
		assertEquals(
				homePage2.goToLoginPage().doLoginWithValidCredentials("xihige9472@digeros.com", "Tim123").getUserName(),
				"Tim Alex");
	}

}
