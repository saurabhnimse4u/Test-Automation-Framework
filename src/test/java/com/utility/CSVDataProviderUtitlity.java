package com.utility;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.ui.pojo.User;

public class CSVDataProviderUtitlity {
	
	
	public static Iterator<User> LoginTestDataCSV() {

		File file = new File(System.getProperty("user.dir") + "//testdata//LoginTestData2.csv");
		FileReader fileReader = null;
		CSVReader csvRead;
		String[] line;
		List<User> userList = null;
		User userData;
		

		try {
			fileReader = new FileReader(file);
			csvRead = new CSVReader(fileReader);
			csvRead.readNext();// row 1
			
	    //	line = csvRead.readNext();// row 2
		    userList = new ArrayList<User>();
			
			
			while((line= csvRead.readNext())!=null) {
			userData= new User(line[0],line[1], line[2]);
			userList.add(userData);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
