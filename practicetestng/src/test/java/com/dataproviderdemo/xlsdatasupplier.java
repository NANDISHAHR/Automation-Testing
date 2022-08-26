package com.dataproviderdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class xlsdatasupplier {
	@DataProvider
	public String[][] getdata() throws Exception {

		File excelfile = new File("./src/test/resources/Test.xlsx");
		System.out.print(excelfile.exists());
		FileInputStream fis = new FileInputStream(excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int noofrows = sheet.getPhysicalNumberOfRows();
		System.out.println(sheet.getLastRowNum());
	
		int noofcoloums = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[noofrows-1][noofcoloums];
		
		for (int i = 0; i < noofrows-1; i++) {
			for (int j = 0; j < noofcoloums; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());	
			}
		//	System.out.println();
		}
		workbook.close();
		fis.close();
		for (String[] daraArr : data) {
			System.out.println(Arrays.toString(daraArr));
		}
		return data;
	}
}
