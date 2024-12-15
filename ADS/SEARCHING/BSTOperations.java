// Write a program to implement different operations on Binary Search Tree.

import java.util.Scanner;
class BinarySearchTree {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root;
    BinarySearchTree() {
        root = null;
    }
    void insert(int key) {
        root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }
    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }
    boolean search(int key) {
        return searchRec(root, key);
    }
    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }
    void inorder() {
        inorderRec(root);
        System.out.println();
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    void preorder() {
        preorderRec(root);
        System.out.println();
    }
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    void postorder() {
        postorderRec(root);
        System.out.println();
    }
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}
public class BSTOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a key");
            System.out.println("2. Delete a key");
            System.out.println("3. Search for a key");
            System.out.println("4. In-order traversal");
            System.out.println("5. Pre-order traversal");
            System.out.println("6. Post-order traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int keyToInsert = scanner.nextInt();
                    bst.insert(keyToInsert);
                    System.out.println("Key inserted.");
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    int keyToDelete = scanner.nextInt();
                    bst.deleteKey(keyToDelete);
                    System.out.println("Key deleted (if it existed).");
                    break;
                case 3:
                    System.out.print("Enter key to search: ");
                    int keyToSearch = scanner.nextInt();
                    if (bst.search(keyToSearch))
                        System.out.println("Key found.");
                    else
                        System.out.println("Key not found.");
                    break;
                case 4:
                    System.out.println("In-order traversal:");
                    bst.inorder();
                    break;
                case 5:
                    System.out.println("Pre-order traversal:");
                    bst.preorder();
                    break;
                case 6:
                    System.out.println("Post-order traversal:");
                    bst.postorder();
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