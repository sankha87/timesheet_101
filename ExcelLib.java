package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	
public String readStringData(String sheetname, int row, int col) throws Exception{
	File f = new File(Constants.FILEPATH);
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = WorkbookFactory.create(fis);
String data = wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	return data;	
}

public double readNumericData(String sheetname, int row, int col) throws Exception{
	File f = new File(Constants.FILEPATH);
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = WorkbookFactory.create(fis);
double data = wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	return data;	
}
}
