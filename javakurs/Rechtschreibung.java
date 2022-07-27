package javakurs;

public class Rechtschreibung {
	public static void main(String[] args) {
		System.out.println(newGermanOrthography("Scheibenkleister rauscht im Busch."));
		System.out.println(newGermanOrthography("SchalksSchlesch."));
		System.out.println(newGermanOrthography("Neue deutsche Rechtschreibung"));
	}

	public static String newGermanOrthography(String s) {
		String ausgabe = "";
		ausgabe += s.charAt(0);

		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == 'c' 
					&& s.charAt(i + 1) == 'h' 
					&& (s.charAt(i - 1) == 's' || s.charAt(i - 1) == 'S')) {
				continue;
			} else {
				ausgabe += s.charAt(i);
			}
		}
		ausgabe += s.charAt(s.length() - 1);
		return ausgabe;
	}
}
//alternativ split
