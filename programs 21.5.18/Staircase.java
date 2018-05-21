//Problem: Get value from user. and print * like a staircase
package test;


import java.util.*;

public class Staircase {
	// Complete the staircase function below.
	static void staircase(int n) {
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= (n - i); j++) {
					System.out.print("  ");
				}

				for (int k = 1; k <= (n - (n - i)); k++) {
					System.out.print("* ");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("This value is not accepted");
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		staircase(n);
		scanner.close();
	}
}
