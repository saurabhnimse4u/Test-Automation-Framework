package com.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelDataProviderUtility {

	public static Iterator<User> readExcelFile() {
		
		File excelFile = new File(System.getProperty("user.dir")+"//testdata/LoginData.xlsx");
		XSSFWorkbook wb= null; 
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        User user;
        List<User> userList= null;
        Iterator<Row> rowIterator;
        XSSFSheet sheet;
        
        try { 	
        	wb =new XSSFWorkbook(excelFile);
        	userList= new ArrayList<User>();
        	sheet = wb.getSheet("loginData");
        	rowIterator = sheet.iterator();
        	row = rowIterator.next();
        	while(rowIterator.hasNext()) {
        		row = rowIterator.next();
        		emailAddressCell = row.getCell(0);
        		passwordCell = row.getCell(1);
        		user= new User(emailAddressCell.toString(),passwordCell.toString());
        		userList.add(user);
        		wb.close();
        	}     	
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        
        return userList.iterator();
        
	}

}
 