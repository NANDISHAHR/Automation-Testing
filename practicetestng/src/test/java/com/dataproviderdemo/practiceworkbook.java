package com.dataproviderdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class practiceworkbook {


	@DataProvider(name= "data")
	public  String[][] exceldata() throws Exception {
		File Excelfile = new File("./src/test/resources/Test.xlsx");
		System.out.println(Excelfile.exists());
		FileInputStream fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet Sheet = workbook.getSheet("Sheet1");
		System.out.println(Sheet.getPhysicalNumberOfRows());
		int noofrows = Sheet.getPhysicalNumberOfRows();
		int noofcolumns = Sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noofrows-1][noofcolumns];
		
		
		for (int i = 0; i < noofrows-1; i++) {
			for (int j = 0; j < noofcolumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(Sheet.getRow(i+1).getCell(j));
			}
			
		}

		workbook.close();
		fis.close();
		for (String[] dataArr : data) {
			System.out.println(Arrays.toString(dataArr));
		}
		return data;
	}

}
