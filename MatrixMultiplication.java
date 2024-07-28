package com.amnky.assignments;

import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input dimensions of the first matrix
        System.out.println("Enter number of rows for the first matrix:");
        int numRowsMatrix1 = scanner.nextInt();
        System.out.println("Enter number of columns for the first matrix:");
        int numColsMatrix1 = scanner.nextInt();
        int[][] matrix1 = new int[numRowsMatrix1][numColsMatrix1];

        // Input dimensions of the second matrix
        System.out.println("Enter number of rows for the second matrix:");
        int numRowsMatrix2 = scanner.nextInt();
        System.out.println("Enter number of columns for the second matrix:");
        int numColsMatrix2 = scanner.nextInt();
        int[][] matrix2 = new int[numRowsMatrix2][numColsMatrix2];

        // Check if matrix multiplication is possible
        if (numColsMatrix1 != numRowsMatrix2) {
            System.out.println("Multiplication of these two matrices is not possible.");
            return; // Exit if multiplication isn't valid
        }

        int[][] resultMatrix = new int[numRowsMatrix1][numColsMatrix2]; // Matrix to store the result

        // User input for matrix 1
        System.out.println("Enter elements of the first matrix:");
        for (int i = 0; i < numRowsMatrix1; i++) {
            for (int j = 0; j < numColsMatrix1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // User input for matrix 2
        System.out.println("Enter elements of the second matrix:");
        for (int i = 0; i < numRowsMatrix2; i++) {
            for (int j = 0; j < numColsMatrix2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Matrix multiplication logic
        System.out.println("Multiplication result:");
        for (int i = 0; i < numRowsMatrix1; i++) {
            for (int j = 0; j < numColsMatrix2; j++) {
                for (int k = 0; k < numRowsMatrix2; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        // Print resulting matrix
        for (int[] row : resultMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // Move to the next row after printing a row
        }

        scanner.close(); 
    }
}
