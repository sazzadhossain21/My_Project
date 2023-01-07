package com.coding.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class StoreData_Demo{
	@Test
public void store_data_to_Excel() throws Exception {
	Map <String,String> stu_Data = new HashMap<String,String>();
	stu_Data.put("101", "Sima");
	stu_Data.put("102", "Karthik");
	stu_Data.put("103", "Sangeeta");
	stu_Data.put("104", "Veena");
	stu_Data.put("105", "Hossain");
	XSSFWorkbook workbook = new XSSFWorkbook ();
	XSSFSheet sheet = workbook.createSheet("Student_data");
	int rowno = 0;
	for(Map.Entry entry:stu_Data.entrySet()) {
	XSSFRow	row = sheet.createRow(rowno++);
	row.createCell(0).setCellValue((String)entry.getKey());
	row.createCell(1).setCellValue((String)entry.getValue());
	}
	FileOutputStream fos = new FileOutputStream(".//TestData//student.xlsx");
	workbook.write(fos);
	fos.close();
	System.out.println("Excell data created successfully");
}
	@Test
	public void store_data_to_HashMap() throws IOException {
		Map<String,String> data = new HashMap<String,String>();
		FileInputStream fis = new FileInputStream(".//TestData//student.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Student_data");
		int rownum=sheet.getLastRowNum();
		
		for(int i=0;i<=rownum;i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			data.put(key, value);
		}
		for(Map.Entry entry:data.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

}
