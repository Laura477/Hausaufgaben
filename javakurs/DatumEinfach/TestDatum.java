package javakurs.DatumEinfach;

public class TestDatum {

	public static void main(String[] args) {
		Datum test = new Datum(29,2,2020);

		System.out.println(test);
		System.out.println(test.morgen());
		System.out.println(test.gestern());


	}

}
