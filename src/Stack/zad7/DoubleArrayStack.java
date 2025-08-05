package Stack.zad7;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

public class DoubleArrayStack<E> {
    private E[] elems;
    private int d1, d2;

    public DoubleArrayStack(int maxDepth) {
        elems = (E[]) new Object[maxDepth];
        d1 = 0;
        d2 = 0;
    }

    public boolean isFull() {
        return (d1 + d2 == elems.length);
    }

    public boolean isEmpty() {
        return (d1 == 0);
    }

    public boolean isEmptySecond() {
        return (d2 == 0);
    }

    public void clearFirst() {
        for (int i = 0; i < d1; i++) elems[i] = null;
        d1 = 0;
    }

    public void clearSecond() {
        for (int i = elems.length - 1; i > elems.length - d2; i--) elems[i] = null;
        d2 = 0;
    }

    public E peekFirst() {
        if (d1 == 0) return null;
        return elems[d1 - 1];
    }

    public E peekSecond() {
        if (d2 == 0) return null;
        return elems[elems.length - d2];
    }

    public void pushFirst(E x) {
        if (!isFull())
            elems[d1++] = x;
        else System.out.println("Stack is full");
    }

    public void pushSecond(E x) {
        if (!isFull())
            elems[elems.length - (++d2)] = x;
        else System.out.println("Stack is full");
    }

    public E popFirst() {
        if (d1 == 0) return null;
        E topmost = elems[--d1];
        elems[d1] =  null;
        return topmost;
    }

    public E popSecond() {
        if (d1 == 0) return null;
        E topmost = elems[elems.length - d2];
        elems[d2--] = null;
        return topmost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E elems : elems) {
            sb.append(elems).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleArrayStack<Integer> doubleArrayStack = new DoubleArrayStack<>(7);
        doubleArrayStack.pushFirst(1);
        doubleArrayStack.pushFirst(2);
        doubleArrayStack.pushFirst(3);
        doubleArrayStack.pushSecond(-1);
        doubleArrayStack.pushSecond(-2);
        doubleArrayStack.pushSecond(-3);

        System.out.println("Vrv na prv: "+ doubleArrayStack.peekFirst() + " dolzina na prv "+doubleArrayStack.d1);
        System.out.println("Vrv na vtor: "+ doubleArrayStack.peekSecond() + " dolzina na vtor "+doubleArrayStack.d2);

        doubleArrayStack.pushFirst(4);
        doubleArrayStack.popFirst();
        doubleArrayStack.pushFirst(4);
        System.out.println("Vrv na prv: "+ doubleArrayStack.peekFirst() + " dolzina na prv "+doubleArrayStack.d1);
    }
}
