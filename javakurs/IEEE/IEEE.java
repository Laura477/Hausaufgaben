package javakurs.IEEE;

public class IEEE {
	// Wandelt IEEE 754-Zahl in float
	// Form des Eingabeparameters:
	// Bsp: 0/01111111/00000000000000000000000
	// ergibt 1.0f
	public static float fromIEEEToFloat(String eingabe) {
		String[] splitted_eingabe = eingabe.split("/");

		// Exponent
		String exponent = splitted_eingabe[1]; //StringBuilder!!! StringBuilder sb = new StringBuilder(); sb.append(split); sb.reverse; schleife �ber zeic
		int e = 0;
		for (int i = exponent.length() - 1; i >= 0; i--) {
			e += ((int) exponent.charAt(i) - 48) * Math.pow(2, exponent.length() - 1 - i);
		}
		e = e - 127; // Bias abziehen
		// System.out.println("Exponent: " + e);

		// Mantisse
		String mantisse = "1" + splitted_eingabe[2]; // hidden bit zuf�gen
		float m = 0;
		for (int i = mantisse.length() - 1; i >= 0; i--) {
			m = m / 2 + ((int) mantisse.charAt(i) - 48);
		}
		// System.out.println("Mantisse: " + m);

		// Vorzeichen und Zahl
		int vorzeichen = Integer.parseInt(splitted_eingabe[0]);
		// System.out.println("Vorzeichen: " + vorzeichen);

		float number = (float) (m * Math.pow(2, e));
		if (vorzeichen == 1) {
			number *= (-1);
		}
		return number;

	}

	// Wandelt float-Zahl in IEEE 754-Darstellung
	// Form des Rueckgabewerts:
	// Bsp: 1.0f ergibt
	// 0/01111111/00000000000000000000000
	public static String fromFloatToIEEE(float eingabe) { //siehe L�sung in Pr�sentationschannel!!!

		// Vorzeichen
		String vorzeichen = "";
		if (eingabe > 0) {
			vorzeichen = "0";
		} else if (eingabe < 0) {
			vorzeichen = "1";
		} // + - 0 nicht ber�cksichtigt

		// Zahlumwandlung ins bin�re
		int vorkommazahl =  Math.abs((int)eingabe);
		System.out.println(vorkommazahl);
		String vorkomma = Integer.toBinaryString(vorkommazahl);

		float nachkommazahl = eingabe % 1;
		String nachkomma = "";
		for (int i = 0; i < 23; i++) {
			if (nachkommazahl * 2<1) {
				nachkomma += "0";
				nachkommazahl = nachkommazahl * 2;
			} else if (nachkommazahl * 2>1) {
				nachkomma += "1";
				nachkommazahl = nachkommazahl * 2 - 1;
			}
		}

		System.out.println(vorkomma + "," + nachkomma);

		// Kommaverschiebung
		String mantisse = "";
		String exponent = "";
		if (vorkommazahl != 0) {
			int i = vorkomma.length() - 1;
			int verschieben_um = 0;
			while (vorkomma.charAt(i) != '1') {
				i--;
				verschieben_um++;
			}
			//System.out.println(""+verschieben_um+" "+vorkomma + "," + nachkomma);
			int e = verschieben_um +127;
			 exponent = String.format("%8s",Integer.toBinaryString(e)).replace(' ', '0');
			
			 mantisse = vorkomma.substring(vorkomma.length() -verschieben_um)+nachkomma;
			
		}
		else if (vorkommazahl ==0) {
			int i = 0;
			int verschieben_um = 0;
			while (nachkomma.charAt(i) != '1') {
				i++;
				verschieben_um++;
			}
			verschieben_um++;
			
			int e = -verschieben_um +127;
			//System.out.println(""+verschieben_um+" "+vorkomma + "," + nachkomma);

			 exponent = Integer.toBinaryString(e);
			
			 mantisse = nachkomma.substring(verschieben_um-1);
		}
		
		return vorzeichen +"/"+exponent+"/"+mantisse;

	}

}
