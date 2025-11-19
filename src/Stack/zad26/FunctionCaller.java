package Stack.zad26;

import java.awt.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
 class LinkedStack<E> implements Stack<E> {
    // top e link do prviot jazol ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
    private SLLNode<E> top;
    int size;

    public LinkedStack() {
        // Konstrukcija na nov, prazen stek.
        top = null;
        size = 0;
    }

    public String toString() {
        SLLNode<E> current = top;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.element);
            s.append(" ");
            current = current.succ;
        }
        return s.toString();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (top == null);
    }

    public void clear() {
        // Go prazni stekot.
        top = null;
        size = 0;
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (top == null)
            throw new NoSuchElementException();
        return top.element;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        top = new SLLNode<E>(x, top);
        size++;
    }

    public int size() {
        // Ja vrakja dolzinata na stekot.
        return size;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (top == null)
            throw new NoSuchElementException();
        E topElem = top.element;
        size--;
        top = top.succ;
        return topElem;
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
class Frame {
    String name;
    int counter;

    Frame(String name) {
        this.name = name;
        this.counter = 0;
    }
}
public class FunctionCaller {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedStack<Frame> stack = new LinkedStack<>();
        String bestFunc = null;
        int bestCounter = -1;
        for (int i = 0; i < n; i++) {
            String[]parts = sc.nextLine().trim().split(" ");
            if (parts[0].equalsIgnoreCase("Call")){
                String func = parts[1];
                if (!stack.isEmpty()){
                   Frame cur = stack.peek();
                   cur.counter++;
                }
                stack.push(new Frame(func));
            }else if (parts[0].equalsIgnoreCase("return")){
                if (!stack.isEmpty()){
                    Frame done = stack.pop();

                    if (done.counter > bestCounter){
                        bestCounter = done.counter;
                        bestFunc = done.name;
                    }
                }
            }
        }
        if (bestFunc !=null){
            System.out.println(bestFunc + " " + bestCounter);
        }


    }
}
