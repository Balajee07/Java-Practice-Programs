//Problem: Print the multiplies of 4 in a Hollow block.

import java.util.Scanner;

public class HollowBlock {
	private static void printHollowSquarePattern(int n) {
		if (n % 4 != 0) {
		System.out.println("Number is not divisible by 4");
		return;
		}
			
		int d = (n / 4) + 1;
		int j;
		int t = 1, x = n;

		for (int i = 1; i <= d; i++) {
			if (i == 1) {
				for (j = 1; j <= d; j++) {
					System.out.print((t++) + " ");
				}
				System.out.println();
			} else if (i == d) {
				for (j = 1; j <= d; j++) {
					System.out.print((x--) + " ");
				}
			} else {
				for (j = 1; j <= d; j++) {
					if (j == 1) {
						System.out.print((x--));
						for (int k = j; k < d; k++) {
							System.out.print(" ");
						}
					} else if (j == d)
						System.out.println(t++);
					else
						System.out.print(" ");
				}

			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int value;
		System.out.println("Enter a value which is a multipication of 4");
		value = scan.nextInt();
		scan.close();
		printHollowSquarePattern(value);

	}

}
