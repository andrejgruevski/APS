package FinkiBook.Tree.Zad1;

class TreeNode<T extends Comparable<T>> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

 class BinaryTree<T extends Comparable<T>> {
    public TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public TreeNode<T> addLeftChild(T x, TreeNode<T> parent) {
        TreeNode<T> newNode = new TreeNode<>(x);

        if (parent == null) {
            root = newNode;
        } else {
            newNode.left = parent.left;
            parent.left = newNode;
        }
        return newNode;
    }

    public TreeNode<T> addRightChild(T x, TreeNode<T> parent) {
        TreeNode<T> newNode = new TreeNode<>(x);

        if (parent == null) {
            root = newNode;
        } else {
            newNode.right = parent.right;
            parent.right = newNode;
        }
        return newNode;
    }

    public void makeRoot(T data) {
        root = new TreeNode<>(data);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(TreeNode<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class CreateBinaryTree {
    public static BinaryTree<String> GetExampleStringTree(){

        BinaryTree<String> tree = new BinaryTree<String>();
        tree.makeRoot("apple");

        TreeNode<String> node1 = tree.addLeftChild("pear", tree.root);

        TreeNode<String> node2 = tree.addLeftChild("peach", node1);

        TreeNode<String> node3 = tree.addRightChild("banana", tree.root);
        node2 = tree.addRightChild("orange", node3);
        node2 = tree.addLeftChild("lemon", node3);

        return tree;

    }
    static void main() {
        BinaryTree<String> tree = GetExampleStringTree();

        tree.inorder();
        tree.preorder();
        tree.postorder();

    }
}
