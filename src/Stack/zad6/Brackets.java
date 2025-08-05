package Stack.zad6;

import java.util.NoSuchElementException;
import java.util.Scanner;

class ArrayStack<E> implements Stack<E> {
    private E[] elems; //elems[0...depth-1] se negovite elementi.
    private int depth; //depth e dlabochinata na stekot

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }

    public int size() {
        // Ja vrakja dolzinata na stack-ot.
        return depth;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

interface Stack<E> {
    // Elementi na stekot se objekti od proizvolen tip.
    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:
    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

public class Brackets {
    public static boolean matching(char left, char right) {
        if (left == '(' && right == ')') return true;
        if (left == '[' && right == ']') return true;
        return (left == '{' && right == '}');


    }

    public static boolean isCorrect(String s) {
        ArrayStack<Character> brackets = new ArrayStack<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i); // zemame nekoj karakter
            if (current == '(' || current == '[' || current == '{') {
                brackets.push(current);
            }
            if (current == ')' || current == ']' || current == '}') {
                if (brackets.isEmpty()) return false;
                char leftBracket = brackets.pop();
                if (!matching(leftBracket, current)) return false;
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        String s = "s + [(s-a) * (s - b)]";
        System.out.println(isCorrect(s));

    }
}
