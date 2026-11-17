package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constant.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger log = LoggerUtility.getLogger(getClass());
    private WebDriverWait wait;
    
    String path;
	
    public WebDriver getDriver() {
		return driver.get();	
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browser) {
		super();
		if (browser.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browser.equalsIgnoreCase("edge")) {

			driver.set(new EdgeDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {

			System.err.println("Not found any browser");
		}

	}

	public BrowserUtility(Browser browser) {
		super();
		if (browser == Browser.CHROME) {
			log.info("Browse open: " + " " + browser);
			driver.set(new ChromeDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browser == Browser.EDGE) {
			log.info("Browse open: " + " " + browser);
			driver.set(new EdgeDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browser == Browser.FIREFOX) {
			log.info("Browse open: " + " " + browser);
			driver.set(new FirefoxDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			log.error("Browser not founds");
			System.err.println("Not found any browser");
		}

	}

	public BrowserUtility(Browser browser, boolean isHeadless) {
		super();
		if (browser == Browser.CHROME) {
			if (isHeadless) {
				log.info("Browse open: " + " " + browser);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless==old");
				options.addArguments("--window-size==1980,1080");
				driver.set(new ChromeDriver(options));
				wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browser == Browser.EDGE) {
			if (isHeadless) {
				log.info("Browse open: " + " " + browser);
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless==old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browser == Browser.FIREFOX) {
			if (isHeadless) {
				log.info("Browse open: " + " " + browser);
				FirefoxOptions options = new FirefoxOptions();
				
				options.addArguments("--headless==old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new FirefoxDriver());
				wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else {
			log.error("Browser not founds");
			System.err.println("Not found any browser");
		}

	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void goTo(String url) {
		log.info("Enter the URL: " + url);
		driver.get().get(url);
	}

	public void clickOn(By locator) {
	    WebElement element = driver.get().findElement(locator);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnCheckbox(By locator) {
	WebElement element = driver.get().findElement(locator);
	//	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public void clickOn(WebElement element) {
		log.info("Element found now clicking on the element");
		element.click();
	}

	public void sendText(By locator, String text) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		log.info("Enter the key: " + locator);
	//	wait.until(ExpectedConditions.)
		WebElement element = driver.get().findElement(locator);
		log.info("Element found and now enter special key" + keyToEnter);
		element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {
		log.info("To get visible text from the: " + locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		log.info("To get visible text from the element: ");
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {
		log.info("Getting all visible text by locating the element");
		List<WebElement> elementList = driver.get().findElements(locator);
		log.info("Element found and now print all ");
		List<String> visibleText = new ArrayList<>();

		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleText.add(getVisibleText(element));
		}
		return visibleText;
	}
	
	public List<WebElement> getAllElement(By locator) {
		log.info("Getting all visible text by locating the element");
		List<WebElement> elementList = driver.get().findElements(locator);
		return elementList;
	}

	public String takeScreenShots(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String currentTime = format.format(date);
		path = "./screenshots/" + name + "-" + currentTime + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void clearText(By textLocator) {
		log.info("Finding element to clear text box");
		WebElement element = driver.get().findElement(textLocator);
		log.info("Clearing the text box");
		element.clear();
	}

	public void selectFromDropDownByValue(By locator, String value) {
		log.info("Finding dropdown element ");
		WebElement element = driver.get().findElement(locator);
		Select select = new Select(element);
		log.info("Element selected");
		select.selectByValue(value);
	}
	
	public void selectFromDropDownByVisibleText(By locator, String text) {
		log.info("Finding dropdown element : " +locator);
		WebElement element1 = driver.get().findElement(locator);
		Select select = new Select(element1);
		log.info("Element selected" +select);
		select.selectByVisibleText(text);
	}

	public void selectFromDropDown(By locator, String value) {
		log.info("Finding dropdown element ");
		WebElement element = driver.get().findElement(locator);
		Select select = new Select(element);
		log.info("Element selected");
		select.selectByVisibleText(value);
	}

	public void tearDown() {
		if (driver != null) {
			driver.get().quit();
		}
	}
}
