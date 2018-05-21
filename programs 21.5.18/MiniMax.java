/*Problem: Given a set of array values.  find the minimum and maximum values that can be calculated by
summing exactly four of the five integers. 
Then print the respective minimum and maximum values*/

import java.util.*;

public class MiniMax {

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		
		int Temp, MinVal = 0, MaxVal = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					Temp = arr[i];
					arr[i] = arr[j];
					arr[j] = Temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (i < (arr.length - 1)) {
				MinVal += arr[i];
			}

			if (i > 0) {
				MaxVal += arr[i];
			}
		}
		System.out.println("MaxValue : " + MaxVal + " MinVal : " + MinVal);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int arr[] = new int[5];
		System.out.println("Enter the array Values:");
		for (int i = 0; i < 5; i++) {
			arr[i] = scanner.nextInt();
		}
		miniMaxSum(arr);
		scanner.close();
	}
}
