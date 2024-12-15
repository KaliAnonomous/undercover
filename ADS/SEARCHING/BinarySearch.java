// Write a menu driven program for Binary Search.

import java.util.Scanner;

public class BinarySearch {

    // Method to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid; // Return index if found
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking target value input
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(arr, target);

        // Output the result
        if (result != -1) {
            System.out.println("Binary Search: Element " + target + " is at index " + result);
        } else {
            System.out.println("Binary Search: Element not found.");
        }

        scanner.close();
    }
}
