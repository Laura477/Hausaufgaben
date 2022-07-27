package javakurs.Goldpreis;

/**
 * Diese Klasse beinhaltet die �ffentlichen Attribute datum und preis, einen Konstruktor, der den Attributen 
 * Werte zuweist, und einer toString Methode zum Auslesen. Die Klasse dient als Hilfsklasse f�r die Klasse Goldpreis.
 * 
 * @author lmey
 *
 */
public class Goldtagespreis {
	public String datum; //Format z.B. 2020-08-10
	public double preis;

	/**
	 * Der Konstruktor weist den Attributen datum und preis gegebene Werte zu
	 * 
	 * @param datum String
	 * @param preis double
	 */
	public Goldtagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Goldpreis am Tag " + datum + ": " + preis + " Euro";
	}
}