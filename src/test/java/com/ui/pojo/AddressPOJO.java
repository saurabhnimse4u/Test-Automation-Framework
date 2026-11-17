package com.ui.pojo;

import org.openqa.selenium.By;

public class AddressPOJO {

	private String company;
	private String address1;
	private String address2;	
	private String city;
	private String postcode;
	private String homePhone;
	private String mobPhone;
	private String otherInfo;
	private String addressAlies;
	private String state;
	
	public AddressPOJO(String company, String address1, String address2, String city, String postcode, String homePhone,
			String mobPhone, String otherInfo, String addressAlies, String state) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postcode = postcode;
		this.homePhone = homePhone;
		this.mobPhone = mobPhone;
		this.otherInfo = otherInfo;
		this.addressAlies = addressAlies;
		this.state = state;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobPhone() {
		return mobPhone;
	}

	public void setMobPhone(String mobPhone) {
		this.mobPhone = mobPhone;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getAddressAlies() {
		return addressAlies;
	}

	public void setAddressAlies(String addressAlies) {
		this.addressAlies = addressAlies;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", postcode=" + postcode + ", homePhone=" + homePhone + ", mobPhone=" + mobPhone
				+ ", otherInfo=" + otherInfo + ", addressAlies=" + addressAlies + ", state=" + state + "]";
	}
	
	
	
}
