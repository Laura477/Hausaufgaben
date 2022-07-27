
package algorithmen;

import java.util.Arrays;

/**
 * Provides a solution to the popular queens problem of position n queen figures on a nxn chess board so that they cannot kill each other
 */
public class Damenproblem {

	/**
	 * Hauptmethode für die Rekursion. Lösung im als int array, wobei jeder Index für eine Spalte steht und der zugehörige Wert für eine Reihe
	 * auf dem Schachbrett 
	 * @param brettgroesse int
	 */
	public static void damenProblem(int brettgroesse) {
		int[] brett = new int[brettgroesse];
		damenProblem_rekursion(brett, 0);
	}

	/**
	 * Hilfsfunktion f�r die Rekursion: prüfe für jede Spalte, ob Dame in der nächsten Reihe gesetzt werden kann; wenn ja, gehe 
	 * eine Spalte weiter und rufe die Funktion für diese nächste Spalte auf.
	 * Rekursionsabbruch wenn die letzte Spalte erfolgreich besetzt wurde, dann wird das Ergebnis ausgegeben
	 * 
	 * @param brett
	 * @param col
	 */
	private static void damenProblem_rekursion(int[] brett, int col) {
		if (col >= brett.length) {
			System.out.println(Arrays.toString(brett));
		}
		for (int row = 0; row < brett.length; row++) {
			if (checkDamenposition(brett, row+1, col)) {
				brett[col] = row+1;
				damenProblem_rekursion(brett, col + 1);
			}
		}
	}

	/**
	 * checks if given solution works so that no queen can beat each other (neither
	 * vertically/horizontally nor diagonally)
	 * 
	 * @param damenpositionen int array of row number where queens are placed in
	 *                        each column
	 * @return boolean true iff the solution works, false if queens can beat each
	 *         other
	 */
	public static boolean checkDamenposition(int[] damenpositionen, int row, int col) {
		//damenpositionen[col] = row;
		boolean isOK = true;

		for (int i = 0; i < col ; i++) { //damenpositionen.length
				if (damenpositionen[i] == row) { 
					isOK = false;
				}
				// check for diagonals
				if (Math.abs(damenpositionen[i] - row) == Math.abs(row-col)) { 
					isOK = false;

				}
				//}
			//}

		}

		return isOK;
	}

	public static void main(String[] args) {
		damenProblem(6);
	}

}
