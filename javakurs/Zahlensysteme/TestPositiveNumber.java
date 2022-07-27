package javakurs.Zahlensysteme;

import java.util.HashMap;

/**
 * Testklasse f�r die Klasse PositiveNumber
 * @author lmey
 *
 */
public class TestPositiveNumber {

	public static void main(String[] args) {
		
		PositiveNumber zs = new PositiveNumber();
		zs.setDecimal("228");
		System.out.println("Binaer: " + zs.getBinary());
		System.out.println("Hex: " + zs.getHexadecimal());

		//zs.setHexadecimal("affe");
		//System.out.println("Dezimal: " + zs.getDecimal());
		//zs.setBinary("1000101011");
		//System.out.println("Hexadezimal: " + zs.getHexadecimal());
	}

}
