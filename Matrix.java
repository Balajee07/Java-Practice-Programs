/*Given a square matrix, calculate the absolute difference between the sums of its diagonals.

Input Format

The first line contains a single integer,  denoting the number of rows and columns in the matrix . 
The next  lines denote the matrix 's rows, with each line containing  space-separated integers describing the columns.

Constraints
-100 < Elements in the matrix < 100

Output Format

Print the absolute difference between the sums of the matrix's two diagonals as a single integer.*/


import java.io.*;
import java.math.*;
//import java.text.*;
import java.util.*;
//import java.util.regex.*;

public class Matrix {

	/*
	 * Complete the diagonalDifference function below.
	 */
    static int diagonalDifference(int[][] a) {
        
        int DiagVal1=0,DiagVal2=0,FinalAnswer,ArrayLength;
        ArrayLength=a.length;
        try{
            for(int i=0;i<ArrayLength;i++) {
            for(int j=0;j<ArrayLength;j++) {
                if(a[i][j]<-100 || a[i][j]>100) {
                    throw new Exception();
                }
            }
            }
            for(int i=0;i<ArrayLength;i++){
                for(int j=0;j<ArrayLength;j++){
                    if(i==j) {
                        DiagVal1 += a[i][j];
                    }
                    if(i==((ArrayLength-j)-1)){
                        DiagVal2 += a[i][j];
                    }
                } 
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception cached - Values doesnt meet the contraints");
        }
    FinalAnswer= Math.abs(DiagVal1-DiagVal2);
    return FinalAnswer;
    }

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(scan.nextLine().trim());

		int[][] a = new int[n][n];

		for (int aRowItr = 0; aRowItr < n; aRowItr++) {
			String[] aRowItems = scan.nextLine().split(" ");

			for (int aColumnItr = 0; aColumnItr < n; aColumnItr++) {
				int aItem = Integer.parseInt(aRowItems[aColumnItr].trim());
				a[aRowItr][aColumnItr] = aItem;
			}
		}

		int result = diagonalDifference(a);
		System.out.println("The answer is " + result);
	}
}
