package lab9.zad2;

import java.util.*;

public class Main {


    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;



        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p){
            if (parent[p] != p){
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }


        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    rank[rootP]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine().trim());
        String[] names = new String[N];
        Map<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < N; i++) {
            names[i] = scanner.nextLine().trim();
            nameToIndex.put(names[i], i);
        }

        int M = Integer.parseInt(scanner.nextLine().trim());
        UnionFind uf = new UnionFind(N);

        for (int i = 0; i < M; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            int person1 = nameToIndex.get(parts[0]);
            int person2 = nameToIndex.get(parts[1]);
            uf.union(person1, person2);
        }

        System.out.println(uf.getCount());
    }
}

