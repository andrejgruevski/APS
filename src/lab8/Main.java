package lab8;

import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Метод за вметнување нов јазол во дрвото
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    // Метод за наоѓање на длабочина на даден јазол
    public int ask(int value) {
        return findDepth(root, value, 1);
    }

    private int findDepth(TreeNode node, int value, int depth) {
        if (node == null) {
            return -1; // Ако вредноста не постои
        }
        if (node.value == value) {
            return depth;
        } else if (value < node.value) {
            return findDepth(node.left, value, depth + 1);
        } else {
            return findDepth(node.right, value, depth + 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Број на наредби
        int q = scanner.nextInt(); // Број на прашања

        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < n + q; i++) {
            String command = scanner.next();
            int value = scanner.nextInt();

            if (command.equals("insert")) {
                bst.insert(value);
            } else if (command.equals("ask")) {
                System.out.println(bst.ask(value));
            }
        }
        scanner.close();
    }
}

