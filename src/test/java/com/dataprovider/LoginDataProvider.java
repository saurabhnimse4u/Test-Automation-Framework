package com.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVDataProviderUtitlity;
import com.utility.ExcelDataProviderUtility;
import com.utility.JSONUtility2;

public class LoginDataProvider {
	
	// JSON using gson lab
	
	@DataProvider(name="LoginData")
	public Iterator<Object[]> loginData() throws FileNotFoundException {		
		return JSONUtility2.readJsonData();
	}

	// CSV using openCSV
	@DataProvider(name="LoginData2")
	public Iterator<User> loginData2(){
		return CSVDataProviderUtitlity.LoginTestDataCSV();	 
	}
	// xlsx using Apache POI
	@DataProvider(name="LoginData3")
	public Iterator<User> loginData3(){
		return ExcelDataProviderUtility.readExcelFile();	 
	}
}
