package refactored;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class RowAnalyze {
	final static int CELL_WITH_ID = 0;
	final static int CELL_WITH_DATE = 1;
	final static int CELL_WITH_TEXT =2;
	final static int CELL_WITH_SUM = 3;
	final static int CELL_WITH_KREDIT = 5;
	final static int CELL_WITH_DEBET = 6;
	
	final static int ACCOUNT_91 = 91;
	final static int ACCOUNT_90 = 90;
	final static int ACCOUNT_68 = 68;
	final static int ACCOUNT_61 = 61;
	final static int ACCOUNT_51 = 51;
	final static int ACCOUNT_41 = 41;
	final static int ACCOUNT_26 = 26;

	public void processing(Row row) {
		
		String[] cells = new String[5];
		
		cells[0] = row.getCell(CELL_WITH_ID).toString(); //Index

		cells[1] = row.getCell(CELL_WITH_TEXT).getStringCellValue(); //Text
		
		String incOrExp = incomeOrExpense(row.getCell(CELL_WITH_KREDIT), row.getCell(CELL_WITH_DEBET));
		cells[2] = incOrExp; //Is that income or expense
		
		cells[3] = row.getCell(CELL_WITH_SUM).toString(); //Sum
		
		cells = NDS(cells.clone());
		
		for(int i=0; i < cells.length; i++) {
			if (cells[i] == null) cells[i] = ""; 	//Fill null cells with void values
		}
		OutputInExcelFile.WriteRow(cells);
	}


	private String[]  NDS(String[] cells) {
		final int INPUT_CELL_WITH_TEXT = 1;
		final String NO_NDS = "��� �� ����������";
		String text = cells[INPUT_CELL_WITH_TEXT].toLowerCase();
		Debug.log(text);
		if (text.indexOf(NO_NDS) == -1) { // There is NDS
			Debug.log("NDS has been detected here");
			CreateNDSRow(cells.clone());
			cells[CELL_WITH_SUM] = (Float.valueOf(cells[CELL_WITH_SUM]) - calculateNDS(Float.valueOf(cells[CELL_WITH_SUM]))) + "";
			return cells; 
		}else {
			Debug.log("NDS hasn't been detected");
			return cells;
		}
	}
	
	private void CreateNDSRow(String[] inputCells) {
		
		inputCells[CELL_WITH_SUM] = calculateNDS(Float.valueOf(inputCells[CELL_WITH_SUM])) + "";
		
		
		for(int i=0; i < inputCells.length; i++) {
			if (inputCells[i] == null) inputCells[i] = ""; 	//Fill null cells with void values
		}
		
		inputCells[4] = "���";
		
		OutputInExcelFile.WriteRow(inputCells);
		
		inputCells[4] = "";
	}
	
	private float calculateNDS(float sum) {
		float pureSum = sum/1.18f; //Pure sum value
	//	Debug.log("Sum = " + sum + " pure sum = " + pureSum);
		return sum - pureSum;	   //NDS value	
	}  
	
	private void firstRowCreating() {
		Row firstRow = null;
		firstRow.createCell(CELL_WITH_ID).setCellValue("ID");
		firstRow.createCell(CELL_WITH_DEBET).setCellValue("Debet");
		firstRow.createCell(CELL_WITH_KREDIT).setCellValue("Kredet");
		firstRow.createCell(CELL_WITH_SUM).setCellValue("Sum");
		firstRow.createCell(CELL_WITH_TEXT).setCellValue("Text");
	}
	
	private static int getRowID (Row inputRow) {
		return (int)inputRow.getCell(CELL_WITH_ID).getNumericCellValue();
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
	
	public String incomeOrExpense(Cell kredit, Cell debet) {
		Debug.log("Debet = " + debet + ", Kredit = " + kredit );
		if(debet.toString().equals("")) {
			
			if(kredit.toString().equals("")) return "����";
			Debug.log("Expenses");
			return "������";
		}
		Debug.log("Income");
		return "�����";
		}
}
