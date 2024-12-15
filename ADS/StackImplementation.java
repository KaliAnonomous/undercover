// Write a program to implement Stack using Array and Linked List

import java.util.Scanner;

class StackUsingArray {
    private int[] stack;
    private int top;
    private int capacity;

    public StackUsingArray(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
        } else {
            stack[++top] = value;
            System.out.println("Pushed " + value);
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackUsingLinkedList {
    private Node top;

    public StackUsingLinkedList() {
        top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Pushed " + value);
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow!");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Stack elements:");
            Node temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}

public class StackImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackUsingArray arrayStack = null;
        StackUsingLinkedList linkedListStack = new StackUsingLinkedList();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create Stack Using Array");
            System.out.println("2. Push into Array Stack");
            System.out.println("3. Pop from Array Stack");
            System.out.println("4. Display Array Stack");
            System.out.println("5. Push into Linked List Stack");
            System.out.println("6. Pop from Linked List Stack");
            System.out.println("7. Display Linked List Stack");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the array stack: ");
                    int size = scanner.nextInt();
                    arrayStack = new StackUsingArray(size);
                    System.out.println("Array Stack created with size " + size);
                    break;

                case 2:
                    if (arrayStack == null) {
                        System.out.println("Create the Array Stack first!");
                    } else {
                        System.out.print("Enter value to push: ");
                        int value = scanner.nextInt();
                        arrayStack.push(value);
                    }
                    break;

                case 3:
                    if (arrayStack == null) {
                        System.out.println("Create the Array Stack first!");
                    } else {
                        int poppedValue = arrayStack.pop();
                        if (poppedValue != -1) {
                            System.out.println("Popped: " + poppedValue);
                        }
                    }
                    break;

                case 4:
                    if (arrayStack == null) {
                        System.out.println("Create the Array Stack first!");
                    } else {
                        arrayStack.display();
                    }
                    break;

                case 5:
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    linkedListStack.push(value);
                    break;

                case 6:
                    int poppedValue = linkedListStack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped: " + poppedValue);
                    }
                    break;

                case 7:
                    linkedListStack.display();
                    break;

                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
