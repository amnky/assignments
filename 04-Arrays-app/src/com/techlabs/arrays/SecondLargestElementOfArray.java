package com.techlabs.arrays;

import java.util.Scanner;

public class SecondLargestElementOfArray {

	public static void main(String[] args) {

		// Initialization
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = scanner.nextInt();
		int[] arr = new int[size];

		// Taking input from user
		System.out.println("Enter array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		// Exit if size of array is less than 2
		if (size < 2) {
			System.out.println("There is no second largest element");
		}

		else {

			int maxElement = Integer.MIN_VALUE;
			int secondLargestElement = Integer.MIN_VALUE;

			// Find the second maximum element in the array
			for (int i = 0; i < size; i++) {
				if (arr[i] > maxElement) {
					secondLargestElement = maxElement;
					maxElement = arr[i];
				}

				else if (arr[i] != maxElement && arr[i] > secondLargestElement) {
					secondLargestElement = arr[i];
				}
			}

			System.out.println("Second largest element : " + secondLargestElement);

		}
		scanner.close();
	}

}
