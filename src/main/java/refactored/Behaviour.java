package refactored;

import java.util.ArrayList;

public class Behaviour {
	private Sign sign;
	
	
}

class Sign{
	ArrayList<String> signVector;
	
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
	
	public void read(String rule) {
		while(rule.indexOf('/') != -1) {
			int index = rule.indexOf('/');
			String sign = rule.substring(0, index);
			signVector.add(sign);
			rule = rule.substring(index + 1, rule.length());
		}
	}
}

class Rule{
	
}