package com.techlabs.arrays2d;

import java.util.Scanner;

public class MultiplicationOfTwoMatrices {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of rows for array 1");
		int rowsOfFirstMatirx = scanner.nextInt();
		System.out.println("Enter number of coloumns for array 1");
		int colOfFirstMatirx = scanner.nextInt();

		int[][] array1 = new int[rowsOfFirstMatirx][colOfFirstMatirx];

		System.out.println("Enter number of rows for array 2");
		int rowsOfSecondMatrix= scanner.nextInt();
		System.out.println("Enter number of coloumns for array 2");
		int colOfSecondMatrix = scanner.nextInt();

		int[][] array2 = new int[rowsOfSecondMatrix][colOfSecondMatrix];

		int[][] array3 = new int[rowsOfFirstMatirx][colOfSecondMatrix];

		if (colOfFirstMatirx != rowsOfSecondMatrix) {
			System.out.println("Multiplication of these two matrix is not possible");
		} else {

			System.out.println("Enter array elements of 2D Array 1");
			for (int i = 0; i < rowsOfFirstMatirx; i++) {
				for (int j = 0; j < colOfFirstMatirx; j++) {
					array1[i][j] = scanner.nextInt();
				}
			}

			System.out.println("Enter array elements of 2D Array 2");
			for (int i = 0; i < rowsOfSecondMatrix; i++) {
				for (int j = 0; j < colOfSecondMatrix; j++) {
					array2[i][j] = scanner.nextInt();
				}
			}

			System.out.println("Multiplication result");
			for (int i = 0; i < rowsOfFirstMatirx; i++) {
				for (int j = 0; j < colOfSecondMatrix; j++) {
					for (int k = 0; k < rowsOfSecondMatrix; k++)
						array3[i][j] += array1[i][k] * array2[k][j];
				}
			}

			for (int i = 0; i < rowsOfFirstMatirx; i++) {
				for (int j = 0; j < colOfSecondMatrix; j++) {
					System.out.print(array3[i][j] + " ");
				}
				System.out.println();
			}
		}

		scanner.close();

	}

}
