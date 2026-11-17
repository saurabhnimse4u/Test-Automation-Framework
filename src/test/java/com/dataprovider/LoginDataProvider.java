package com.dataprovider;

import java.io.FileNotFoundException;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import com.ui.pojo.User;
import com.utility.CSVDataProviderUtitlity;
import com.utility.ExcelDataProviderUtility;
import com.utility.JSONUtility2;

public class LoginDataProvider {
	
	// JSON using Gson lab	
	@DataProvider(name="LoginData")
	public Iterator<Object[]> loginData() throws FileNotFoundException {		
		return JSONUtility2.readJsonData();
	}

	// CSV using openCSV
	@DataProvider(name="LoginData2")
	public Iterator<User> loginData2(){
		return CSVDataProviderUtitlity.LoginTestDataCSV();	 
	}
	// Excel using Apache POI
	@DataProvider(name="LoginData3")
	public Iterator<User> loginData3(){
		return ExcelDataProviderUtility.readExcelFile();	 
	}
}
