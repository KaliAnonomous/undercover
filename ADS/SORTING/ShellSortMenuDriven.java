import java.util.Scanner;

public class ShellSortMenuDriven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Input Array");
            System.out.println("2. Display Array");
            System.out.println("3. Sort Array using Shell Sort");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();
                    array = new int[size];
                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        array[i] = scanner.nextInt();
                    }
                    System.out.println("Array input complete.");
                    break;

                case 2:
                    if (array == null) {
                        System.out.println("Array is empty! Please input the array first.");
                    } else {
                        System.out.print("Array elements: ");
                        for (int num : array) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (array == null) {
                        System.out.println("Array is empty! Please input the array first.");
                    } else {
                        shellSort(array);
                        System.out.println("Array sorted using Shell Sort.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}
