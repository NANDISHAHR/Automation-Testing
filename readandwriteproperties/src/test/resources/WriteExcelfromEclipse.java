import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelfromEclipse {

	public static void main(String[] args) {
		/*
		 * HSSFWorkbook workbook = new HSSFWorkbook(); HSSFSheet sheet =
		 * workbook.createSheet("TestSheet");
		 * 
		 * sheet.createRow(0); sheet.getRow(0).createCell(0).setCellValue("Hello");
		 * sheet.getRow(0).createCell(1).setCellValue("World");
		 * 
		 * sheet.createRow(1); sheet.getRow(1).createCell(0).setCellValue("Hello1");
		 * sheet.getRow(1).createCell(1).setCellValue("World1");
		 * 
		 * File file = new File(
		 * "C:\\Users\\nandish.h.r\\eclipse-workspace1\\Restful_Booker_Platform\\src\\test\\resources\\ExcelFiles\\Test2.xls"
		 * ); FileOutputStream fos = new FileOutputStream(file); workbook.write(fos);
		 * workbook.write(file); workbook.close();
		 */
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TestSheet");
		
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("Hello");
		sheet.getRow(0).createCell(1).setCellValue("World");
		
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("Hello1");
		sheet.getRow(1).createCell(1).setCellValue("World1");
		
		File file = new File("C:\\Users\\nandish.h.r\\eclipse-workspace1\\Restful_Booker_Platform\\src\\test\\resources\\ExcelFiles\\Test3.xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		//workbook.write(file);
		workbook.close();
	}

}
