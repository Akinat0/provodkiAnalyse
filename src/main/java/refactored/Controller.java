package refactored;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Controller {
	final static String fileName = "C:\\Users\\User\\Desktop\\��������.xlsx"; 
	final static String fileOut = "C:\\Users\\User\\Desktop\\�����.xlsx";	
	final static String sheet = "����";
	
	public WordsPreparing prep;
	public RowAnalyze analyze;
	
	static OutputInExcelFile outFile;
	
	
	/*public void parse() {
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
	        analyze = new RowAnalyze();

	     //Parsing process
	        Sheet sheet = workBook.getSheetAt(0);
	     
	        Iterator<Row> rows = sheet.iterator();
	        
	        int counter = 0;
	        
	        rows.next();
	        
	     //Separationg and analizing first 100 rows
	        while(rows.hasNext() && counter < 100) {
	        	Row row = rows.next();
	        	System.out.println("I'm in parsing");
	        	
	        	if(row.getCell(2).getStringCellValue() == null) break; //Checking, Is the row null
		    	
		        analyze.processing(row); //Go to analyze
	        	
	        	counter++;
	        }
	        
	        //Write result in out file
	        try (FileOutputStream out = new FileOutputStream(new File(fileOut))) {
	            outFile.book.write(out);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
        }
*/
	
	public void parse(String inputPath, String outputPath, Behaviour behaviour) {
	    //Flows initializing
	        String result = "";
	        InputStream inputStream = null;
	        XSSFWorkbook workBook = null;
	        try {
	            inputStream = new FileInputStream(inputPath);
	            workBook = new XSSFWorkbook(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	     //Creating an outFile instance
	        outFile = new OutputInExcelFile();
	        analyze = new RowAnalyze(behaviour);

	     //Parsing process
	        Sheet sheet = workBook.getSheetAt(0);
	     
	        Iterator<Row> rows = sheet.iterator();
	        
	        int counter = 0;
	        
	        rows.next();
	        
	     //Separationg and analizing first 100 rows
	        while(rows.hasNext() && counter < 500) {
	        	Row row = rows.next();
	        	//System.out.println("I'm in parsing");
	        	
	        	Debug.log(counter + "");
	        	if(row.getCell(2).getStringCellValue() == null) break; //Checking, Is the row null
		    	
		        analyze.processing(row); //Go to analyze
	        	
	        	counter++;
	        }
	        
	        //Write result in out file
	        try (FileOutputStream out = new FileOutputStream(new File(outputPath))) {
	            outFile.book.write(out);
	        } catch (IOException e) { 
	            e.printStackTrace();
	        }
	        
        }
	
	public WordsPreparing analyse(String fileName) {
		

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
	
	public void Generate(String pathToBehaviour, String pathToInput, String pathToOutput) throws IOException {
		Behaviour behaviour = new Behaviour();
		FileManager behFile = new FileManager(pathToBehaviour);
		String fileText = behFile.getText();
		
		behaviour.parse(fileText);
		
		behaviour.print();
		
		parse(pathToInput, pathToOutput, behaviour);
	}
}
