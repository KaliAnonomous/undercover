// Write a program to implement Minimum Spanning Tree using either Kruskal’s or Prim’s Algorithm.

import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    // Constructor for an edge
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Compare edges based on their weights
    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    private int[] parent, rank;

    public DisjointSet(int vertices) {
        parent = new int[vertices];
        rank = new int[vertices];

        // Initialize each vertex as its own parent
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the root of a vertex
    public int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]); // Path compression
        }
        return parent[vertex];
    }

    // Union of two sets
    public void union(int root1, int root2) {
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }
}

public class KruskalsAlgorithm {
    private int vertices;
    private List<Edge> edges;

    public KruskalsAlgorithm(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        // Validate vertex indices
        if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
            System.out.println("Invalid edge: (" + source + ", " + destination + "). Skipping...");
            return;
        }
        edges.add(new Edge(source, destination, weight));
    }

    // Find the MST using Kruskal's Algorithm
    public void findMST() {
        // Sort edges by weight
        Collections.sort(edges);

        // Create disjoint sets
        DisjointSet disjointSet = new DisjointSet(vertices);

        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : edges) {
            int root1 = disjointSet.find(edge.source);
            int root2 = disjointSet.find(edge.destination);

            // If adding this edge doesn't form a cycle
            if (root1 != root2) {
                mst.add(edge);
                mstWeight += edge.weight;
                disjointSet.union(root1, root2);
            }

            // Stop if MST contains (vertices - 1) edges
            if (mst.size() == vertices - 1) {
                break;
            }
        }

        // Display the MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " -- " + edge.destination + " == " + edge.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        KruskalsAlgorithm graph = new KruskalsAlgorithm(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (source destination weight):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();

            // Add edge with validation
            graph.addEdge(source, destination, weight);
        }

        graph.findMST();
        scanner.close();
    }
}
