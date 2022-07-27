package javakurs.Funktionen;

public class Test {
	public static void main(String[] args) {
		//Funktion a = (double x) -> Math.pow(Math.E, x)-4;
		Funktion a = new FunktionA();
		Funktion b = (double x) -> Math.log(Math.abs(x+1))-Math.sin(2*x)-0.5;
		Funktion c = (double x) -> x*x-Math.sin(x)-1;
		Funktion d = (double x) -> Math.pow(x, 4) + Math.pow(x, 3)-5;
		Funktion e = (double x) -> x*x-2;
		Funktion[] funktionsliste = new Funktion[] {a,b,c,d, e};
		Bisektionsverfahren bijektion = new Bisektionsverfahren();
		Sekantenverfahren sekante = new Sekantenverfahren();
		for (Funktion f : funktionsliste) {
			double n_b = bijektion.getNullstelle(f, 0.0, 10.0);
			double n_s = sekante.getNullstelle(f, 0.0, 10.0);
			//Ausgabe
			System.out.println("Funktion:\t" + f + " in (0.0, 10.0)\n"
					+ "   Nullstelle: \t"+ n_b + " (Bisektion)\n"
					+ "   Nullstelle: \t"+ n_s + " (Sekantenverfahren)\n"
					+ "--------------------------------------");

		}

	}

}
