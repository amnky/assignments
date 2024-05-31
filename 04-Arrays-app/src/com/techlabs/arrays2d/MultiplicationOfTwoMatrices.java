package com.techlabs.arrays2d;

import java.util.Scanner;

public class MultiplicationOfTwoMatrices {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of rows for array 1");
		int rows1 = scanner.nextInt();
		System.out.println("Enter number of coloumns for array 1");
		int col1 = scanner.nextInt();

		int[][] array1 = new int[rows1][col1];

		System.out.println("Enter number of rows for array 2");
		int rows2 = scanner.nextInt();
		System.out.println("Enter number of coloumns for array 2");
		int col2 = scanner.nextInt();

		int[][] array2 = new int[rows2][col2];

		int[][] array3 = new int[rows1][col2];

		if (col1 != rows2) {
			System.out.println("Multiplication of these two matrix is not possible");
		} else {

			System.out.println("Enter array elements of 2D Array 1");
			for (int i = 0; i < rows1; i++) {
				for (int j = 0; j < col1; j++) {
					array1[i][j] = scanner.nextInt();
				}
			}

			System.out.println("Enter array elements of 2D Array 2");
			for (int i = 0; i < rows2; i++) {
				for (int j = 0; j < col2; j++) {
					array2[i][j] = scanner.nextInt();
				}
			}

			System.out.println("Multiplication result");
			for (int i = 0; i < rows1; i++) {
				for (int j = 0; j < col2; j++) {
					for (int k = 0; k < rows2; k++)
						array3[i][j] += array1[i][k] * array2[k][j];
				}
			}

			for (int i = 0; i < rows1; i++) {
				for (int j = 0; j < col2; j++) {
					System.out.print(array3[i][j] + " ");
				}
				System.out.println();
			}
		}

		scanner.close();

	}

}
