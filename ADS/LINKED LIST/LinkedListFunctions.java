// Write a program to implement Functions on LinkedList (Creation, Deletion, Addition of Node, Searching, Traversal)

import java.util.Scanner;

// Node class to represent each element in the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class containing various operations
class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // 1. Creation (Add a node at the end)
    public void createNode(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Node with value " + value + " created.");
    }

    // 2. Deletion (Delete a node by value)
    public void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty. No nodes to delete.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println("Node with value " + value + " deleted.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Node with value " + value + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Node with value " + value + " deleted.");
        }
    }

    // 3. Addition (Add a node at a specific position)
    public void addNodeAtPosition(int value, int position) {
        Node newNode = new Node(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Node with value " + value + " added at position " + position + ".");
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position " + position + " is invalid.");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Node with value " + value + " added at position " + position + ".");
        }
    }

    // 4. Searching (Search for a node by value)
    public void searchNode(int value) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Node with value " + value + " found at position " + position + ".");
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Node with value " + value + " not found.");
    }

    // 5. Traversal (Display all nodes)
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("Linked List elements: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Main class to test the LinkedList operations
public class LinkedListFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create Node (Add at End)");
            System.out.println("2. Delete Node by Value");
            System.out.println("3. Add Node at Specific Position");
            System.out.println("4. Search Node by Value");
            System.out.println("5. Traverse Linked List");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to create node: ");
                    int createValue = scanner.nextInt();
                    list.createNode(createValue);
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    list.deleteNode(deleteValue);
                    break;

                case 3:
                    System.out.print("Enter value to add: ");
                    int addValue = scanner.nextInt();
                    System.out.print("Enter position to add the node: ");
                    int position = scanner.nextInt();
                    list.addNodeAtPosition(addValue, position);
                    break;

                case 4:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    list.searchNode(searchValue);
                    break;

                case 5:
                    list.traverse();
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
