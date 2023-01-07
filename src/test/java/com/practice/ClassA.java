package com.practice;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ClassA {
@Test
public void getExcelData() throws IOException  {
	FileInputStream ip = new FileInputStream("./src/main/java/com/config/zoopla01.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(ip);
	XSSFSheet sheet = workbook.getSheetAt(1);
	 
	//XSSFRow row = sheet.getRow(0);
	int rows=sheet.getLastRowNum();
System.out.println(rows);
	int cols=sheet.getRow(0).getLastCellNum();
	System.out.println(cols);
	//XSSFCell cell=row.getCell(0);
	for(int r=0;r<=rows;r++) {
		XSSFRow row = sheet.getRow(r);
		for(int c =0;c<cols;c++) {
			XSSFCell cell=row.getCell(c);
//			switch(cell.getCellType())
//			{
//			case STRING: System.out.println(cell.getStringCellValue());break;
//			case NUMERIC: System.out.println(cell.getNumericCellValue());break;
//			case BOOLEAN: System.out.println(cell.getBooleanCellValue());break;
//			}
			System.out.print(cell.getStringCellValue()+"|");
			
			
		}
		System.out.println();
		}
	
	}
	

}

