package refactored;

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


public class Main {

	public static void main(String[] args) {
		//Initializing GUI
		GUI app = new GUI();
	app.setVisible(true);

		/*String kindOfText = "время вытаскивать/кальмаров/из/ytn/vods off//" ;
		Sign sign = new Sign();
		sign.read(kindOfText);
		for(int i = 0; i < sign.signVector.size(); i++) {
			Debug.log(sign.signVector.get(i));
		}*/
		/*
		String[] formulas = new String[] { "2+2*2", "2+X*2", "sin(90)+4-cos(0)", "2--4"};
        MathParser p = new MathParser();
        p.setVariable("X", 2.0 );
        for( int i = 0; i < formulas.length; i++){
            try{
                System.out.println( formulas[i] + "=" + p.Parse( formulas[i] ) );
            }catch(Exception e){
                System.err.println( "Error while parsing '"+formulas[i]+"' with message: " + e.getMessage() );
            } 
        }
        */
		
	}
}
