package com.ui.interview;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://zigzag.lk/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			if (url == null || url.isEmpty()) {
				continue;
			}

			try {
				HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.setConnectTimeout(5000);
				conn.setReadTimeout(5000);
				conn.connect();
				int statusCode = conn.getResponseCode();
				if (statusCode >= 400) {
					System.out.println("Link is broken " + url+" "+statusCode);
				} else {
					System.out.println("Valid link " + url + "Status" + statusCode);
				}
				conn.disconnect();
			} catch (Exception e) {
				System.out.println("Unable to verify " + url);
			}
		}
		driver.quit();
	}
}
