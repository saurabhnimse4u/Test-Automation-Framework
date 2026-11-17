package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
// import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakerAddressUtitlity;

@Listeners({ com.ui.listener.TestListener.class })
public class AddingAddressTest extends TestBase{

	private MyAccountPage myAccountPage;
//	private AddressPage addressPage;
	private AddressPOJO addressPojo;
	
	@BeforeMethod(description = "Valid user log into application")
	public void setup() {
		myAccountPage = homePage2.goToLoginPage().doLoginWithValidCredentials("abcdopq@xyz.com", "oppa123");
		addressPojo =FakerAddressUtitlity.getFakeAddress();
	}


	@Test(description="Adding new address for user")
	public void addNewFirstAddress() {
		String newAddress= myAccountPage.goToAddressPage().saveAddress(addressPojo);
		 Assert.assertEquals(newAddress, addressPojo.getAddressAlies().toUpperCase()); 
	}

}
