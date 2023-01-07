package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ReadExcelData {
	
	// How to read data from excel sheet
	@Test
	public void getExcelData() throws Exception {
		// First I import the file
		// FileInputStream ip = new
		// FileInputStream("./src/main/java/com/config/zoopla01.xlsx");
		FileInputStream ip = new FileInputStream("./src/main/java/com/config/zoopla01.xlsx");
		// Import excel work book
		XSSFWorkbook sb = new XSSFWorkbook(ip);
		// Import Sheet
		XSSFSheet xs = sb.getSheet("Sheet1");//get sheet by sheet name
		// get cell value
		String data = xs.getRow(1).getCell(2).getStringCellValue();
		System.out.println(data);
	}
	@Test
	public void getAllValue() throws Exception {
		FileInputStream ip = new FileInputStream("./src/main/java/com/config/zoopla01.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(ip);
		XSSFSheet sheet = workbook.getSheetAt(1);//get sheet by index
		
		//XSSFRow row = sheet.getRow(0);
		int rownumber=sheet.getLastRowNum();//return last row number base on 0.
		int colnumber=sheet.getRow(1).getLastCellNum();//return last cell plus 1. based on 0.
		
		//XSSFCell cell=row.getCell(0);
		
		for(int i=0;i<=rownumber;i++) {
			//We get row from sheet
			XSSFRow row = sheet.getRow(i);
			for(int j =0;j<colnumber;j++) {
				//We get cell from the row
				XSSFCell cell = row.getCell(j);
				//Here we format cell value as String
				DataFormatter formatter = new DataFormatter();
				String s1 = formatter.formatCellValue(cell);
				
				System.out.print(s1+" | ");
		   }
			System.out.println();
		}
		

	}
}
