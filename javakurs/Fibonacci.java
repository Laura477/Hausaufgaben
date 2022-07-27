package javakurs;

public class Aufgabe4_7_Fibonacci {
	public static void main(String[] args) {
		System.out.println(getFibonacciNumber(1));
	}

	public static int getFibonacciNumber(int n) {
		if (n < 1) {
			throw new ArithmeticException("Zahl kleiner 1!");
		} else {
			int fibonacci0 = 0;
			int fibonacci1 = 1;
			int fibonacci2 = fibonacci0+fibonacci1;
			for (int i = 3; i <= n; i++) {
				fibonacci0 = fibonacci1;
				fibonacci1 = fibonacci2;
				fibonacci2 = fibonacci0+fibonacci1;
			}
			return fibonacci2;
		}
	}
}
//Alternative a = 0, b=1, for Schleife, immer das gr��ere zum kleineren addieren