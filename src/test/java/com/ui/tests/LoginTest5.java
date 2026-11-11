package com.ui.tests;

import static com.constant.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest5 {

	public static void main(String[] args) {

		HomePage homePage = new HomePage(CHROME,true);
		String name = homePage.goToLoginPage()
				              .doLoginWithValidCredentials("xihige9472@digeros.com","Tim123")
				              .getUserName();
		System.out.println(name);

	}

}
