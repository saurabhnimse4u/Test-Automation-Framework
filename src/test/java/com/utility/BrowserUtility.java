package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constant.Browser;

public abstract class BrowserUtility {
	// Here BrowserUtility is parent class and it should be abstract
	// We can not create object of this class but extends in child class
	// When we create child class object that time parent abstract class constructor
	// call first
	// So super is used for to call parent class constructor in child class

	private static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	Logger log = LoggerUtility.getLogger(getClass());
	
	public WebDriver getDriver() {
		return driver.get();
	}
//
//	public void setDriver(WebDriver driver) {
//		this.driver = driver;
//	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browser) {
		super();
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("edge")) {
			
			driver.set(new EdgeDriver());
		}
		else {
			
			System.err.println("Not found any browser");
		}
		
	}

	public BrowserUtility(Browser browser) {
		super();
		if(browser== Browser.CHROME) {
			log.info("Browse open: "+" "+browser);
			driver.set(new ChromeDriver());
		}
		else if(browser== Browser.EDGE) {
			log.info("Browse open: "+" "+browser);
			driver.set(new EdgeDriver());
		}
		else if(browser== Browser.FIREFOX) {
			log.info("Browse open: "+" "+browser);
			driver.set(new FirefoxDriver());
		}
		else {
			log.error("Browser not founds");
			System.err.println("Not found any browser");
		}
		
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void goTo(String url) {
		log.error("Enter the URL: "+url);
		driver.get().get(url);
	}

	public void clickOn(By locator) {
		WebElement element =driver.get().findElement(locator);
		element.click();
	}

	public void sendText(By locator, String text) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	} 

	String path;
	public String takeScreenShots(String name) {
		TakesScreenshot  screenshot= (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String currentTime = format.format(date);  
        path = System.getProperty("user.dir")+"//screenshots//" + name + "-"+currentTime +".png";
         File screenshotFile = new File(path);
         try {
        	 FileUtils.copyFile(screenshotData,screenshotFile);
         }
         catch(IOException e) { 	 
        	 e.printStackTrace(); 
         }
		return path;
	}
}
