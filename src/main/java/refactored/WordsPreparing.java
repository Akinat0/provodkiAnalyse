package refactored;

import java.util.ArrayList;
import java.util.Comparator;

import org.apache.poi.ss.usermodel.Row;


public class WordsPreparing extends Splitter {
	
	@Override
	public void input(String text){
		System.out.println("I'm in inputting");
		separation(text);
		preparing();
	}
	
	public ArrayList<Word> preparedWords;

	
	WordsPreparing(){
		super();
		preparedWords = new ArrayList<>();
	}
	
	
	private void preparing() { 
		for(int i = 0; i < words.size(); i++) {
			String requiredWord = words.get(i); 

			if(preparedWords.size() == 0) {
				System.out.println("First element");
				preparedWords.add(new Word(requiredWord)); //If it's the first word then create it independantly
			}else {
				
				for(int j = 0; j < preparedWords.size(); j++) { //If doesn't it do it in the loop
					Word w = preparedWords.get(j);
					
					if(w.name.equalsIgnoreCase(requiredWord)) {
						w.amount++;
						break;
					}
					
					if( j == preparedWords.size() - 1) { //	If the last check reached
						Word newWord = new Word(requiredWord);
						preparedWords.add(newWord);
					
					}			
				}
			}
		}
		
		preparedWords.sort((one, other) -> (-1 * Integer.compare(one.amount, other.amount)));
		makeReadable();
	}

	
	public String[] makeReadable() {
		
		int totalWords = 0;
		for(int i=0; i < preparedWords.size(); i++) {
			totalWords += preparedWords.get(i).amount;
		}
		
		
		int totalUniquelWords = preparedWords.size();
		
		String [] array = new String[totalUniquelWords];
		
		for(int i = 0; i < totalUniquelWords; i++) {
			
			array[i] = preparedWords.get(i).name + " - " + preparedWords.get(i).amount + "  // " + ((float)preparedWords.get(i).amount/totalWords)*100.f + "%";
		
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