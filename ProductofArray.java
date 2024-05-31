
package com.amnky.assignments;

import java.util.Scanner;

public class ProductofArray {

	public static int[] productOfArray(int[] arr) {
		int n = arr.length;
		int[] prod = new int[n];

		int countOfZero = 0;
		int totalProduct = 1;

		
		
		for (int i = 0; i < n; i++) {

			// counting number of zeros
			if (arr[i] == 0) {
				countOfZero++;
			} 

			else {
				totalProduct *= arr[i];
			}

		}

		if (countOfZero > 1) {
			return prod;
		}

		else if (countOfZero == 1) {

			for (int i = 0; i < n; i++) {

				if (arr[i] == 0) {
					prod[i] = totalProduct;
					break;
				}
			}
			return prod;
		}

		// if there are no zeros following operation
		else {

			for (int i = 0; i < n; i++) {
				prod[i] = totalProduct / arr[i];
			}

			return prod;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// user input of array size
		System.out.println("Enter array size");
		int n = sc.nextInt();
		int[] arr = new int[n];

		// User input of array elements
		System.out.println("Enter array elements");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// new array to store product of array elements
		// function to calculate product of array elements
		int[] productOfElements = productOfArray(arr);

		// printing Product array
		System.out.print("Product array = {");
		for (int i = 0; i < n; i++) {
			System.out.print(productOfElements[i] + " ");
		}
		System.out.print("}");
		sc.close();
	}

}
