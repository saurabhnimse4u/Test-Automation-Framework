package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	public AddressPage(WebDriver driver) {
		super(driver);
	}

	private static final By COMPANY_TEXT_BOX = By.id("company");
	private static final By ADDRESS_1_TEXT_BOX = By.id("address1");
	private static final By ADDRESS_2_TEXT_BOX = By.id("address2");
	private static final By CITY_TEXT_BOX = By.id("city");
	private static final By POSTCODE_TEXT_BOX = By.id("postcode");
	private static final By PHONE_TEXT_BOX = By.id("phone");
	private static final By MOBPHONE_TEXT_BOX = By.id("phone_mobile");
	private static final By OTHERINFO_TEXT_BOX = By.id("other");
	private static final By ADDRESSALIES_TEXT_BOX = By.id("alias");
	private static final By STATE_DROPDOWN = By.id("id_state");
	private static final By SAVE_ADDRESS = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");

	public String saveAddress(AddressPOJO addressPojo) {

		sendText(COMPANY_TEXT_BOX, addressPojo.getCompany());
		sendText(ADDRESS_1_TEXT_BOX, addressPojo.getAddress1());
		sendText(ADDRESS_2_TEXT_BOX, addressPojo.getAddress2());
		sendText(CITY_TEXT_BOX, addressPojo.getCity());
		sendText(POSTCODE_TEXT_BOX, addressPojo.getPostcode());
		sendText(PHONE_TEXT_BOX, addressPojo.getHomePhone());
		sendText(MOBPHONE_TEXT_BOX, addressPojo.getMobPhone());
		sendText(OTHERINFO_TEXT_BOX, addressPojo.getOtherInfo());
		// clearText(ADDRESSALIES_TEXT_BOX);
		sendText(ADDRESSALIES_TEXT_BOX, addressPojo.getAddressAlies());
		selectFromDropDownByValue(STATE_DROPDOWN, addressPojo.getState());
		clickOn(SAVE_ADDRESS);
		String newAddress = getVisibleText(ADDRESS_HEADING);
		return newAddress;
	}
}
