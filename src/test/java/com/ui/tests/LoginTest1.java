package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest1 {
	
	private static WebDriver  driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationpractice.techwithjatin.com/");
		
		
		By signInLinkLocator = By.className("login");
		WebElement signInElement = driver.findElement(signInLinkLocator);
		signInElement.click();
		
		WebElement username = driver.findElement(By.cssSelector("#email"));
		username.sendKeys("xihige9472@digeros.com");
		
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("Tim123");
		
		driver.close();

	}

}
