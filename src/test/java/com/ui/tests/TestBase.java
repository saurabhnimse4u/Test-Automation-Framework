package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constant.Browser;
import com.ui.pages.HomePage2;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	
	protected HomePage2 homePage2;
	Logger log = LoggerUtility.getLogger(getClass());
	private boolean isLambdaTest;
//	private boolean isHeadless=true;
	
	@Parameters({ "browser", "isHeadless", "isLambdaTest" })
	@BeforeMethod(description = "Load the homepage")
	public void setUp(@Optional("browser") String browser, @Optional("false") boolean isHeadless,
			@Optional("false") boolean isLambdaTest, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdadriver;
		if(isLambdaTest) {
			// lambdadriver =	LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			// homePage2 = new HomePage2(lambdadriver);
		}
		else {
		log.info("Load Home Page ");
		homePage2 = new HomePage2(Browser.CHROME, isHeadless);
		}
	}
	public BrowserUtility getInstance() {
		return homePage2;
	}
}
