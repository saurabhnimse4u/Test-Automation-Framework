package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static String getURL() throws FileNotFoundException {
		
		Gson gson = new Gson();
		File filePath = new File(System.getProperty("user.dir")+ "//config//config.json");
		FileReader fileRead = new FileReader(filePath);
		Config config = gson.fromJson(fileRead, Config.class);
		Environment environment = config.getEnvironment().get("QA");
	    System.out.println(environment.getURL());
		System.out.println(environment.getHeader());
		return environment.getURL();

	}

}
