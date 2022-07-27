package javakurs.HuffmanCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

public class Huffman {
	public static String decode(File f) throws FileNotFoundException {
		HashMap<Character, String> codemap = new HashMap<>(); 
		
		//einlesen
		String wort ="";
		Scanner sc = null;
		sc = new Scanner(f);
		int linecounter=0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			
			//Abfangen, wenn das Datenformat nicht passt
			//if ( linecounter>27) { //!(s==" ") ||!s.equals("[01]*") || 
				//throw new IllegalArgumentException("File does not match the required format");
			//}
			if ( !(s.matches("^[0-1]+")|| s.equals(""))){
				throw new IllegalArgumentException("File does not match the required format");
			}
			
			//abspeichern
			if (linecounter == 0) {
				wort = s;
			}
			else {
				if (linecounter == 28) {
					codemap.put('0', s);
				}
				if (linecounter == 30) {
					codemap.put('2', s);
				}
				if (linecounter == 27) {
					codemap.put(' ', s);
				}
				else{
					codemap.put((char)(64+linecounter), s);
				}
			}	
			
			linecounter++;

		}
		sc.close();
		
		//decoden
		String decoded ="";
		for (int i=0; i< wort.length(); i++) {
			String test = String.valueOf(wort.charAt(i));
			int j=i;
			System.out.println(test);
			while (!codemap.containsValue(test)) {
				j++;
				test=test+String.valueOf(wort.charAt(j));
			}
			decoded+=getKeyByValue(codemap, test);
			i=j;
		}		
		return decoded;

	}
	
	public static Character getKeyByValue(HashMap<Character, String> codemap,  String value) {
	    for (Entry<Character, String> entry : codemap.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}

}
