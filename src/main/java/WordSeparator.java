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
		
		String[] localWords = text.split("\\s+"); //Splitting by spaces
		
		for(int i = 0; i < localWords.length; i++) {
			String requiredWord = localWords[i]; 

			if(words.size() == 0) {
				System.out.println("First element");
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
		makeReadable();
	}

	WordSeparator(){
		words = new ArrayList<Word>();
	}
	
	public static String[] makeReadable() {
		
		int totalWords = 0;
		for(int i=0; i<words.size(); i++) {
			totalWords += words.get(i).amount;
		}
		
		
		int totalUniquelWords = words.size();
		
		String [] array = new String[totalUniquelWords];
		
		for(int i = 0; i < totalUniquelWords; i++) {
			
			array[i] = words.get(i).name + " - " + words.get(i).amount + "  // " + ((float)words.get(i).amount/totalWords)*100.f + "%";
		//	System.out.println(array[i]);
		}
	
		
		return array;
		
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
