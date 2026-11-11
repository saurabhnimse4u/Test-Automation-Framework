package com.ui.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	private final static int MAX_NUM_OF_ATTEMPT = 3;
	private static int currentAttmpt = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (currentAttmpt <= MAX_NUM_OF_ATTEMPT) {
			currentAttmpt++;
			return true;
		}
		return false;
	}

}
