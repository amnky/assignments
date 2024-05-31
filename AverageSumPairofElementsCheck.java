package com.amnky.assignments;

import java.util.Arrays;
import java.util.Scanner;

public class AverageSumPairofElementsCheck {

	public static boolean checkPairEqualsAverage(int[] arr) {
		int sum = 0;
		int size = arr.length;
		int averageOfElements;
		for (int i = 0; i < size; i++) {
			sum += arr[i];
		}

		averageOfElements = (int)(sum / size);

		int left = 0;
		int right = size - 1;

		// Array traverse from left and right
		while (left < right) {

			int currSum = arr[left] + arr[right];
			if (currSum == averageOfElements) {
				return true;
			} else if (currSum < averageOfElements) {
				left++;
			} else {
				right--;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		// Input from terminal
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = scanner.nextInt();
		int[] arr = new int[size];

		// Taking input from user
		System.out.println("Enter array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		//sorting array for easy traversal of array elements
		Arrays.sort(arr);

		boolean pairExist = checkPairEqualsAverage(arr);

		if (pairExist) {
			System.out.println("Pair exist");
		} else {
			System.out.println("Pair does not exist");
		}

		scanner.close();

	}

}
