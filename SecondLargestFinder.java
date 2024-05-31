package com.amnky.assignments;
import java.util.Scanner;

public class SecondLargestFinder {

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    // Example usage
    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
		System.out.println("Enter size of array");
		int size=scanner.nextInt();
		System.out.println("Enter elements: ");
		int array[]=new int[size];
		for(int i=0;i<size;i++) {
			array[i]=scanner.nextInt();
		}
        int[] numbers = {5, 12, 8, 25, 1, 25};
        int secondLargest = findSecondLargest(array);
        System.out.println("Second largest element: " + secondLargest); 
    }
}
