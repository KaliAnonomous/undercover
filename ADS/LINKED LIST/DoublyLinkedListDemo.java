// Write a program to implement Doubly Linked List.

import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node prev;
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DoublyLinkedList {
    private Node head;
    public DoublyLinkedList() {
        this.head = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println(data + " inserted at the beginning.");
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println(data + " inserted at the end.");
    }
    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete from the beginning.");
            return;
        }
        int deletedData = head.data;
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
        }
        System.out.println(deletedData + " deleted from the beginning.");
    }
    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete from the end.");
            return;
        }
        if (head.next == null) {
            int deletedData = head.data;
            head = null;
            System.out.println(deletedData + " deleted from the end.");
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            int deletedData = temp.data;
            temp.prev.next = null;
            System.out.println(deletedData + " deleted from the end.");
        }
    }
    public void displayFromBeginning() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("List from beginning: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void displayFromEnd() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.print("List from end: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}
public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Display from Beginning");
            System.out.println("6. Display from End");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    int beginValue = scanner.nextInt();
                    dll.insertAtBeginning(beginValue);
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    int endValue = scanner.nextInt();
                    dll.insertAtEnd(endValue);
                    break;
                case 3:
                    dll.deleteFromBeginning();
                    break;
                case 4:
                    dll.deleteFromEnd();
                    break;
                case 5:
                    dll.displayFromBeginning();
                    break;
                case 6:
                    dll.displayFromEnd();
                    break;
                case 7:
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