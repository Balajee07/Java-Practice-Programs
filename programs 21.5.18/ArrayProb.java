//Problem: Given a two array on size m and n . Print the sum of even and odd numbers in the first array that or not in second array.
package test;

import java.util.Scanner;

public class ArrayProb {
	public static void main(String args[]) {
		int arraySize1, arraySize2, array1[], array2[];
		int evenSum = 0, oddSum = 0;
		boolean flag = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Size of array1 ");
		arraySize1 = scan.nextInt();
		array1 = new int[arraySize1];
		System.out.println("Enter the values for the array1");
		for (int i = 0; i < array1.length; i++) {
			array1[i] = scan.nextInt();
		}
		System.out.println("Enter the Size of array2 ");
		arraySize2 = scan.nextInt();
		array2 = new int[arraySize2];
		System.out.println("Enter the values for the arrayss2");
		for (int i = 0; i < array2.length; i++) {
			array2[i] = scan.nextInt();
		}
		scan.close();

		for (int itr = 0; itr < arraySize1; itr++) {
			for (int itr2 = 0; itr2 < arraySize2; itr2++) {
				if (array1[itr] == array2[itr2]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				if (array1[itr] % 2 == 0) {
					evenSum += array1[itr];
				} else {
					oddSum += array1[itr];
				}
			}
		}
		System.out.println("Even sum :" + evenSum + "\nOdd sum :" + oddSum);

	}
}
