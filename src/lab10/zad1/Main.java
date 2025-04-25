package lab10.zad1;

import java.util.*;

class Edge implements Comparable<Edge> {
    String u, v;
    int weight;

    public Edge(String u, String v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading number of settlements
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> settlementIndex = new HashMap<>();
        String[] settlements = new String[n];

        for (int i = 0; i < n; i++) {
            String settlement = scanner.nextLine();
            settlements[i] = settlement;
            settlementIndex.put(settlement, i);
        }

        // Reading number of roads
        int m = Integer.parseInt(scanner.nextLine());
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] roadData = scanner.nextLine().split(" ");
            String u = roadData[0];
            String v = roadData[1];
            int weight = Integer.parseInt(roadData[2]);
            edges.add(new Edge(u, v, weight));
        }

        // Sorting edges by weight
        Collections.sort(edges);

        // Kruskal's algorithm for Minimum Spanning Tree
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        List<Edge> mstEdges = new ArrayList<>();

        for (Edge edge : edges) {
            int u = settlementIndex.get(edge.u);
            int v = settlementIndex.get(edge.v);

            if (find(parent, u) != find(parent, v)) {
                union(parent, u, v);
                totalCost += edge.weight;
                mstEdges.add(edge);
            }
        }

        // Output the total cost and the edges in the MST
        System.out.println(totalCost);
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
