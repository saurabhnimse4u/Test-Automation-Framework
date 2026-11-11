package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constant.Env;

public class PropertiesUtility {

	public static String ReadProperties(Env env, String propertyName) {

		File filePath = new File(System.getProperty("user.dir") + "//config//QA.properties");
		System.out.println(filePath);
		FileReader fileReader = null;
		Properties prop = new Properties();
		try {
			fileReader = new FileReader(filePath);
			prop.load(fileReader);

		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = prop.getProperty(propertyName.toUpperCase());
		System.out.println(value);
		return value;

	}

}
