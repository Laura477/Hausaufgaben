package javakurs.Funktionen;

public class Bisektionsverfahren implements Verfahren {
	public double getNullstelle(Funktion f, double xMin, double xMax) {
		double x1 = xMin;
		double x2 = xMax;
		double xm = (x1+x2)/2;
		while(x2-x1>Math.pow(10, -10)) {
			if (Math.abs(f.getY(xm))<Math.pow(10, -10)) {
				return xm;
			}
			if (f.getY(x1)*f.getY(xm) <0) {
				x2 = xm;
			}
			if (f.getY(x2)*f.getY(xm) <0) {
				x1 = xm;
			}
			xm = (x1+x2)/2;
		}
		return xm;
	}
}
