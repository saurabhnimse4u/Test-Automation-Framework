package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;

public class JSONUtility2 {

	public static Iterator<Object[]> readJsonData() throws FileNotFoundException{
		
		Gson gson = new Gson();
		File filePath = new File(System.getProperty("user.dir")+"//testdata//LoginTestData1.json");
		FileReader fileReader = new FileReader(filePath);
		TestData data = gson.fromJson(fileReader, TestData.class);
		
		List<Object[]> dataReturn = new ArrayList<Object[]>(); 
		for(User user:data.getData()) {
			dataReturn.add(new Object[] {user});
		}
		return dataReturn.iterator();
	}

}
