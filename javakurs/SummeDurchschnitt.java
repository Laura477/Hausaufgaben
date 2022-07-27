package javakurs;

import javax.swing.JOptionPane;

public class Aufgabe4_5_SummeDurchschnitt {
	public static void main(String[] args) {
		double summe = 0;
		double durchschnitt = 0;
		int zaehler = 0;
		while (true) {
			String textinput = JOptionPane.showInputDialog("Zahl:");
			double inputzahl = Double.parseDouble(textinput);
			if (inputzahl == 0) {
				break;
			}
			summe += inputzahl;
			zaehler += 1;
			durchschnitt = summe / zaehler;
		}
		System.out.println("Summe: " + summe + ", Durchschnitt: " + durchschnitt);
	}
}
