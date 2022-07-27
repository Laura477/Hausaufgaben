package javakurs.Zahlwoerter;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zahlwort {
	public static String getZahlwort(int x) {
		if (x < 1 || x > 9999) {
			throw new ArithmeticException("Zahl muss zwischen 1 und 9999 liegen!");
		}

		int tausender = x / 1000;
		int hunderter = x % 1000 / 100;
		int zehner = x % 1000 % 100 / 10;
		int einer = x % 1000 % 100 % 10 / 1;

		String[] zifferwoerter = new String[] { "", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht",
				"neun" };
		String[] zehnerwoerter = new String[] { "", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechszig",
				"siebzig", "achtzig", "neunzig" };

		String zahlwort = "";

		if (tausender != 0) {
			zahlwort += zifferwoerter[tausender];
			zahlwort += "tausend";
		}

		if (hunderter != 0) {
			zahlwort += zifferwoerter[hunderter];
			zahlwort += "hundert";
		}

		if (einer != 0) {
			if (zehner == 0 && einer == 1) {
				zahlwort += "eins";
			} else if (zehner == 1) {
				if (einer == 6) {
					zahlwort += "sech";
				} else if (einer == 7) {
					zahlwort += "sieb";
				}
			} else if (!(zehner == 1 && (einer == 1 || einer == 2))) {
				zahlwort += zifferwoerter[einer];
			}
		}

		if (zehner != 0) {
			if (zehner == 1) {
				if (einer == 1) {
					zahlwort += "elf";
				} else if (einer == 2) {
					zahlwort += "zwoelf";
				} else {
					zahlwort += zehnerwoerter[zehner];
				}
			} else {
				if (einer != 0) {
					zahlwort += "und";
				}
				zahlwort += zehnerwoerter[zehner];
			}
		}

		return zahlwort;
	}

	public static Stream<String> getZahlStream(int start, int stop) {
		Stream<String> s = IntStream.rangeClosed(start, stop).mapToObj((int i) -> getZahlwort(i));
		return s;
	}
}
