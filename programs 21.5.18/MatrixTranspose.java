//Problem: you will be given a matrix with M row and N column .Transpose the matrix and print

import java.util.*;
public class MatrixTranspose {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int matrix[][],row,column;
		System.out.println("Enter the size of row and column ");
		row = scan.nextInt();
		column = scan.nextInt();
		matrix=new int[row][column];
		System.out.println("Enter the values of the Matrix:");
		for(int itr=0;itr<row;itr++) {
			for(int itr2=0;itr2<column;itr2++) {
				matrix[itr][itr2]=scan.nextInt();
			}
		}
		scan.close();
		System.out.println("Matrix before transpose: ");
		for( int itr = 0 ; itr < row ; itr++ ) {
			for( int itr2 = 0 ; itr2 < column ; itr2++ ) {
				System.out.print(matrix[itr][itr2] + " ");
			}
			System.out.println();
		}
		System.out.println("Transposed matrix :");
		for(int itr=0;itr<column;itr++) {
			for(int itr2=0;itr2<row;itr2++) {
			System.out.print(matrix[itr2][itr] + " ");
			}
			System.out.println();
		}

	}

}
