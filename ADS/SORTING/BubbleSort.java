// Write a menu driven program for Bubble Sort

import java.util.Scanner;
public class BubbleSort {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if elements are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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

        // Performing Bubble Sort
        bubbleSort(arr);

        // Printing the sorted array
        System.out.print("Bubble Sort: Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
