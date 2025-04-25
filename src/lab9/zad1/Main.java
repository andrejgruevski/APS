package lab9.zad1;

import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int patishta = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int startNode = sc.nextInt();
        int targetSum = sc.nextInt();

        dfs(startNode, 0, targetSum, new ArrayList<>());

        System.out.println(patishta);
    }
    static void dfs(int node, int currentSum, int targetSum, List<Integer> path) {
        currentSum += node;
        path.add(node);

        if (currentSum == targetSum) {
            patishta++;
        }
        for (int sosed : graph.getOrDefault(node, Collections.emptyList())) {
            if (path.size() < graph.size() * 2) {
                dfs(sosed, currentSum, targetSum, new ArrayList<>(path));
            }
        }
    }
}
