import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TextAnalyse {
	
	final static String MARK_1 = "предоплата";
	final static String MARK_2_1 = "за";
	final static String MARK_2_2 = "мед.освидетельствание";
	final static String MARK_3_1 = "дог 2712д от 01.10.2015";
	final static String MARK_3_2 = "металлоконструкции";
	final static String MARK_4 = "ндс(18%) - 18840-51";
	final static String MARK_5 = "металлоконструкции";
	
	final static int ORDER_1 = 1;
	final static int ORDER_2 = 2;
	final static int ORDER_3 = 3;
	final static int ORDER_4 = 4;
	final static int ORDER_5 = 5;
	final static int ORDER_6 = 6;
	
	private static Row row;	
	
	public static void input(Row _row) {
		row = _row;
        System.out.println("I'm in inputting");
		analyse();
	}
	
	private static void analyse() {
		
		String text = row.getCell(2).getStringCellValue();
		text = text.trim();
		text = text.toLowerCase();
		

        System.out.println(text);
        System.out.println("I'm in analysing");
        
		if (text.indexOf(MARK_1) != -1) {

	        System.out.println("I'm in mark 1");
			output(ORDER_1);
		};
		
		if ((text.indexOf(MARK_2_1) != -1) && (text.indexOf(MARK_2_2) != -1)){
			System.out.println("I'm in mark 2");
			output(ORDER_2);
		};
		
		if ((text.indexOf(MARK_3_1) != -1) && (text.indexOf(MARK_3_2) != -1)) {
			System.out.println("I'm in mark 3");
			output(ORDER_3);
		};
		
		if (text.indexOf(MARK_4) != -1) {
			System.out.println("I'm in mark 4");
			output(ORDER_4);
		};
		
		if (text.indexOf(MARK_5) != -1) {
			System.out.println("I'm in mark 5");
			output(ORDER_5);
		};
		
		
	}

	private static void output(int order) {
		switch (order) {
		case ORDER_1:
			MainClass.outFile.order_1(row);
			break;
		case ORDER_2:
			MainClass.outFile.order_2(row);
			break;
		case ORDER_3:
			MainClass.outFile.order_3(row);
			break;
		case ORDER_4:
			MainClass.outFile.order_4(row);
			break;
		case ORDER_5:
			MainClass.outFile.order_5(row);
			break;
		case ORDER_6:
			MainClass.outFile.order_6(row);
			break;
		}
	}
	
	
}
