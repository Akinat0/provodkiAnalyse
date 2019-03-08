package refactored;

import java.util.ArrayList;

public class Behaviour {
	
	protected final String BEHAVIOUR_START = "Behaviour<";
	protected final String BEHAVIOUR_END = ">";
	
	//Sigs contains in that behaviour
	private ArrayList<Sign> signs;
	
	public Sign Find(String text) {
		Debug.log("I've been in Find");
		Debug.log("Now i'll try to find smth in text: " + text);
		for(int i=0; i<signs.size(); i++) {
			Sign curSign = signs.get(i);
			Debug.log(curSign.signVector.toString());
			if(curSign.findInSign(text)) return curSign ;
		}
		Debug.log("I didn't find suitable sign");
		return null;
	}
	
	public void parse(String text) {
		signs = new ArrayList<>();
		while(text.contains(BEHAVIOUR_START)) {  
			
			int start = text.indexOf(BEHAVIOUR_START) + BEHAVIOUR_START.length();
			int end = text.indexOf(BEHAVIOUR_END);
			String behText = text.substring(start, end);
			
			Sign sign = new Sign();
			
			sign.readSign(behText);
			sign.readForm(behText);
			
			signs.add(sign);
			
			text = text.substring(end + 1); //Removing of used text
		}
	}
	
	public void print() {
		for(int i=0; i< signs.size(); i++) {
			signs.get(i).printSign();
		}
	}

	public int getSize() {
		if(signs != null) {
			return signs.size();
		}
		Debug.log("Sign Vector is null");
		return (Integer) null;
	}
}



class Sign{
	protected final String SIGN_START = "Sign(";
	protected final String SIGN_END = ")";
	protected final String FORM_START = "Form(";
	protected final String FORM_END = ")";
	
	ArrayList<String> signVector;
	String formula;
	
	public float calculate(float sum) {
		
		MathParser form = new MathParser();
		form.setVariable("s", (double)sum);
		
		double result = 0;
		
		try {
			//
			result = form.Parse(formula);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (float)result;
	}
	
	public Sign() {
		signVector = new ArrayList<>();
	}
	
	
	public boolean findInSign(String text) {
		text = text.toLowerCase();
		for(int i=0; i< signVector.size(); i++) {
			if(!text.contains(signVector.get(i).toLowerCase())) {
				Debug.log("The text doesn't contain " + signVector.get(i));
				return false;
			}
		}
		Debug.log("Sign " + signVector.toString() + " is perfect for me!");
		return true;
	}
	//Reading from file
	public void readSign(String text) {
		if(text.contains(SIGN_START)) {  
			
			int start = text.indexOf(SIGN_START) + SIGN_START.length();
			int end = text.indexOf(SIGN_END);
			
			String rule = text.substring(start, end);
			while(rule.indexOf('/') != -1) {
				int index = rule.indexOf('/');
				String sign = rule.substring(0, index);
				Debug.log(sign);
				signVector.add(sign);
				rule = rule.substring(index + 1, rule.length());
			}
			String sign = rule.substring(0, rule.length());
			signVector.add(sign);
			Debug.log("" + signVector);
			return;
		}
		return;
	}
	//Reading from file
	public void readForm(String text) {
		if(text.contains(FORM_START)) {  
			
			text = text.substring(text.indexOf(FORM_START)); //We're cutting part of text doesn't contain Form
			
			int start = text.indexOf(FORM_START) + FORM_START.length();
			int end = text.indexOf(FORM_END);
			
			formula = text.substring(start, end);
			
			return;
		}
	}
	
	
	public void printSign() {
		String vector = "";
		for(int i=0; i< signVector.size(); i++) {
			vector += signVector.get(i) + "; "; 
		}
		Debug.log(vector);
	}
	
}

class Rule{
	
}