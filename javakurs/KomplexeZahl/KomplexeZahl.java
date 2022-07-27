package javakurs.KomplexeZahl;

public class KomplexeZahl {
	private double re;
	private double im;
	
	//Konstruktor
	public KomplexeZahl(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	//Copy Konstruktor
	public KomplexeZahl(KomplexeZahl z) {
		this.re = z.re;
		this.im = z.im;
	}
	
	//get Realteil
	public double getRe() {
		return this.re;
	}
	
	//get Imagin�rteil
	/**
	 * @return
	 */
	public double getIm() {
		return this.im;
	}
	
	//addiere komplexe Zahl zur aktuellen Zahl

	/**
	 * @param z
	 */
	public void addiere(KomplexeZahl z) {
		this.re += z.re;
		this.im += z.im;
	}
	
	//multipliziere komplexe Zahl zur aktuellen Zahl
	public void multipliziere(KomplexeZahl z) {
		double zwischenspeicher_re = this.re; //speichert Realteil zur Verwendung bei der Im-Berechnung
		this.re = this.re*z.re-this.im*z.im;
		this.im = zwischenspeicher_re*z.im+this.im*z.re;
	}
	
	//Betrag ausrechnen
	public double getBetrag() {
		return Math.sqrt(im*im + re*re);
	}
	
	/**
	 *String Darstellung
	 */
	@Override
	public String toString() {
		String output = ""+this.re +" ";
		if (this.im == 1) {
			output+= "+ i";
		} else if (this.im >0) {
			output+= "+ " + this.im +"i";
		} else if (this.im <0) {
			output+= "- " + Math.abs(this.im) +"i";
		}
		return output;
	}
	
	/**
	 * Wurzel ausgeben
	 * @return
	 */
	public KomplexeZahl[] getWurzel() {
		KomplexeZahl Wurzel1 = new KomplexeZahl(0,0);
		KomplexeZahl Wurzel2 = new KomplexeZahl(0,0);
		KomplexeZahl[] Wurzeln = new KomplexeZahl[] {Wurzel1, Wurzel2};
		if (this.re == 0 && this.im == 0) {
			return Wurzeln; 
		}
		int signum = 1;
		if (this.im <0) {
			signum = -1;
		}
		Wurzel1.re = Math.sqrt((getBetrag()+re)/2);
		Wurzel1.im = signum * Math.sqrt((getBetrag()-re)/2);
		Wurzel2.re = -Math.sqrt((getBetrag()+re)/2);
		Wurzel2.im = -signum * Math.sqrt((getBetrag()-re)/2);
		return Wurzeln;
	}
	
	//Summe als neue Komplexe Zahl ausgeben
	public KomplexeZahl getSumme(KomplexeZahl z) {
		KomplexeZahl summe = new KomplexeZahl(z.re+this.re, z.im+this.im);
		return summe;
	}
	
	//Produkt als neue Komplexe Zahl ausgeben
	public KomplexeZahl getProdukt(KomplexeZahl z) {
		KomplexeZahl produkt = new KomplexeZahl(this.re*z.re-this.im*z.im, this.re*z.im+this.im*z.re);
		return produkt;
	}
	
	
	

	

	

}
