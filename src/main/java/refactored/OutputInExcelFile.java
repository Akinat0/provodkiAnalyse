package refactored;


import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OutputInExcelFile {

	final static String SHEET_NAME = "Проводки"; 
	
	
		
	private static int rowAmount = 0;
	

	public static XSSFWorkbook book;
	private static XSSFSheet sheet;

	public OutputInExcelFile() {
		 book = new XSSFWorkbook();
		 sheet = book.createSheet(SHEET_NAME);
		 sheet.createRow(rowAmount);
	}
	
	public static void WriteRow(Row row) {
		row = sheet.createRow(rowAmount);
		rowAmount++;
	}
	
	
	
}
