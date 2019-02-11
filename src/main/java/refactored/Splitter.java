package refactored;

import java.util.ArrayList;
import java.util.Arrays;


public class Splitter {
	
	protected ArrayList<String> words;
	
	public void input(String text){
		if(text == null || text == "") return;
		separation(text);
	}
	
	
	public static String[] toArray(String text) {
		text = text.trim();
		text = text.toLowerCase();
		
		String[] wordsArray = text.split("\\s+"); //Splitting by spaces
		
		return wordsArray;
	}
	
	protected void separation(String text) { //Method separating every row singly
		
		text = text.trim();
		text = text.toLowerCase();
		
		String[] localWords = text.split("\\s+"); //Splitting by spaces
		//words.addAll((ArrayList<String>) Arrays.asList(localWords));
		for(int i = 0; i < localWords.length; i++) {
			words.add(localWords[i]);
		}
	}
	
	Splitter(){
		words = new ArrayList<String>();  //Simple constructor
	}

}
