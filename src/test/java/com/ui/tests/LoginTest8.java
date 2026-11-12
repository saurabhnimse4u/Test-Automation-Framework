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
public class LoginTest8 extends TestBase{

	//HomePage2 homePage2;
// Using JSON
	@Test(description = "Verify with valid user", groups = { "sanity", "e2e" },dataProviderClass=com.dataprovider.LoginDataProvider.class ,dataProvider="LoginData")
	public void LoginTest(User user) {
		assertEquals(homePage2.goToLoginPage().doLoginWithValidCredentials(user.getEmail(), user.getPass()).getUserName(),"Tim Alex");
	}
	
	@Test(description = "Verify with valid user", groups = { "sanity", "e2e" },dataProviderClass=com.dataprovider.LoginDataProvider.class ,dataProvider="LoginData2")
	public void LoginTest2(User user) {
		assertEquals(
				homePage2.goToLoginPage().doLoginWithValidCredentials(user.getEmail(), user.getPass()).getUserName(),
				"Tim Alex");
	}
	
	@Test(description = "Verify with valid user", groups = { "sanity", "e2e" },dataProviderClass=com.dataprovider.LoginDataProvider.class ,dataProvider="LoginData3", retryAnalyzer=com.ui.listener.MyRetryAnalyzer.class)
	public void LoginTest3(User user) {
		
		assertEquals(
				homePage2.goToLoginPage().doLoginWithValidCredentials(user.getEmail(), user.getPass()).getUserName(),
				"Tim Alex");
	
	}
	
	@Test(description = "Verify with valid user", groups = { "sanity", "e2e" })
	public void LoginTest() {
		assertEquals(
				homePage2.goToLoginPage().doLoginWithValidCredentials("xihige9472@digeros.com", "Tim123").getUserName(),
				"Tim Alex");
	}
}
