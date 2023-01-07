package com.coding.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadData_from_Excel {
	@Test
public void readData() throws Exception {
	FileInputStream ip = new FileInputStream(".//TestData//student.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(ip);
	//XSSFSheet sheet = workbook.getSheetAt(0);
	XSSFSheet sheet = workbook.getSheet("Student_data");
	int rownum = sheet.getLastRowNum();
	int cellnum = sheet.getRow(0).getLastCellNum();
	for(int i= 0;i<=rownum;i++) {
		XSSFRow row = sheet.getRow(i);
		for(int j=0;j<cellnum;j++) {
		XSSFCell cell = row.getCell(j);
		DataFormatter formatter = new DataFormatter();
		//formatCellValue always return String
		String s1 = formatter.formatCellValue(cell);
		System.out.print(s1+" | ");
		}
		System.out.println();
	}
}
}
