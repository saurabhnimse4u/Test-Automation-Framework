package com.ui.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ com.ui.listener.TestListener.class })
public class LoginInvalidCredentials extends TestBase {
	private static final String INVALID_USERNAME="wrong@wr.com";
	private static final String Password="wrong@wr.com";

	@Test(description = "Verify if the proper message displayed when user enter invalid credentials", groups = { "e2e",
			"sanity" })
	public void invalidLoginTest() {

		String errorMsg = homePage2.goToLoginPage().doLoginWithInvalidCredentials(INVALID_USERNAME,Password)
				.getErrorMSG();
		System.out.println(errorMsg);
		assertEquals(homePage2.goToLoginPage().doLoginWithInvalidCredentials(INVALID_USERNAME, Password)
				.getErrorMSG(), "Authentication failed.");
	}

}
