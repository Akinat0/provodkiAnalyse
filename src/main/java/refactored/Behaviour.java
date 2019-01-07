package refactored;

import java.util.ArrayList;

public class Behaviour {
	
}

class Sign{
	ArrayList<String> signVector;
	
	public boolean find(String text) {
		for(int i=0; i< signVector.size(); i++) {
			if(!text.contains(signVector.get(i))) {
				return false;
			}
		}
		return true;
	}
}
