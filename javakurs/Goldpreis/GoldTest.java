package javakurs.Goldpreis;

import java.io.FileNotFoundException;

/**
 * GoldTest ist die Testklasse f�r die Klasse Goldpreis mit der Hilfsklasse Goldtagespreis.
 * 
 * @author lmey
 *
 */
public class GoldTest {

	/**
	 * Das ist die Testmethode. Der Inhalt ist aus dem Hausaufgabenblatt 2 kopiert.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Goldpreis test = new Goldpreis("gold.txt"); // eventuell anderer Pfad
			System.out.println(test.getPreis("2009-10-20")); // 22870.0
			System.out.println(test.getPreis("2009-02-07")); // -1
			test.printMinMax();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		}
	}

}
