package com.ui.interview;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadAndStoredInDifferentPath {

	public static void main(String[] args) throws InterruptedException {
		
		
		String downloadPath =System.getProperty("user.dir")+File.separator+"JenkinsDownloadFolder";
		
		File fileFolder = new File(downloadPath);
		
		if(!fileFolder.exists()){
		    System.out.println("Folder not exist"); 
		    if(fileFolder.mkdir()) {
		    	System.out.println("Created");
		    }
		}

		
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadPath);
		prefs.put("download.prompt_for_download", false);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs",prefs);
	
		
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://get.jenkins.io/war-stable/2.580.2/jenkins.war");
		 
		 // Check if the file exist or not 
		 
		 File filePath = new File(fileFolder,"jenkins.war");
		 int timeOutSecond=30;
		 int elapsedTime=0;
		 while(elapsedTime<timeOutSecond &&!filePath.exists()) {
			 Thread.sleep(2000);
			 elapsedTime++;
			 System.out.println("Waiting for file download");
		 }
		 
		 if(filePath.exists()) {
			 System.out.println("File downloaded successfully");
		 };
}

}
