// Write a menu driven program for implementing various Hashing techniques with Linear Probing.

import java.util.Scanner;

class HashTable {
    private int[] table;
    private int size;
    private static final int DELETED = Integer.MIN_VALUE;
    public HashTable(int size) {
        this.size = size;
        table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = -1; // Initialize table with -1 (empty slots)
        }
    }
    private int hashFunction(int key) {
        return key % size;
    }
    public void insert(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        boolean inserted = false;
        do {
            if (table[index] == -1 || table[index] == DELETED) { // Empty or deleted slot
                table[index] = key;
                inserted = true;
                System.out.println("Key " + key + " inserted at index " + index);
                break;
            }
            index = (index + 1) % size; // Linear probing
        } while (index != originalIndex);
        if (!inserted) {
            System.out.println("Hash table is full. Cannot insert key " + key);
        }
    }
    public boolean search(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        do {
            if (table[index] == key) {
                System.out.println("Key " + key + " found at index " + index);
                return true;
            } else if (table[index] == -1) {
                break; // Stop if an empty slot is found
            }
            index = (index + 1) % size; // Linear probing
        } while (index != originalIndex);
        System.out.println("Key " + key + " not found.");
        return false;
    }
    public void delete(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        do {
            if (table[index] == key) {
                table[index] = DELETED; // Mark the slot as deleted
                System.out.println("Key " + key + " deleted from index " + index);
                return;
            } else if (table[index] == -1) {
                break; // Stop if an empty slot is found
            }
            index = (index + 1) % size; // Linear probing
        } while (index != originalIndex);

        System.out.println("Key " + key + " not found. Cannot delete.");
    }
    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            if (table[i] == -1) {
                System.out.println(i + ": EMPTY");
            } else if (table[i] == DELETED) {
                System.out.println(i + ": DELETED");
            } else {
                System.out.println(i + ": " + table[i]);
            }
        }
    }
}
public class HashingWithLinearProbing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();
        HashTable hashTable = new HashTable(size);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a key");
            System.out.println("2. Search for a key");
            System.out.println("3. Delete a key");
            System.out.println("4. Display the hash table");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int keyToInsert = scanner.nextInt();
                    hashTable.insert(keyToInsert);
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    int keyToSearch = scanner.nextInt();
                    hashTable.search(keyToSearch);
                    break;
                case 3:
                    System.out.print("Enter key to delete: ");
                    int keyToDelete = scanner.nextInt();
                    hashTable.delete(keyToDelete);
                    break;
                case 4:
                    hashTable.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}