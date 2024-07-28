package com.amnky.assignments;

import java.util.Scanner;

public class SecondLargestFinder {

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        int largest = arr[0]; // Start by assuming the first element is largest
        int secondLargest = arr[0]; // Initially, same as largest (in case of duplicates)

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest; // Previous largest becomes the new second largest
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i]; // Found a new second largest (not equal to largest)
            }
        }

        // If the second largest is still the same as the largest, it means there were no distinct
        // second largest elements. Return an appropriate value (or throw an exception).
        if (secondLargest == largest) {
            throw new IllegalArgumentException("No distinct second largest element found.");
        }
        
        return secondLargest;
    }

    // Example usage
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = scanner.nextInt();
        System.out.println("Enter elements: ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int secondLargest = findSecondLargest(array);
        System.out.println("Second largest element: " + secondLargest); 
    }
}
