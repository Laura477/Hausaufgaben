package javakurs;

import java.util.Arrays;

public class Zifferhaeufigkeit {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getDigitCount(-1234444409)));
	}

	public static int[] getDigitCount(int n) {
		int[] zifferzahl = new int[10];
		String str_n = Integer.toString(Math.abs(n));
		System.out.println(str_n);
		for (int ziffer = 0; ziffer < 10; ziffer++) {
			for (int s = 0; s < str_n.length(); s++) {
				if (Integer.parseInt(""+str_n.charAt(s)) == ziffer) {
					zifferzahl[ziffer]+=1;
				}
			}
		}
		return zifferzahl;
	}
}
//Alternative: Modulo und durch 10 teilen zum Abspalten
//alternativ mit char array udn Character.getNumericValue

//test
//System.out.println("Ziffer: "+ziffer+" Stelle im String: "+s);
//System.out.println(str_n.charAt(s));
//System.out.println(Integer.parseInt(""+str_n.charAt(s)) == ziffer);