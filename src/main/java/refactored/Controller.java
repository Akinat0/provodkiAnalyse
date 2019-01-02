package refactored;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Controller {
	final static String fileName = "C:\\Users\\User\\Desktop\\Проводки.xlsx"; 
	final static String fileOut = "C:\\Users\\User\\Desktop\\Выход.xlsx";	
	final static String sheet = "Вход";
	
	public WordsPreparing prep;
	public TextAnalyse analyze;
	
	static OutputInExcelFile outFile;
	
	
	public void parse(String fileName) {
	    //Flows initializing
	        String result = "";
	        InputStream inputStream = null;
	        XSSFWorkbook workBook = null;
	        try {
	            inputStream = new FileInputStream(fileName);
	            workBook = new XSSFWorkbook(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	     //Creating an outFile instance
	        outFile = new OutputInExcelFile();

	     //Parsing process
	        Sheet sheet = workBook.getSheetAt(0);
	     
	        Iterator<Row> rows = sheet.iterator();
	        int counter = 0;
	        
	     //Separationg and analizing first 100 rows
	        while(rows.hasNext() && counter < 100) {
	        	Row row = rows.next();
	        	System.out.println("I'm in parsing");
	        	
	        	if(row.getCell(2).getStringCellValue() == null) break; //Checking, Is the row null
		    	
		        analyze.input(row.getCell(2).getStringCellValue()); //Go to analyze
	        	
	        	counter++;
	        }
	        
	        //Write result in out file
	        try (FileOutputStream out = new FileOutputStream(new File(fileOut))) {
	            outFile.book.write(out);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
        }

	
	public WordsPreparing analyse() {
		

		//Creating an instance of WordsPreparing
		WordsPreparing prep = new WordsPreparing();
		
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
	    while(rows.hasNext() && counter < 380) {
	    	
	    	Row row = rows.next();
	    	if(row.getCell(2).getStringCellValue() == null) break; //Checking, Is the row null
	    	
	    	
	    	
	        prep.input(row.getCell(2).getStringCellValue()); //Go to preparation
	        
	        counter++;
	    }
	    
	    return prep;
	  
	}
	
	
}
