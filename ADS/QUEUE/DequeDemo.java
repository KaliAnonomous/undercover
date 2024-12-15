// Write a program to implement Double ended Queue.

import java.util.Scanner;
class Deque {
    private int[] deque;
    private int front, rear, size, capacity;
    public Deque(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
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
    public void insertFront(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert " + value + " at the front.");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        deque[front] = value;
        size++;
        System.out.println(value + " inserted at the front.");
    }
    public void insertRear(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert " + value + " at the rear.");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        deque[rear] = value;
        size++;
        System.out.println(value + " inserted at the rear.");
    }
    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from front.");
            return -1;
        }
        int value = deque[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return value;
    }
    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from rear.");
            return -1;
        }
        int value = deque[rear];
        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        size--;
        return value;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("Deque elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(deque[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
public class DequeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the Deque: ");
        int capacity = scanner.nextInt();
        Deque deque = new Deque(capacity);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at Rear");
            System.out.println("3. Delete from Front");
            System.out.println("4. Delete from Rear");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at front: ");
                    int frontValue = scanner.nextInt();
                    deque.insertFront(frontValue);
                    break;
                case 2:
                    System.out.print("Enter value to insert at rear: ");
                    int rearValue = scanner.nextInt();
                    deque.insertRear(rearValue);
                    break;
                case 3:
                    int frontDeleted = deque.deleteFront();
                    if (frontDeleted != -1) {
                        System.out.println("Deleted from front: " + frontDeleted);
                    }
                    break;
                case 4:
                    int rearDeleted = deque.deleteRear();
                    if (rearDeleted != -1) {
                        System.out.println("Deleted from rear: " + rearDeleted);
                    }
                    break;
                case 5:
                    deque.display();
                    break;
                case 6:
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