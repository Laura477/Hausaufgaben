package javakurs.DatumEinfach;

public class Datum {
	public static final int[] MONATSLAENGEN = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private int tag;
	private int monat;
	private int jahr;

	public Datum(int tag, int monat, int jahr) {
		// wirft im Fehlerfall eine Ausnahme (siehe Hinweise unten)
		if (jahr < 1800 || jahr > 2100) {
			throw new DateOutOfRangeException("Das Jahr muss zwischen 1800 und 2100 liegen");
		}
		if (tag <= 0 || monat <= 0 || monat > 12 || (tag > MONATSLAENGEN[monat - 1] && (isSchaltjahr(jahr) == false || monat != 2))
				|| (tag > MONATSLAENGEN[monat - 1] + 1 && (isSchaltjahr(jahr) == true && monat == 2))) {
			throw new InvalidDateException("Ung�ltige Kombination von Tag/Monat/Jahr");
		}
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;
	}

	public static int getMonatslaenge(int monat, int jahr) {
		// gibt Laenge des Monats zurueck, beruecksichtigt Schaltjahre
		if ( monat == 2 && isSchaltjahr(jahr)) {
			return MONATSLAENGEN[monat - 1] + 1;
		} else {
			return MONATSLAENGEN[monat - 1];
		}
	}

	public static boolean isSchaltjahr(int jahr) {
		// gibt true zurueck, wenn das uebergebene Jahr ein Schaltjahr
		// ist, ansonsten false (siehe Hinweise unten)
		boolean isSchaltjahr = false;
		if (jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0)) {
			isSchaltjahr = true;
		}
		return isSchaltjahr;
	}

	public boolean equals(Datum a) {
		// ueberprueft, ob this und a das gleiche Datum darstellen
		return (this.jahr == a.jahr && this.monat == a.monat && this.tag == a.tag);
	}

	public boolean isGleicherTag(Datum a) {
		// ueberprueft, ob Tag und Monat gleich sind
		// (ohne Beruecksichtigung des Jahres)
		return (this.monat == a.monat && this.tag == a.tag);
	}

	public String toString() {
		// gibt eine passende String-Darstellung des Datums zurueck
		return "Datum: " + this.tag + "/" + this.monat + "/" + this.jahr; //besser: String.format("%02d.%02d.%4d", tag, monat, jahr)
	}

	public Datum morgen() {
		// gibt das Datum von this + 1 Tag zurueck
		Datum morgen = new Datum(this.tag, this.monat, this.jahr);
		if (this.tag != MONATSLAENGEN[this.monat - 1] && (monat!=2||isSchaltjahr(jahr)==false)) {
			morgen.tag++;
		}else if (this.tag != MONATSLAENGEN[this.monat - 1]+1 && this.monat == 2 && isSchaltjahr(jahr)==true) {
			morgen.tag++;
		} else if (this.monat != 12) {
			morgen.monat++;
			morgen.tag = 1;
		} else if (this.monat == 12 && this.jahr != 2100) {
			morgen.monat = 1;
			morgen.tag = 1;
			morgen.jahr++;
		} else {
			throw new DateOutOfRangeException("Das Jahr muss zwischen 1800 und 2100 liegen");
		}
		return morgen;
	}

	public Datum gestern() {
		// gibt das Datum von this - 1 Tag zurueck
		Datum gestern = new Datum(this.tag, this.monat, this.jahr);
		if (this.tag != 1) {
			gestern.tag--;
		} else if (this.monat != 1 && isSchaltjahr(this.jahr) == false) {
			gestern.monat--;
			gestern.tag = MONATSLAENGEN[gestern.monat - 1];
		} else if (this.monat == 3 && isSchaltjahr(this.jahr) == true) {
			gestern.monat--;
			gestern.tag = MONATSLAENGEN[gestern.monat - 1] + 1;
		} else if (this.monat == 1 && this.jahr != 1800) {
			gestern.monat = 12;
			gestern.tag = MONATSLAENGEN[this.monat - 1];
			gestern.jahr--;
		} else {
			throw new DateOutOfRangeException("Das Jahr muss zwischen 1800 und 2100 liegen");
		}
		return gestern;
	}
}
