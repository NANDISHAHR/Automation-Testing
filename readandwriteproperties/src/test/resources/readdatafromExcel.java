import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readdatafromExcel {

	File file = new File(
			"C:\\Users\\nandish.h.r\\eclipse-workspace1\\Restful_Booker_Platform\\src\\test\\resources\\ExcelFiles\\Test3.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(1);
	/*
	 * String cellvalue = sheet.getRow(0).getCell(0).getStringCellValue();
	 * System.out.println(cellvalue);
	 */
	int rowcount = sheet.getPhysicalNumberOfRows();

	for (int i = 0; i < rowcount; i++) {
		XSSFRow row = sheet.getRow(i);

		int cellcount = row.getPhysicalNumberOfCells();
		for (int j = 0; j < cellcount; j++) {
			XSSFCell cell = row.getCell(j);
			String cellValue = getcellvalue(cell);
			System.out.print("||"+cellValue);
		}
		System.out.println();

	}
	workbook.close();
	fis.close();

}

public static String getcellvalue(XSSFCell cell) {
	switch (cell.getCellType()) {
	case NUMERIC:
		return String.valueOf(cell.getNumericCellValue());
	case BOOLEAN:
		return String.valueOf(cell.getBooleanCellValue());
	case STRING:
		return cell.getStringCellValue();
	default:
		return cell.getStringCellValue();

	}
}

}
