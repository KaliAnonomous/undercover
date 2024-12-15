// Write a menu driven program to implement DFS and BFS.

import java.util.*;
class Graph {
    private int numberOfVertices;
    private List<LinkedList<Integer>> adjacencyList;
    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new LinkedList<Integer>()); // Create a new LinkedList for each vertex
        }
    }
    public void addEdge(int vertex1, int vertex2) {
        adjacencyList.get(vertex1).add(vertex2); // Directed edge from vertex1 to vertex2
        adjacencyList.get(vertex2).add(vertex1); // Since it's an undirected graph
        System.out.println("Edge added between " + vertex1 + " and " + vertex2);
    }
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numberOfVertices];
        System.out.print("DFS Traversal starting from vertex " + startVertex + ": ");
        dfsUtil(startVertex, visited);
        System.out.println();
    }
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int adjacent : adjacencyList.get(vertex)) {
            if (!visited[adjacent]) {
                dfsUtil(adjacent, visited);
            }
        }
    }
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numberOfVertices];
        LinkedList<Integer> queue = new LinkedList<>(); // Using LinkedList as a queue
        visited[startVertex] = true;
        queue.add(startVertex);
        System.out.print("BFS Traversal starting from vertex " + startVertex + ": ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adjacent : adjacencyList.get(vertex)) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
        System.out.println();
    }
    public void display() {
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print(i + ": ");
            for (int vertex : adjacencyList.get(i)) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}
public class GraphTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        Graph graph = new Graph(vertices);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an edge");
            System.out.println("2. Display the graph");
            System.out.println("3. Perform DFS");
            System.out.println("4. Perform BFS");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter vertex 1: ");
                    int vertex1 = scanner.nextInt();
                    System.out.print("Enter vertex 2: ");
                    int vertex2 = scanner.nextInt();
                    graph.addEdge(vertex1, vertex2);
                    break;
                case 2:
                    graph.display();
                    break;
                case 3:
                    System.out.print("Enter the starting vertex for DFS: ");
                    int dfsStart = scanner.nextInt();
                    graph.dfs(dfsStart);
                    break;
                case 4:
                    System.out.print("Enter the starting vertex for BFS: ");
                    int bfsStart = scanner.nextInt();
                    graph.bfs(bfsStart);
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