package com.ui.listener;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger log = LoggerUtility.getLogger(getClass());
//	ExtentSparkReporter spark; // html styling and looks
//	ExtentReports report; // to heavy lifting in html file
//	ExtentTest testReport; // store info about test inside all extent test info

	public void onTestStart(ITestResult result) {
		log.info(result.getMethod().getMethodName());
		log.info(result.getMethod().getDescription());
		log.info(Arrays.toString(result.getMethod().getGroups()));
//	    testReport = report.createTest(result.getMethod().getMethodName());
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info(result.getMethod().getMethodName() + "PASSED");
//		  testReport.log(Status.PASS, result.getMethod().getMethodName());
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {
		log.error(result.getMethod().getMethodName() + "FAILED");
		log.error(result.getThrowable().getMessage());
//		  testReport.log(Status.FAIL, result.getMethod().getMethodName());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName());
		
		Object testClass = result.getInstance();
		BrowserUtility browserUtiltiy = ((TestBase) testClass).getInstance();
		log.info("Capture screen shot on failure");
		String screenshotPath = browserUtiltiy.takeScreenShots(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		log.info(result.getMethod().getMethodName() + "SKIPPED");
//		  testReport.log(Status.SKIP, result.getMethod().getMethodName());
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		log.info("Test Suite started");
//		  spark = new ExtentSparkReporter(System.getProperty("user.dir")+"//report.html");
//		  report = new ExtentReports();
//		  report.attachReporter(spark);

		ExtentReportUtility.setUpExtentSparkReports("report.html");
	}

	public void onFinish(ITestContext context) {
		log.info("Test Suite ended");
//		  report.flush();
		ExtentReportUtility.flushReport();
	}

}