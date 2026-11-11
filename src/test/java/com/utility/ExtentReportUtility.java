package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	private static ExtentReports reports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static void setUpExtentSparkReports(String reportName) {
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(spark);
	}

	public static void createExtentTest(String testName) {
		ExtentTest test = reports.createTest(testName);
		extentTest.set(test);
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flushReport() {
		reports.flush();
	}
}
