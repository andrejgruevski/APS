package Stack.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        return depth == 0;
    }

    public E peek() {
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        elems[depth++] = x;
    }

    public int size() {
        return depth;
    }

    public E pop() {
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

interface Stack<E> {
    public boolean isEmpty();
    public E peek();
    public void clear();
    public void push(E x);
    public E pop();
}

public class Main {

    public static int evaluateExpression(String str) {
        ArrayStack<Integer> stack = new ArrayStack<>(str.length());
        String number = "";
        char operator = '+';

        str += '+';

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                number += str.charAt(i);
            } else {
                if (!number.isEmpty()) { // Додај проверка за празен стринг пред конверзија
                    if (operator == '+') {
                        stack.push(Integer.parseInt(number));
                    } else if (operator == '*' && !stack.isEmpty()) { // Проверка дали стекот има елемент пред pop()
                        stack.push(Integer.parseInt(number) * stack.pop());
                    }
                }

                number = "";
                operator = str.charAt(i);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }
}
