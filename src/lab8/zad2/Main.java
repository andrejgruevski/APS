package lab8.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BNode<E extends Comparable<E>> {
    public E info;
    public BNode<E> left;
    public BNode<E> right;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree<E extends Comparable<E>> {
    public BNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(E x) {
        root = insert(x, root);
    }

    private BNode<E> insert(E x, BNode<E> t) {
        if (t == null) {
            t = new BNode<>(x, null, null);
        } else if (x.compareTo(t.info) < 0) {
            t.left = insert(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = insert(x, t.right);
        }
        return t;
    }
}

public class Main {

    static int pomala(BNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }
        if (x > root.info) {
            return 1 + pomala(root.left, x) + pomala(root.right, x);
        } else {
            return pomala(root.left, x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vlez = br.readLine().split(" ");
        int N = Integer.parseInt(vlez[0]);
        int Q = Integer.parseInt(vlez[1]);
        BinarySearchTree<Integer> drvo = new BinarySearchTree<Integer>();
        for (int i = 0; i < N + Q; i++) {
            String[] input = br.readLine().split(" ");
            int jazol = Integer.parseInt(input[1]);
            switch (input[0]) {
                case "insert":
                    drvo.insert(Integer.parseInt(input[1]));
                    break;
                case "ask":
                    System.out.println(pomala(drvo.root, jazol));
                    break;
            }
        }
    }

}
