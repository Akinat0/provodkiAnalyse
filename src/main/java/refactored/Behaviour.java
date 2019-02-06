package refactored;

import java.util.ArrayList;

public class Behaviour {
	
	protected final String BEHAVIOUR_START = "Behaviour<";
	protected final String BEHAVIOUR_END = ">";
	
	
	
	private ArrayList<Sign> signs;
	
	public void parse(String text) {
		signs = new ArrayList<>();
		while(text.contains(BEHAVIOUR_START)) {  
			
			int start = text.indexOf(BEHAVIOUR_START) + BEHAVIOUR_START.length();
			int end = text.indexOf(BEHAVIOUR_END);
			String behText = text.substring(start, end);
			
			Debug.log("Behaviour looks like that: " + behText);
			
			Sign sign = new Sign();
			
			sign.readSign(behText);
			sign.readForm(behText);
			
			signs.add(sign);
			
			text = text.substring(end + 1); //Removing of used text
		}
	}
	
	public void print() {
		Debug.log("Behavior contains " + signs.size() + " signs");
		for(int i=0; i< signs.size(); i++) {
			signs.get(i).printSign();
		}
	}
}



class Sign{
	protected final String SIGN_START = "Sign(";
	protected final String SIGN_END = ")";
	protected final String FORM_START = "Form(";
	protected final String FORM_END = ")";
	
	ArrayList<String> signVector;
	String formula;
	
	public Sign() {
		signVector = new ArrayList<>();
	}
	
	public boolean find(String text) {
		for(int i=0; i< signVector.size(); i++) {
			if(!text.contains(signVector.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public void readSign(String text) {
		if(text.contains(SIGN_START)) {  
			
			int start = text.indexOf(SIGN_START) + SIGN_START.length();
			int end = text.indexOf(SIGN_END);
			
			String rule = text.substring(start, end);
			Debug.log("Rule " + rule );
			while(rule.indexOf('/') != -1) {
				int index = rule.indexOf('/');
				String sign = rule.substring(0, index);
				signVector.add(sign);
				rule = rule.substring(index + 1, rule.length());
			}
			
			//Debug.log(text);
			return;
		}
		Debug.log("There wasn't a kind of sign");
		return;
	}
	
	public void readForm(String text) {
		if(text.contains(FORM_START)) {  
			
			text = text.substring(text.indexOf(FORM_START)); //We're cutting part of text doesn't contain Form
			
			int start = text.indexOf(FORM_START) + FORM_START.length();
			int end = text.indexOf(FORM_END);
			
			formula = text.substring(start, end);
			
			//Debug.log(rule.substring(start, end));
			return;
		}
	}
	
	
	public void printSign() {
		String vector = "";
		for(int i=0; i< signVector.size(); i++) {
			vector += signVector.get(i) + "; "; 
		}
		
		Debug.log("Sign vector: " + vector + " Form " + formula);
		
	}
	
}

class Rule{
	
}