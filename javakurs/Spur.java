package javakurs;


import java.util.Arrays;

public class Spur {

	public static void main(String[] args) {
		double[][] matrix = getIndexSumArray(4,4);
		System.out.println(Arrays.deepToString(matrix));//aus 8_6
		System.out.println(getTrace(matrix));
	}
	
	public static double[][] getIndexSumArray(int a, int b){ //aus 8_6
		double[][] matrix = new double[a][b];
		for (int i = 0; i<a; i++) {
			for (int j = 0; j<b; j++) {
				matrix[i][j]=i+j+1;
			}
		}
		return matrix;
	}
	
	public static double getTrace(double[][] matrix) {
		double trace = 0;
		for (int i = 0; i<matrix.length; i++) {
			trace += matrix[i][i];
		}
		return trace;
	}

}
