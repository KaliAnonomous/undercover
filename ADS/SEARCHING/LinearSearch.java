// Write a menu driven program for Linear Search.

import java.util.Scanner;

public class LinearSearch {

    // Method to perform linear search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if not found
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

        // Taking target value input
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Perform linear search
        int result = linearSearch(arr, target);
        if (result != -1) {
            System.out.println("Linear Search: Element " + target + " is at index " + result);
        } else {
            System.out.println("Linear Search: Element not found.");
        }

        scanner.close();
    }
}
