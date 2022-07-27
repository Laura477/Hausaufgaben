package javakurs;
public class Fakultaet {
	public static void main(String[] args) {
		System.out.println(getFactorial(11));
	}

	public static int getFactorial(int x) {
		if (x < 1 || x >=12) { //Factorial wird bei gro�en Zahlen zu gro� und dann l�uft es wieder unten rein 0/-
			throw new ArithmeticException("Zahl kleiner 1!");
		} else {
			int factorial = 1;
			for (int i = 2; i <= x; i++) {
				factorial *= i;
			}
			return factorial;
		}
	}
}