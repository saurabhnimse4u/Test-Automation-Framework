package com.ui.tests;
import static org.testng.Assert.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pojo.User;

@Listeners({com.ui.listener.TestListener.class})
public class LoginTest8 extends TestBase{

	//HomePage2 homePage2;
// Using JSON
	@Test(description = "Verify with valid user", groups = { "sanity"},dataProviderClass=com.dataprovider.LoginDataProvider.class ,dataProvider="LoginData")
	public void LoginTestWithJSON(User user) {
	String username =	homePage2.goToLoginPage().doLoginWithValidCredentials(user.getEmail(), user.getPass()).getUserName();
	System.out.println(username);
	}
	
// Using CSV	
	@Test(description = "Verify login when user read the username and password from CSV file", groups = { "sanity"},dataProviderClass=com.dataprovider.LoginDataProvider.class ,dataProvider="LoginData2")
	public void LoginTestWithCSV(User user) {
		assertEquals(
				homePage2.goToLoginPage().doLoginWithValidCredentials(user.getEmail(), user.getPass()).getUserName(),
				user.getUsername());
	}
	
// Using Excel	
	@Test(description = "Verify login when user read the username and password from EXCEL file ", groups = { "sanity"},dataProviderClass=com.dataprovider.LoginDataProvider.class ,dataProvider="LoginData3", retryAnalyzer=com.ui.listener.MyRetryAnalyzer.class)
	public void LoginTestWithEXCEL(User user) {
		
		assertEquals(
				homePage2.goToLoginPage().doLoginWithValidCredentials(user.getEmail(), user.getPass()).getUserName(),
				"Tim Alex");
	}
	
// Normal	
	@Test(description = "Verfiy user able to login with valid credentials", groups = { "sanity" })
	public void LoginTestNormal() {
		assertEquals(
				homePage2.goToLoginPage().doLoginWithValidCredentials("xihige9472@digeros.com", "Tim123").getUserName(),
				"Tim Alex");
	}
}
