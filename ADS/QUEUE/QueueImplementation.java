// Write a program to implement Queue using LinkedList

import java.util.Scanner;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class QueueUsingLinkedList {
    private Node front, rear;

    public QueueUsingLinkedList() {
        front = rear = null;
    }
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueued: " + value);
    }
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow! The queue is empty.");
            return -1;
        } else {
            int value = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return value;
        }
    }
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue elements: ");
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
public class QueueImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    int dequeuedValue = queue.dequeue();
                    if (dequeuedValue != -1) {
                        System.out.println("Dequeued: " + dequeuedValue);
                    }
                    break;
                case 3:
                    queue.display();
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
}