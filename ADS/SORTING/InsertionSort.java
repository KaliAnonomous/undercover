// Write a menu driven program for Insertion Sort

import java.util.Scanner;
public class InsertionSort {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Place key in its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array size input
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Taking array elements as input
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Performing Insertion Sort
        insertionSort(arr);

        // Printing the sorted array
        System.out.print("Insertion Sort: Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
