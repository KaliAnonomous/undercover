// Write a program to implement Heap with different operations (Create, Insert, Delete).

import java.util.Scanner;
class Heap {
    private int[] heap;
    private int size;
    private int capacity;
    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return 2 * i + 1;
    }
    private int rightChild(int i) {
        return 2 * i + 2;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }
        heap[size] = value;
        size++;
        int current = size - 1;
        while (current != 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        System.out.println("Inserted " + value + " into the heap.");
    }
    public int delete() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot delete.");
            return -1;
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        System.out.println("Deleted root: " + root);
        return root;
    }
    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }
    public void display() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return;
        }
        System.out.print("Heap elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
public class HeapOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the heap: ");
        int capacity = scanner.nextInt();
        Heap heap = new Heap(capacity);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a value");
            System.out.println("2. Delete the root");
            System.out.println("3. Display the heap");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int value = scanner.nextInt();
                    heap.insert(value);
                    break;
                case 2:
                    heap.delete();
                    break;
                case 3:
                    heap.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}