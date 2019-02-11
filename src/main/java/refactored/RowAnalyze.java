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

	private Behaviour beh;
	
	public RowAnalyze(Behaviour behaviour) {
		beh = behaviour;
		beh.print();
	}
	
	
	public void processing(Row row) {
		
		String[] cells = new String[5]; //Init
		
		cells[0] = row.getCell(CELL_WITH_ID).toString(); //Index

		cells[1] = row.getCell(CELL_WITH_TEXT).getStringCellValue(); //Text
		
		String incOrExp = incomeOrExpense(row.getCell(CELL_WITH_KREDIT), row.getCell(CELL_WITH_DEBET));
		cells[2] = incOrExp; //Is that income or expense
		
		cells[3] = row.getCell(CELL_WITH_SUM).toString(); //Sum
		
		cells = NDS(cells.clone());
		
		cells = BehAnalyze(cells.clone());
		
		for(int i=0; i < cells.length; i++) {
			if (cells[i] == null) cells[i] = ""; 	//Fill null cells with void values
		}
		
		
		
		OutputInExcelFile.WriteRow(cells);
	}

	private String[] BehAnalyze(String[] cells) {
		
		Sign sign = null;
		float restSum = 0;
		if(cells[Constants.Expense].equals("Расход")) {
			//Взяв вместо Sign list из sign'ов можно перейти к комплексности (И вместо if сделав while)
			sign = beh.Find(cells[Constants.Text]);
		}
		if(sign != null) {
			restSum += CreateBehRow(cells.clone(), sign);
		}
		cells[Constants.Sum] = (Float.valueOf(cells[Constants.Sum]) - restSum) + "";
		
		return cells;
	}
	
	
	
	private String[]  NDS(String[] cells) {
		final int INPUT_CELL_WITH_TEXT = 1;
		final String NO_NDS = "ндс не облагается";
		String text = cells[INPUT_CELL_WITH_TEXT].toLowerCase();
		if (text.indexOf(NO_NDS) == -1) { // There is NDS
			CreateNDSRow(cells.clone());
			cells[Constants.Sum] = (Float.valueOf(cells[Constants.Sum]) - calculateNDS(Float.valueOf(cells[Constants.Sum]))) + "";
			return cells; 
		}else {
			return cells;
		}
	}
	private float CreateBehRow(String[] inputCells, Sign sign) {
		
		float newSum = sign.calculate(Float.valueOf(inputCells[Constants.Sum]));
		
		inputCells[Constants.Sum] = newSum + "";
		
		
		for(int i=0; i < inputCells.length; i++) {
			if (inputCells[i] == null) inputCells[i] = ""; 	//Fill null cells with void values
		}
		
		inputCells[4] = "User programm " + sign.signVector;
		
		
		OutputInExcelFile.WriteRow(inputCells);
		
		inputCells[4] = "";
	
		return newSum;
	}
	
	private void CreateNDSRow(String[] inputCells) {
		
		inputCells[Constants.Sum] = calculateNDS(Float.valueOf(inputCells[Constants.Sum])) + "";
		
		
		for(int i=0; i < inputCells.length; i++) {
			if (inputCells[i] == null) inputCells[i] = ""; 	//Fill null cells with void values
		}
		
		inputCells[4] = "НДС";
		
		OutputInExcelFile.WriteRow(inputCells);
		
		inputCells[4] = "";
	}
	

	private float calculateNDS(float sum) {
		float pureSum = sum/1.18f; //Pure sum value
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
		return a;
	}
	
	private String getText(Row inputRow) {
		final int TEXT_CELL_INPUT = 2;
		String text =  inputRow.getCell(TEXT_CELL_INPUT).getStringCellValue();
		return text;
	}
	
	public String incomeOrExpense(Cell kredit, Cell debet) {
		if(debet.toString().equals("")) {
			
			if(kredit.toString().equals("")) return "Брак";
			return "Расход";
		}
		return "Доход";
		}
}

class Constants{
	final static int size = 5;
	final static int ID = 0;
	final static int Text = 1;
	final static int Expense = 2;
	final static int Sum = 3;
	final static int nds = 4;
	
	
}
