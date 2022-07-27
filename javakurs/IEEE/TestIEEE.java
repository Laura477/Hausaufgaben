package javakurs.IEEE;

public class TestIEEE {
	public static void main(String[] args) {
		IEEE test = new IEEE();
		//System.out.println("Floatzahl: " + test.fromIEEEToFloat("0/01111111/00000000000000000000000"));
		System.out.println("IEEE: " + test.fromFloatToIEEE((float)-261.75));
		System.out.println("IEEE: " + test.fromFloatToIEEE((float)261.125));

//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("0/01111111/00000000000000000000000"));
//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("1/10000000/01100000000000000000000"));
//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("1/10001010/00100101001110000000000"));
//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("0/10000011/00100110011001100110011"));
//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("0/10100000/00101010000001011111001"));
//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("0/00111100/01111001110010100001000"));
//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("0/10101101/11000001001000100001100"));
//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("0/10111111/01000110001000001100011"));
//		System.out.println("Floatzahl: " + test.fromIEEEToFloat("1/01111101/01000000000000000000000"));
//		
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)1.0));
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)-2.75));
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)-2345.75));
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)18.4));
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)1.0E10));
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)1.0E-20));
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)1.23456788E14));
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)2.35E19));
//		System.out.println("IEEE: " + test.fromFloatToIEEE((float)-0.3125));


	}
}
