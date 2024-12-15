// Write a menu driven program for Selection Sort

import java.util.Scanner;
public class SelectionSort {

    // Method to perform Selection Sort
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            
            // Find the index of the minimum element in the unsorted part
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

        // Performing Selection Sort
        selectionSort(arr);

        // Printing the sorted array
        System.out.print("Selection Sort: Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}