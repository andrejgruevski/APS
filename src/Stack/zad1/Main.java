package Stack.zad1;
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
//Треба да се напише програма која ќе ја проверува балансираноста на следната секвенца ('(', ')', '{', '}', '[', ']')
//
//Секвенцата мора да содржи еднаков број на десни и леви загради ( '(', '{', '[' )
//
//Програмата враќа 1 доколку секвенцата е балансирана, а 0 доколку е спротивното.
//
//Inputs and Outputs Input: "({[]})" → Output: 1 (Balanced and equal counts)
//Input: "({[})" → Output: 0 (Not balanced)
//Input: "(({}))" → Output: 0 (Balanced but unequal counts)
//input: "([{}])" → Output: 1 (Balanced and equal counts)
public class Main {

    static int checkBalanceBrackets(String s) {
        ArrayStack<Character> stack = new ArrayStack<Character>(s.length());
        int obichna = 0;
        int sredna = 0;
        int golema = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                obichna++;
                stack.push(c);
            }else if (c == '{'){
                sredna++;
                stack.push(c);
            }else if (c == '['){
                golema++;
                stack.push(c);
            }

            else if (c == ')'){
                if (stack.isEmpty() || stack.pop() != '('){
                    return 0;
                }
            }else if (c == '}'){
                if (stack.isEmpty() || stack.pop() != '{'){
                    return 0;
                }
            }else if (c == ']'){
                if (stack.isEmpty() || stack.pop() != '['){
                    return 0;
                }
            }
        }
        if (!stack.isEmpty()){
            return 0;
        }
        if (obichna == sredna && sredna == golema){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(checkBalanceBrackets(input));

    }
}
