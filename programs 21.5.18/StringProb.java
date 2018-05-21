// Problem: You will be given a set of Strings. You have to find the Number of Occurance of each substring and Print it in the decending order.

//import java.util.*;

public class StringProb {
	static boolean flag = false;

	public static void main(String[] args) {
		String strArray[] = { "hello", "world", "world", "world", "hello" };
		String verifiedStr[] = new String[strArray.length];
		Integer[] occurance = new Integer[strArray.length];
		for (String s : strArray) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (int i = 0; i < strArray.length; i++) {
			for (int k = 0; k < verifiedStr.length; k++) {
				if (verifiedStr[k] == strArray[i]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				verifiedStr[i] = strArray[i];
				occurance[i] = 1;
				for (int j = i + 1; j < strArray.length; j++) {
					if (strArray[i] == strArray[j]) {
						occurance[i] += 1;
					}
				}
			}
		}
		int r = 0;
		while (occurance[r] != null) {
			r++;
		}
		for (int i = 0; i < r; i++) {
			for (int j = i + 1; j < r; j++) {
				if (occurance[i] < occurance[j]) {
					int temp;
					String strTemp;
					temp = occurance[j];
					occurance[j] = occurance[i];
					occurance[i] = temp;
					strTemp = verifiedStr[j];
					verifiedStr[j] = verifiedStr[i];
					verifiedStr[i] = strTemp;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			System.out.print(occurance[i] + "\t");
		}
		System.out.println();
		for (int j = 0; j < r; j++) {
			System.out.print(verifiedStr[j] + "\t");
		}
	}

}
