package javakurs.Zahlensysteme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map.Entry;

/**
 * Klasse, die eine positive Zahl abspeichert, die als Dezimal-, Bin�r-, oder
 * Hexadezimalzahl �bergeben werden kann und in jedem der 3 Formate wieder
 * ausgegeben werden kann.
 * 
 * @author lmey
 *
 */
public class PositiveNumber {
	/**
	 * Zahlenwert als integer zwischengespeichert
	 */
	private int value;

	/**
	 * Wandelt einen �bergebenen String in eine Dezimalzahl um und speichert diese
	 * 
	 * @param String s (enth�lt Dezimalzahl)
	 */
	public void setDecimal(String s) {
		int v;
		try {
			v = Integer.parseInt(s);
		} catch (NumberFormatException n) {
			throw new NumberFormatException("Format is not a number.");
		}

		if (v < 0 || v > Integer.MAX_VALUE) {
			throw new ArithmeticException("Number is not positive.");
		}
		value = v;
	}

	/**
	 * Wandelt einen �bergebenen String in eine Hexadezimalzahl um, konvertiert
	 * diese als Dezimalzahl und speichert diese im int Attribut
	 * 
	 * @param String s
	 */
	public void setHexadecimal(String s) {
		// Erstelle einen Array aus den einzelnen Ziffern und Buchstaben im
		// Upper case aus dem Eingabestring
		char[] charArray = s.toUpperCase().toCharArray();

		// Dictionary, das allen m�glichen Charactern eine int Zahl zur
		// Berechnung im 16er System zuweist
		HashMap<Character, Integer> hex = new HashMap<Character, Integer>();
		for (int i = 1; i < 10; i++) {
			hex.put((char) (i + 48), i); // 1-9
		}
		for (int i = 10; i < 16; i++) {
			hex.put((char) (i + 55), i); // A-F -> 10-15
		}

		int hexzahl = 0;

		// Loop �ber alle Zeichen des Eingabestrings, Exception bei unerlaubten
		// Zeichen, und errechnet int zahl aus Multiplikation mti 16er Potenzen
		for (int i = 0; i < charArray.length; i++) {
			if (hex.get(charArray[charArray.length - 1 - i]) == null) {
				throw new NumberFormatException("Not a valid number.");
			}
			hexzahl += Math.pow(16, i) * hex.get(charArray[charArray.length - 1 - i]);
		}

		// check range
		if (hexzahl < 0 || hexzahl > Integer.MAX_VALUE) {
			throw new ArithmeticException("Number is not positive.");
		}

		value = hexzahl;
	}

	/**
	 * Wandelt einen �bergebenen String in eine Bin�rzahl um, konvertiert diese als
	 * Dezimalzahl und speichert diese im int Attribut
	 * 
	 * @param String s
	 */
	public void setBinary(String s) {
		// Eingabestring als Zeichenarray durchlaufen und in Integer
		// 1er und 0en speichern
		char[] charArray = s.toCharArray();
		int[] arr = new int[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '1') {
				arr[i] = 1;
			} else if (charArray[i] == '0') {
				arr[i] = 0;
			} else {
				throw new NumberFormatException("Not a valid number.");
			}
		}

		//Umrechnung in Dezimalzahl �ber Zweierpotenzen
		int binzahl = 0;
		for (int i = 0; i < arr.length; i++) {
			binzahl += Math.pow(2, i) * arr[arr.length - 1 - i];
		}

		// range check
		if (binzahl < 0 || binzahl > Integer.MAX_VALUE) {
			throw new ArithmeticException("Number is not positive.");
		}

		value = binzahl;

	}

	/**
	 * Dezimalzahl zur�ckgeben
	 * @return String s
	 */
	public String getDecimal() {
		return String.valueOf(value);
	}

	/**
	 * Zahl als Hexadezimalzahl ausgeben
	 * @return String s
	 */
	public String getHexadecimal() {
		String hex_output = "";
		ArrayList<Integer> reste = new ArrayList<>();
		int rest = value;
		//Umrechnung in Hexadezimalzahl �ber die Reste der Division mit 16
		reste.add(rest % 16); // TODO
		while (rest / 16 != 0) {
			rest = rest / 16;
			reste.add(rest % 16);
		}
		Collections.reverse(reste);

		// dictionary to store int values for char characters
		HashMap<Character, Integer> hex = new HashMap<Character, Integer>();
		for (int i = 1; i < 10; i++) {
			hex.put((char) (i + 48), i);
		}
		for (int i = 10; i < 16; i++) {
			hex.put((char) (i + 55), i);
		}

		// Rechne Reste in Hexadezimal-Zeichen um 
		for (int i = 0; i < reste.size(); i++) {
			hex_output += getKeyByValue(hex, reste.get(i));
		}

		return hex_output;

	}

	/**
	 * Hilfsmethode, um Key zum Value aus Hashmaps zu bekommen
	 * @param Hashmap codemap
	 * @param int value
	 * @return Character key
	 */
	public static Character getKeyByValue(HashMap<Character, Integer> codemap, int value) {
		for (Entry<Character, Integer> entry : codemap.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * Bin�rzahl zur�ckgeben
	 * @return String
	 */
	public String getBinary() {
		String bin_output = "";
		ArrayList<Integer> reste = new ArrayList<>();
		int rest = value;
		//Divisionsalgorithmus
		reste.add(rest % 2); // TODO
		while (rest / 2 != 0) {
			rest = rest / 2;
			reste.add(rest % 2);
		}
		Collections.reverse(reste);

		//in String umwandeln
		for (int i = 0; i < reste.size(); i++) {
			if (reste.get(i) == 1) {
				bin_output += "1";
			} else {
				bin_output += "0";
			}
		}

		return bin_output;
	}

}

