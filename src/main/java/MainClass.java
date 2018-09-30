import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MainClass {
	final static String file = "C:\\Users\\User\\Desktop\\Проводки.xlsx"; 
	final static String fileOut = "C:\\Users\\User\\Desktop\\Выход.xlsx";	
	final static String sheet = "Вход";
	static OutputInExcelFile outFile;
	
	public static void parse(String fileName) {
	    //инициализируем потоки
	        String result = "";
	        InputStream inputStream = null;
	        XSSFWorkbook workBook = null;
	        try {
	            inputStream = new FileInputStream(fileName);
	            workBook = new XSSFWorkbook(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        outFile = new OutputInExcelFile();
	        //
	        //
	        //
	        Sheet sheet = workBook.getSheetAt(0);
	     /*   Iterator<Row> rows = sheet.iterator();
	        while(rows.hasNext()) {
	        	Row row = rows.next();
	        	Iterator<Cell> cells = row.iterator();
	        	while(cells.hasNext()) {
	        		Cell cell = cells.next();
	        		int type = cell.getCellType();
	        		switch (type) {
	        			case Cell.CELL_TYPE_STRING:
	        				System.out.print(" " + cell.getStringCellValue() + " ");
	        				break;
	        			case Cell.CELL_TYPE_NUMERIC:
	        				System.out.print(" " + cell.getNumericCellValue() + " ");
	        				break;
	        		}
	        	}
	        	System.out.println();
	        }*/
	        Iterator<Row> rows = sheet.iterator();
	        int counter = 0;
	        while(rows.hasNext() && counter < 100) {
	        	Row row = rows.next();
	        	System.out.println("I'm in parsing");
	        	TextAnalyse.input(row);
	        	counter++;
	        }
	
	        
	        
	        try (FileOutputStream out = new FileOutputStream(new File(fileOut))) {
	            outFile.book.write(out);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
        		}
	        
	public static void analyse(String fileName) {
		 WordSeparator sep = new WordSeparator();
		//Threads initialization
		String result = "";
	    InputStream inputStream = null;
	    XSSFWorkbook workBook = null;
	    
	    try {
	    	inputStream = new FileInputStream(fileName);
	        workBook = new XSSFWorkbook(inputStream);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
	    //Excel file filtering
	    Sheet sheet = workBook.getSheetAt(0);
	    Iterator<Row> rows = sheet.iterator();
	    int counter = 0;
	    while(rows.hasNext() && counter < 200) {
	    	System.out.println("Row number " + counter);
	    	Row row = rows.next();
	        System.out.println("I'm in analyse");
	        WordSeparator.input(row);
	        counter++;
	    }
	    
	    
	    System.out.println("Print words:" + WordSeparator.words.size());
	    for(int i = 0; i<WordSeparator.words.size(); i++) {
	    	System.out.print(WordSeparator.words.get(i).name + " = " + WordSeparator.words.get(i).amount + " ");
	    }
	}
	
	
	public static void main(String[] args) {
		GUI app = new GUI();
		app.setVisible(true);
		//parse(file);
	}
}
