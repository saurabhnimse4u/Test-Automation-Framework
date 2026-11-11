package com.ui.tests;

import static com.constant.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage2;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
@Listeners({com.ui.listener.TestListener.class})
public class LoginTest9 extends TestBase{

	//HomePage2 homePage2;

	@Test(description = "Verify with valid user", groups = { "sanity", "e2e" },dataProviderClass=com.dataprovider.LoginDataProvider.class ,dataProvider="LoginData")
	public void LoginTest(User user) {
		assertEquals(
				homePage2.goToLoginPage().doLoginWithValidCredentials(user.getEmail(), user.getPass()).getUserName(),
				"Tim Alex");
	}
	
}
