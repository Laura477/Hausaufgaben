package javakurs;

public class Lueckentext {
	public static void main (String[] args) {
		System.out.println(clozeText("Es war einmal vor langer Zeit"));
	}
	
	public static String clozeText(String s) {
		String ausgabe ="";	
		for (int i=0; i<s.length(); i++) {
			if ((i+1)%4 ==0) {
				ausgabe += " ";
			} else {
				ausgabe += s.charAt(i);
			}
		}
		return ausgabe;
	}
}
