package lab10.zad2;

import java.util.*;

public class Main {
    static class Transformation {
        String to;
        int cost;

        public Transformation(String to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, String> neededIngredients = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] pair = scanner.nextLine().split(" ");
            neededIngredients.put(pair[0], pair[1]);
        }


        int m = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<Transformation>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] transformation = scanner.nextLine().split(" ");
            String from = transformation[0];
            String to = transformation[1];
            int cost = Integer.parseInt(transformation[2]);

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Transformation(to, cost));
        }


        int totalCost = 0;
        for (String available : neededIngredients.keySet()) {
            String needed = neededIngredients.get(available);
            int cost = findMinimalCost(graph, available, needed);

            totalCost += cost;
        }

        System.out.println(totalCost);
    }

    private static int findMinimalCost(Map<String, List<Transformation>> graph, String start, String target) {
        // dijkstra !
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Transformation> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.cost));

        pq.add(new Transformation(start, 0));

        while (!pq.isEmpty()) {
            Transformation current = pq.poll();

            if (distances.containsKey(current.to) && distances.get(current.to) <= current.cost) {
                continue;
            }

            distances.put(current.to, current.cost);

            if (current.to.equals(target)) {
                return current.cost;
            }

            if (graph.containsKey(current.to)) {
                for (Transformation neighbor : graph.get(current.to)) {
                    pq.add(new Transformation(neighbor.to, current.cost + neighbor.cost));
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
