package javakurs.Funktionen;

public class FunktionA implements Funktion {
	public double getY(double x) {
		return Math.pow(Math.E, x)-4;
	}

	public String toString() {
		return "f(x) := exp(x)-4";
	}

}
