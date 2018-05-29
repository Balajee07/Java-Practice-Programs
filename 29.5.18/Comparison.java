package test;

import java.util.*;

public class Comparison {
	long calculateTime(long start, long end) {
		return (end - start);
	}

	public static void main(String[] args) {
		int value, choice, position;
		long startTime, endTime, arrayDiff, linkedDiff;
		Scanner scan = new Scanner(System.in);
		Comparison object = new Comparison();
		ArrayList<Integer> arrayListRecord = new ArrayList<>();
		LinkedList<Integer> linkedListRecord = new LinkedList<>();
		do {
			System.out.println("comparison between ArrayList and LinkedList");
			System.out.println("1.Create\n2.Insert\n3.Retrive data");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the value to create both Arraylist and Linkedlist");
				value = scan.nextInt();
				startTime = System.currentTimeMillis();
				for (int itr = 1; itr <= value; itr++) {
					arrayListRecord.add(itr);
				}
				endTime = System.currentTimeMillis();
				arrayDiff = object.calculateTime(startTime, endTime);
				startTime = System.currentTimeMillis();
				for (int itr = 1; itr <= value; itr++) {
					linkedListRecord.add(itr);
				}
				endTime = System.currentTimeMillis();
				linkedDiff = object.calculateTime(startTime, endTime);
				System.out.println("ArrayList creation time : " + arrayDiff + " ms\n LinkedList creation time : "
						+ linkedDiff + " ms");
				break;
			case 2:
				int choice1;
				System.out.println("1.General insert\n2.Insert at position");
				choice1 = scan.nextInt();
				switch (choice1) {
				case 1:
					System.out.println("Enter value to insert");
					value = scan.nextInt();
					startTime = System.currentTimeMillis();
					arrayListRecord.add(value);
					endTime = System.currentTimeMillis();
					arrayDiff = object.calculateTime(startTime, endTime);
					startTime = System.currentTimeMillis();
					linkedListRecord.add(value);
					endTime = System.currentTimeMillis();
					linkedDiff = object.calculateTime(startTime, endTime);
					System.out.println("Inserted time in arraylist : " + arrayDiff
							+ " ms\n Inserted time in LinkedList: " + linkedDiff + " ms");
					break;
				case 2:
					System.out.println("Enter the data");
					value = scan.nextInt();
					System.out.println("Enter the index value to insert");
					position = scan.nextInt();
					startTime = System.currentTimeMillis();
					arrayListRecord.add(position, value);
					endTime = System.currentTimeMillis();
					arrayDiff = object.calculateTime(startTime, endTime);
					startTime = System.currentTimeMillis();
					linkedListRecord.add(position, value);
					endTime = System.currentTimeMillis();
					linkedDiff = object.calculateTime(startTime, endTime);
					System.out.println("Inserted time (using index value) in arraylist : " + arrayDiff
							+ " ms\n Inserted time (using index value) in LinkedList: " + linkedDiff + " ms");
				}
				break;
			case 3:
				System.out.println("Enter a Index value to retrive the data");
				position = scan.nextInt();
				startTime = System.currentTimeMillis();
				System.out.println(" data found in ArrayList : " + arrayListRecord.get(position));
				endTime = System.currentTimeMillis();
				arrayDiff = object.calculateTime(startTime, endTime);
				startTime = System.currentTimeMillis();
				System.out.println(" data found in linkedList : " + linkedListRecord.get(position));
				endTime = System.currentTimeMillis();
				linkedDiff = object.calculateTime(startTime, endTime);
				System.out.println("ArrayList retrival time : " + arrayDiff + " ms\n LinkedList retrival time : "
						+ linkedDiff + " ms");
				break;
			default:
				System.exit(0);
			}
		} while (choice < 4);
		scan.close();
	}

}
