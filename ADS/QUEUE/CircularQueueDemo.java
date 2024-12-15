// Write a program to implement Circular Queue.

import java.util.Scanner;
class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        System.out.println(value + " enqueued.");
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return -1;
        }
        return queue[front];
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
public class CircularQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the circular queue: ");
        int capacity = scanner.nextInt();
        CircularQueue queue = new CircularQueue(capacity);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter a value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    int dequeuedValue = queue.dequeue();
                    if (dequeuedValue != -1) {
                        System.out.println("Dequeued value: " + dequeuedValue);
                    }
                    break;
                case 3:
                    int frontValue = queue.peek();
                    if (frontValue != -1) {
                        System.out.println("Front value: " + frontValue);
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}