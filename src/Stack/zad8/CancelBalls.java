package Stack.zad8;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

//interface Stack<E> {
//    // Elementi na stekot se objekti od proizvolen tip.
//    // Metodi za pristap:
//
//    public boolean isEmpty();
//    // Vrakja true ako i samo ako stekot e prazen.
//
//    public E peek();
//    // Go vrakja elementot na vrvot od stekot.
//
//    // Metodi za transformacija:
//    public void clear();
//    // Go prazni stekot.
//
//    public void push(E x);
//    // Go dodava x na vrvot na stekot.
//
//    public E pop();
//    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
//}
//
//class ArrayStack<E> implements Stack<E> {
//    private E[] elems; //elems[0...depth-1] se negovite elementi.
//    private int depth; //depth e dlabochinata na stekot
//
//    @SuppressWarnings("unchecked")
//    public ArrayStack(int maxDepth) {
//        // Konstrukcija na nov, prazen stek.
//        elems = (E[]) new Object[maxDepth];
//        depth = 0;
//    }
//
//    public boolean isEmpty() {
//        // Vrakja true ako i samo ako stekot e prazen.
//        return (depth == 0);
//    }
//
//    public E peek() {
//        // Go vrakja elementot na vrvot od stekot.
//        if (depth == 0)
//            throw new NoSuchElementException();
//        return elems[depth - 1];
//    }
//
//    public void clear() {
//        // Go prazni stekot.
//        for (int i = 0; i < depth; i++) elems[i] = null;
//        depth = 0;
//    }
//
//    public void push(E x) {
//        // Go dodava x na vrvot na stekot.
//        elems[depth++] = x;
//    }
//
//    public int size() {
//        // Ja vrakja dolzinata na stack-ot.
//        return depth;
//    }
//
//    public E pop() {
//        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
//        if (depth == 0)
//            throw new NoSuchElementException();
//        E topmost = elems[--depth];
//        elems[depth] = null;
//        return topmost;
//    }
//}

public class CancelBalls {
    public static boolean ballCancel(String ch1, String ch2) {
        if (ch1.equals("R+") && ch2.equals("R-") || ch1.equals("R-") && ch2.equals("R+")) return true;
        if (ch1.equals("G+") && ch2.equals("G-") || ch1.equals("G-") && ch2.equals("G+")) return true;
        return ch1.equals("B+") && ch2.equals("B-") || ch1.equals("B-") && ch2.equals("B+");
    }

    public static String partners(String ch) {
        if (ch.equals("R+")) return "R-";
        else if (ch.equals("R-")) return "R+";
        else if (ch.equals("G+")) return "G-";
        else if (ch.equals("G-")) return "G+";
        else if (ch.equals("B+")) return "B-";
        else if (ch.equals("B-")) return "B+";
        else return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        String[] tokens = token.split("\\s+");

        Stack<String> red = new Stack<>();
        Stack<String> green = new Stack<>();
        Stack<String> blue = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].charAt(0) == 'R') {
                if (red.isEmpty()) red.push(tokens[i]);
                else if (ballCancel(red.peek(), tokens[i])) red.pop();
                else red.push(tokens[i]);
            }
            if (tokens[i].charAt(0) == 'G') {
                if (green.isEmpty()) green.push(tokens[i]);
                else if (ballCancel(green.peek(), tokens[i])) green.pop();
                else green.push(tokens[i]);
            }
            if (tokens[i].charAt(0) == 'B') {
                if (blue.isEmpty()) blue.push(tokens[i]);
                else if (ballCancel(blue.peek(), tokens[i])) blue.pop();
                else blue.push(tokens[i]);
            }
        }
        System.out.println(red);
        System.out.println(green);
        System.out.println(blue);

        int counter = red.size() + green.size() + blue.size();
        System.out.println(counter);

        for (String ball : red) {
            System.out.print(partners(ball) + " ");
        }

        for (String ball : green) {
            System.out.print(partners(ball) + " ");
        }

        for (String ball : blue) {
            System.out.print(partners(ball) + " ");
        }

    }
}
