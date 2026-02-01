package FinkiBook.Tree.zad2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Во следната задача треба да изградите неподредено (општо) дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку лисја има поддрвото на избран јазол“.
//
//Секој јазол ќе има уникатен индекс од 1 до N. Коренот на дрвото секогаш ќе има индекс 1. Сите деца ќе имаат индекси поголеми од индексите на родителите.
//
//Влезот ќе содржи N+Q редови од видот
//
//root 1 - Треба да го поставите коренот на дрвото да биде јазелот со индекс 1
//
//add parent_index child_index - Треба да додадете дете јазел со индекс child_index на јазелот со индекс parent_index
//
//ask node_index - Треба да одговорите колку листови има во поддрвото на јазелот со индекс node_index
//
//Пример и структура на влезот:
//
//Влез
//
//Објаснување
//
//Излез
//
//11 5
//root 1
//add 1 2
//add 2 3
//ask 1
//add 1 4
//add 2 5
//add 3 6
//ask 2
//add 3 7
//ask 1
//add 1 8
//add 4 9
//add 2 10
//add 4 11
//ask 2
//ask 1
//
//Прикажано е изгледот на дрвото при секое од 5те прашања во влезот
//
//прашање 1
//
//
//
//прашање 1: ask 1: Во поддрвото на јазелот 1 има 1 лист.
//прашање 2: ask 2: Во поддрвото на јазелот 2 има 2 листови.
//прашање 3: ask 1: Во поддрвото на јазелот 1 има 4 листови.
//прашање 4: ask 2: Во поддрвото на јазелот 2 има 4 листови
//прашање 5: ask 1: Во поддрвото на јазелот 1 има 7 листови
//1
//2
//4
//4
//7
//

class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode<E> parent;

    public BNode(E info, BNode<E> parent) {
        this.parent = parent;
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info) {
        this.parent = null;
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

class BTree<E> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem, node);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public void inorder() {
        System.out.print("INORDER: ");
        inorderR(root);
        System.out.println();
    }

    public void inorderR(BNode<E> n) {
        if (n != null) {
            inorderR(n.left);
            System.out.print(n.info.toString() + " ");
            inorderR(n.right);
        }
    }

    public void preorder() {
        System.out.print("PREORDER: ");
        preorderR(root);
        System.out.println();
    }

    public void preorderR(BNode<E> n) {
        if (n != null) {
            System.out.print(n.info.toString() + " ");
            preorderR(n.left);
            preorderR(n.right);
        }
    }

    public void postorder() {
        System.out.print("POSTORDER: ");
        postorderR(root);
        System.out.println();
    }

    public void postorderR(BNode<E> n) {
        if (n != null) {
            postorderR(n.left);
            postorderR(n.right);
            System.out.print(n.info.toString() + " ");
        }
    }


    int insideNodesR(BNode<E> node) {
        if (node == null)
            return 0;

        if ((node.left == null) && (node.right == null))
            return 0;

        return insideNodesR(node.left) + insideNodesR(node.right) + 1;
    }

    public int insideNodes() {
        return insideNodesR(root);
    }

    int leavesR(BNode<E> node) {
        if (node != null) {
            if ((node.left == null) && (node.right == null))
                return 1;
            else
                return (leavesR(node.left) + leavesR(node.right));
        } else {
            return 0;
        }
    }

    public int leaves() {
        return leavesR(root);
    }

    int depthR(BNode<E> node) {
        if (node == null)
            return 0;
        if ((node.left == null) && (node.right == null))
            return 0;
        return (1 + Math.max(depthR(node.left), depthR(node.right)));
    }

    public int depth() {
        return depthR(root);
    }

    void mirrorR(BNode<E> node) {
        BNode<E> tmp;

        if (node == null)
            return;

        // simetricno preslikuvanje na levoto i desnoto potsteblo
        mirrorR(node.left);
        mirrorR(node.right);

        // smena na ulogite na pokazuvacite na momentalniot jazel
        tmp = node.left;
        node.left = node.right;
        node.right = tmp;

    }

    public void mirror() {
        mirrorR(root);
    }

}

public class BinaryTree {
    static int countInternal (BNode<String> node){
        if (node == null) return 0;

        if (node.left == null && node.right == null) return 0;

        return 1 + countInternal(node.left) + countInternal(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        BTree<String> tree = new BTree<String>();
        Map<String, BNode<String>> map = new HashMap<String, BNode<String>>();

        for (int i =0; i<=n+q; i++){
            String line = sc.nextLine();
            String[]parts =  line.split(" ");

            if (parts[0].equals("root")){
                String name = parts[1];
                tree.makeRoot(name);
                map.put(name,tree.root);
            }else if (parts[0].equals("add")){
                String parent = parts[1];
                String child = parts[2];
                String side = parts[3];

                BNode<String> parrentNode = map.get(parent);
                BNode<String> childNode;

                if (side.equals("LEFT")){
                    childNode = tree.addChild(parrentNode,BNode.LEFT, child);
                }else{
                    childNode = tree.addChild(parrentNode,BNode.RIGHT, child);

                }
                map.put(child,childNode);
            }else if (parts[0].equals("ask")){
                String name = parts[1];
                BNode<String> node = map.get(name);
                System.out.println(countInternal(node));
            }

        }
    }
}
