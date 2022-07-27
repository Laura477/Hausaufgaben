package javakurs.Goldpreis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Die Klasse speichert eine Liste von Goldtagespreis-Objekten aus einer Datei
 * mit festem Dateiformat, kann den Goldpreis f�r ein bestimmtes Datum
 * herausgeben und den insgesamt niedrigsten und h�chsten gespeicherten
 * Goldpreis anzeigen.
 * 
 * @author lmey
 *
 */
public class Goldpreis {
	private ArrayList<Goldtagespreis> list = new ArrayList<>();

	/**
	 * Diese Konstruktor liest eine Datei mit Tagen und Goldpreisen ein und
	 * speichert sie im Attribut list als Liste von Goldtagespreisen ab.
	 * 
	 * @param dateiname String
	 * @throws FileNotFoundException
	 */
	public Goldpreis(String dateiname) throws FileNotFoundException {
		File f = new File(dateiname); // erstellt ein File Objekt aus dem angegebenen Dateiname
		Scanner sc = new Scanner(f); // erstellt einen Scanner auf dem File Objekt

		// durchl�uft die gesamte Datei zeilenweise
		while (sc.hasNextLine()) {
			String s = sc.nextLine();

			// teilt Zeile in datum und preis auf und setzt das Datum
			String[] split = s.split("\t");
			String datum = split[0];

			/*
			 * Bei nicht vorhandenem Nachweis wird der Goldtagespreis auf -1 gesetzt, sonst
			 * wird der Wert des Strings �bernommen, wobei der Tausender-Punkt weggelassen
			 * und das Komma als Punkt interpretiert werden muss, um den String in einen
			 * Double parsen zu k�nnen.
			 */
			double preis;
			if (split[1].equals("kein Nachweis")) {
				preis = -1;
			} else {
				preis = Double.parseDouble(split[1].replace(".", "").replace(",", "."));
			}

			// speichert das Ergebnis des Auslesens als Liste von Goldtagespreisen
			Goldtagespreis goldtagespreis = new Goldtagespreis(datum, preis);
			this.list.add(goldtagespreis);
		}

		sc.close();
	}

	/**
	 * Diese getter-Methode gibt zu einem gegebenen Datums-String, der in dem
	 * gleichen Format wie im eingelesenen File sein muss, den Goldtagespreis
	 * heraus. Falls das Format nicht passt oder kein Eintrag f�r das Datum
	 * vorhanden ist, wird die Exception geworfen.
	 * 
	 * @param datum String
	 * @return preis double
	 * @throws NumberFormatException
	 */
	public double getPreis(String datum) {
		for (Goldtagespreis t : list) {
			if (t.datum.equals(datum)) {
				return t.preis;
			}
		}
		throw new NumberFormatException("Das Datum ist nicht gelistet oder das Datumsformat passt nicht!");
	}

	/**
	 * Formatiert eine gegebene Liste von Datumsangaben als String, sodass keine
	 * eckigen Klammern um die Liste rauskommen (zur internen Nutzung)
	 * 
	 * @param datumsliste ArrayList<String> //Liste muss min. ein Element haben
	 * @return output String
	 */
	private String format_Datumsliste(ArrayList<String> datumsliste) {
		String output = datumsliste.get(0);
		for (int i = 1; i < datumsliste.size(); i++) {
			output += ", ";
			output += datumsliste.get(i);
		}
		return output;
	}

	/**
	 * Diese Methode druckt den h�chsten und niedrigsten gespeicherten Goldpreis mit
	 * zugeh�rigen Tagen auf die Konsole.
	 */
	public void printMinMax() {

		// initialisiere Hilfsvariablen
		double min_preis = list.get(0).preis;
		double max_preis = list.get(0).preis;
		ArrayList<String> max_datum_list = new ArrayList<>();
		ArrayList<String> min_datum_list = new ArrayList<>();
		//String min_datum = ""; --> einfacherere Methode!!!

		// durchlaufe die Liste und speichere jeweils h�here oder niedrigere Werte ab
		for (Goldtagespreis t : list) {
			
			if (t.preis <0) {
				continue;
			}
			
			// wenn der h�chste Preis mehrfach vorkommt, erg�nze nur das Datum
			if (t.preis == max_preis) { 
				max_datum_list.add(t.datum);
			}
			// bei einem neuen h�chsten Preis starte die Datumsliste neu und setze den Preis als max
			if (t.preis > max_preis) { 
				max_datum_list.clear();
				max_datum_list.add(t.datum);
				max_preis = t.preis;
			}
			//min analog
			if (t.preis == min_preis) {
				min_datum_list.add(t.datum);
			}
			if (t.preis != -1 && t.preis < min_preis) {
				min_datum_list.clear();
				min_datum_list.add(t.datum);
				min_preis = t.preis;
			}
//			   /* bei gleichem Wert, Datum hinzuf�gen, bei niedrigerem Wert, alles �berschreiben */
//            if(t.preis < min_preis) {
//            	min_preis = t.preis;
//                min_datum = t.datum;
//            } else if(t.preis == min_preis) {
//            	min_datum += ", " + t.datum;
//            }
		}

		// min Ausgabe
		System.out.println("Den niedrigsten Goldpreis von " + min_preis + " gab es an den folgenden Tagen:\n"
				+ format_Datumsliste(min_datum_list));
		
//		System.out.println("Den niedrigsten Goldpreis von " + min_preis + " gab es an den folgenden Tagen:\n"
//				+ min_datum);


		// max Ausgabe
		System.out.println("Den hoechsten Goldpreis von " + max_preis + " gab es an den folgenden Tagen:\n"
				+ format_Datumsliste(max_datum_list));
	}

}
