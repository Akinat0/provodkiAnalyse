import java.util.ArrayList;
import java.util.Comparator;

import org.apache.poi.ss.usermodel.Row;


public class WordSeparator {

	public static ArrayList<Word> words;
	
	private static Row row;	
	
	public static void input(Row _row){
		row = _row;
		System.out.println("I'm in inputting");
		separation();
	}
	
	
	private static void separation() { //Method separating every row singly
		
		if(row.getCell(2).getStringCellValue() == null) {
			return;
		}
		String text = row.getCell(2).getStringCellValue();
		text = text.trim();
		text = text.toLowerCase();
		
		String[] localWords = text.split("\\s+");
		System.out.println(localWords.length);
		
		for(int i = 0; i < localWords.length; i++) {
			String requiredWord = localWords[i]; 

			if(words.size() == 0) {
				System.out.println("First elemrnt");
				words.add(new Word(requiredWord)); //If it's the first word then create it independantly
			}else {
				
				for(int j = 0; j < words.size(); j++) { //If doesn't it do it in the loop
					Word w = words.get(j);
					
					if(w.name.equalsIgnoreCase(requiredWord)) {
						w.amount++;
						break;
					}
					
					if( j == words.size() - 1) { //	If the last check reached
						Word newWord = new Word(requiredWord);
						words.add(newWord);
					
					}			
				}
			}
		}
		
		words.sort((one, other) -> (-1 * Integer.compare(one.amount, other.amount)));
	}

	WordSeparator(){
		words = new ArrayList<Word>();
	}
}


class Word  {
	public String name;
	public int amount = 0;
	
	Word(String _name){
		name = _name;
		amount++;
	}
}
