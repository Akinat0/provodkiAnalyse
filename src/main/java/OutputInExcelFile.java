import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OutputInExcelFile {

	final static String SHEET_NAME = "Проводки"; 
	
	final static int CELL_WITH_ID = 0;
	final static int CELL_WITH_SUBITEM_A = 1;
	final static int CELL_WITH_SUBITEM_B = 2;
	final static int CELL_WITH_DEBET = 3;
	final static int CELL_WITH_KREDIT = 5;
	final static int CELL_WITH_SUM = 7;
	final static int CELL_WITH_TEXT =8;
	
	final static int ACCOUNT_91 = 91;
	final static int ACCOUNT_90 = 90;
	final static int ACCOUNT_68 = 68;
	final static int ACCOUNT_61 = 61;
	final static int ACCOUNT_51 = 51;
	final static int ACCOUNT_41 = 41;
	final static int ACCOUNT_26 = 26;
	
	private static int rowAmount = 0;
	

	public static XSSFWorkbook book;
	private static XSSFSheet sheet;

	public OutputInExcelFile() {
		 book = new XSSFWorkbook();
		 sheet = book.createSheet(SHEET_NAME);
		 sheet.createRow(rowAmount);
		 firstRowCreating();
	}
	
	private void firstRowCreating() {
		Row firstRow = sheet.createRow(0);
		firstRow.createCell(CELL_WITH_ID).setCellValue("ID");
		firstRow.createCell(CELL_WITH_SUBITEM_A).setCellValue("Subitem A");
		firstRow.createCell(CELL_WITH_SUBITEM_B).setCellValue("Subitem B");
		firstRow.createCell(CELL_WITH_DEBET).setCellValue("Debet");
		firstRow.createCell(CELL_WITH_KREDIT).setCellValue("Kredet");
		firstRow.createCell(CELL_WITH_SUM).setCellValue("Sum");
		firstRow.createCell(CELL_WITH_TEXT).setCellValue("Text");
		rowAmount++;
	}
	
	private static int getRowID (Row inputRow) {
		return (int)inputRow.getCell(CELL_WITH_ID).getNumericCellValue();
	}
	
	private float getRowSum (Row inputRow) {
		final int INPUT_CELL_WITH_SUM = 3;
		return (float)inputRow.getCell(INPUT_CELL_WITH_SUM).getNumericCellValue();
	}
	
	private String getDebetCode(Row inputRow) {
		final int DEBET_CELL_INPUT = 5;
		return inputRow.getCell(DEBET_CELL_INPUT).getStringCellValue();
	}
	
	private String getKreditCode(Row inputRow) {
		final int KREDIT_CELL_INPUT = 6;
		String a =  inputRow.getCell(KREDIT_CELL_INPUT).getStringCellValue();
		System.out.println(a);
		return a;
	}
	
	private String getText(Row inputRow) {
		final int TEXT_CELL_INPUT = 2;
		String text =  inputRow.getCell(TEXT_CELL_INPUT).getStringCellValue();
		return text;
	}

	private boolean NDS(Row inputRow) {
		final int INPUT_CELL_WITH_TEXT = 2;
		final String NO_NDS = "ндс не облагается";
		String text = inputRow.getCell(INPUT_CELL_WITH_TEXT).getStringCellValue().toLowerCase();
		if (text.indexOf(NO_NDS) == -1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public void order_1(Row inputRow) {
		System.out.println("I'm in order");
		final int ORDER_1_SUBITEM_VALUE = 1;
		final int ORDER_1_THIRD_KEY_VALUE = 1;	
		final int DEBET_CELL_INPUT = 5;
		final int KREDIT_CELL_INPUT = 6;
		Row currentRow = sheet.createRow(rowAmount);
		rowAmount++;
		currentRow.createCell(CELL_WITH_ID).setCellValue(getRowID(inputRow));
		currentRow.createCell(CELL_WITH_SUBITEM_A).setCellValue(ORDER_1_SUBITEM_VALUE);
		currentRow.createCell(CELL_WITH_SUBITEM_B).setCellValue(ORDER_1_THIRD_KEY_VALUE);
		if (inputRow.getCell(DEBET_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(ACCOUNT_61);
		}else {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(getDebetCode(inputRow));
		};
		
		if (inputRow.getCell(KREDIT_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(ACCOUNT_51);
		}else {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(getKreditCode(inputRow));
		};
		currentRow.createCell(CELL_WITH_SUM).setCellValue(getRowSum(inputRow));
		currentRow.createCell(CELL_WITH_TEXT).setCellValue(getText(inputRow));
		
	}
	public void order_2(Row inputRow) {
		System.out.println("I'm in order 2");
		final int ORDER_2_SUBITEM_VALUE = 2;
		final int ORDER_2_THIRD_KEY_VALUE = 2;	
		final int DEBET_CELL_INPUT = 5;
		final int KREDIT_CELL_INPUT = 6;
		Row currentRow = sheet.createRow(rowAmount);
		rowAmount++;
		currentRow.createCell(CELL_WITH_ID).setCellValue(getRowID(inputRow));
		currentRow.createCell(CELL_WITH_SUBITEM_A).setCellValue(ORDER_2_SUBITEM_VALUE);
		currentRow.createCell(CELL_WITH_SUBITEM_B).setCellValue(ORDER_2_THIRD_KEY_VALUE);
		if (inputRow.getCell(DEBET_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(ACCOUNT_26);
		}else {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(getDebetCode(inputRow));
		};
		
		if (inputRow.getCell(KREDIT_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(ACCOUNT_61);
		}else {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(getKreditCode(inputRow));
		};
		currentRow.createCell(CELL_WITH_SUM).setCellValue(getRowSum(inputRow));
		currentRow.createCell(CELL_WITH_TEXT).setCellValue(getText(inputRow));
		
	}
	public void order_3(Row inputRow) {
		System.out.println("I'm in order 3");
		final int ORDER_3_SUBITEM_VALUE = 1;
		final int ORDER_3_THIRD_KEY_VALUE = 1;	
		final int DEBET_CELL_INPUT = 5;
		final int KREDIT_CELL_INPUT = 6;
		Row currentRow = sheet.createRow(rowAmount);
		rowAmount++;
		currentRow.createCell(CELL_WITH_ID).setCellValue(getRowID(inputRow));
		currentRow.createCell(CELL_WITH_SUBITEM_A).setCellValue(ORDER_3_SUBITEM_VALUE);
		currentRow.createCell(CELL_WITH_SUBITEM_B).setCellValue(ORDER_3_THIRD_KEY_VALUE);
		if (inputRow.getCell(DEBET_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(ACCOUNT_26);
		}else {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(getDebetCode(inputRow));
		};
		
		if (inputRow.getCell(KREDIT_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(ACCOUNT_90);
		}else {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(getKreditCode(inputRow));
		};
		currentRow.createCell(CELL_WITH_SUM).setCellValue(getRowSum(inputRow));
		currentRow.createCell(CELL_WITH_TEXT).setCellValue(getText(inputRow));
		
	}
	public void order_4(Row inputRow) {
		System.out.println("I'm in order 4");
		final int ORDER_3_SUBITEM_VALUE = 2;
		final int ORDER_3_THIRD_KEY_VALUE = 2;	
		final int DEBET_CELL_INPUT = 5;
		final int KREDIT_CELL_INPUT = 6;
		Row currentRow = sheet.createRow(rowAmount);
		rowAmount++;
		currentRow.createCell(CELL_WITH_ID).setCellValue(getRowID(inputRow));
		currentRow.createCell(CELL_WITH_SUBITEM_A).setCellValue(ORDER_3_SUBITEM_VALUE);
		currentRow.createCell(CELL_WITH_SUBITEM_B).setCellValue(ORDER_3_THIRD_KEY_VALUE);
		if (inputRow.getCell(DEBET_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(ACCOUNT_90);
		}else {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(getDebetCode(inputRow));
		};
		
		if (inputRow.getCell(KREDIT_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(ACCOUNT_68);
		}else {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(getKreditCode(inputRow));
		};
		float sum = getRowSum(inputRow);
		sum = (float) (sum / 1.18f * 0.18f);
		currentRow.createCell(CELL_WITH_SUM).setCellValue(sum);
		currentRow.createCell(CELL_WITH_TEXT).setCellValue(getText(inputRow));
	}
	public void order_5(Row inputRow) {
		System.out.println("I'm in order 5");
		final int ORDER_3_SUBITEM_VALUE = 3;
		final int ORDER_3_THIRD_KEY_VALUE = 3;	
		final int DEBET_CELL_INPUT = 5;
		final int KREDIT_CELL_INPUT = 6;
		Row currentRow = sheet.createRow(rowAmount);
		rowAmount++;
		currentRow.createCell(CELL_WITH_ID).setCellValue(getRowID(inputRow));
		currentRow.createCell(CELL_WITH_SUBITEM_A).setCellValue(ORDER_3_SUBITEM_VALUE);
		currentRow.createCell(CELL_WITH_SUBITEM_B).setCellValue(ORDER_3_THIRD_KEY_VALUE);
		if (inputRow.getCell(DEBET_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(ACCOUNT_90);
		}else {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(getDebetCode(inputRow));
		};
		
		if (inputRow.getCell(KREDIT_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(ACCOUNT_41);
		}else {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(getKreditCode(inputRow));
		};
		currentRow.createCell(CELL_WITH_SUM).setCellValue(0);
		currentRow.createCell(CELL_WITH_TEXT).setCellValue(getText(inputRow));
		
	}
	public void order_6(Row inputRow) {
		System.out.println("I'm in order 6");
		final int ORDER_3_SUBITEM_VALUE = 4;
		final int ORDER_3_THIRD_KEY_VALUE = 3;	
		final int DEBET_CELL_INPUT = 5;
		final int KREDIT_CELL_INPUT = 6;
		Row currentRow = sheet.createRow(rowAmount);
		rowAmount++;
		currentRow.createCell(CELL_WITH_ID).setCellValue(getRowID(inputRow));
		currentRow.createCell(CELL_WITH_SUBITEM_A).setCellValue(ORDER_3_SUBITEM_VALUE);
		currentRow.createCell(CELL_WITH_SUBITEM_B).setCellValue(ORDER_3_THIRD_KEY_VALUE);
		if (inputRow.getCell(DEBET_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(ACCOUNT_90);
		}else {
			currentRow.createCell(CELL_WITH_DEBET).setCellValue(getDebetCode(inputRow));
		};
		
		if (inputRow.getCell(KREDIT_CELL_INPUT).getStringCellValue().isEmpty() ) {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(ACCOUNT_91);
		}else {
			currentRow.createCell(CELL_WITH_KREDIT).setCellValue(getKreditCode(inputRow));
		};
		currentRow.createCell(CELL_WITH_SUM).setCellValue(0);
		currentRow.createCell(CELL_WITH_TEXT).setCellValue(getText(inputRow));
		
	}	
}
