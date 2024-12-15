// Write a program to implement Priority Queue.

import java.util.Scanner;
class PriorityQueue {
    private int[] elements;
    private int[] priorities;
    private int size;
    private int capacity;
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        priorities = new int[capacity];
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public void enqueue(int value, int priority) {
        if (isFull()) {
            System.out.println("Priority Queue is full. Cannot enqueue " + value);
            return;
        }
        int i;
        for (i = size - 1; i >= 0 && priorities[i] > priority; i--) {
            elements[i + 1] = elements[i];
            priorities[i + 1] = priorities[i];
        }
        elements[i + 1] = value;
        priorities[i + 1] = priority;
        size++;
        System.out.println(value + " enqueued with priority " + priority + ".");
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty. Cannot dequeue.");
            return -1;
        }
        int value = elements[0];
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
            priorities[i - 1] = priorities[i];
        }
        size--;
        return value;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return;
        }
        System.out.println("Elements in Priority Queue:");
        for (int i = 0; i < size; i++) {
            System.out.println("Value: " + elements[i] + ", Priority: " + priorities[i]);
        }
    }
}
public class PriorityQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the Priority Queue: ");
        int capacity = scanner.nextInt();
        PriorityQueue pq = new PriorityQueue(capacity);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    System.out.print("Enter its priority: ");
                    int priority = scanner.nextInt();
                    pq.enqueue(value, priority);
                    break;
                case 2:
                    int dequeuedValue = pq.dequeue();
                    if (dequeuedValue != -1) {
                        System.out.println("Dequeued value: " + dequeuedValue);
                    }
                    break;
                case 3:
                    pq.display();
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
