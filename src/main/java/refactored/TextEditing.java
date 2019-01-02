package refactored;

import org.apache.poi.ss.usermodel.Row;

public class TextEditing {
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

	public void processing(Row row) {}



	private void firstRowCreating() {
		Row firstRow = null;
		firstRow.createCell(CELL_WITH_ID).setCellValue("ID");
		firstRow.createCell(CELL_WITH_SUBITEM_A).setCellValue("Subitem A");
		firstRow.createCell(CELL_WITH_SUBITEM_B).setCellValue("Subitem B");
		firstRow.createCell(CELL_WITH_DEBET).setCellValue("Debet");
		firstRow.createCell(CELL_WITH_KREDIT).setCellValue("Kredet");
		firstRow.createCell(CELL_WITH_SUM).setCellValue("Sum");
		firstRow.createCell(CELL_WITH_TEXT).setCellValue("Text");
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
	
}
