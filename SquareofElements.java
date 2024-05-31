package com.amnky.arrays;

import java.util.Scanner;

public class SquareofElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking array size from user
		System.out.println("Enetr array size");
		int n = sc.nextInt();
		int array[] = new int[n];
		int resultArray[] = new int[n];

		// Taking array elements from user
		System.out.println("Enter array elements");
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}

		int leftPos = 0;
		int rightPos = array.length - 1;
		int index = array.length - 1;

		// Logic to square array elements in sorted order
		while (leftPos <= rightPos) {
			int leftSquare = array[leftPos] * array[leftPos];
			int rightSquare = array[rightPos] * array[rightPos];

			if (leftSquare > rightSquare) {
				resultArray[index] = leftSquare;
				leftPos++;
			} else {
				resultArray[index] = rightSquare;
				rightPos--;
			}
			index--;
		}
		System.out.println("Sorted Square Array");
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}

		sc.close();
	}

}
