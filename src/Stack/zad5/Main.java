package Stack.zad5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//Даден е некој модифициран XML код. Модифицираниот XML код ги користи симболите '[' и ']', за отварање и затворање на таг, соодветно, наместо стандардните '<' и '>'. Треба да се провери дали сите тагови во кодот се правилно вгнездени (дали кодот е валиден) т.е. дали секој отворен таг има соодветен затворен таг со истото име на соодветното место во кодот. За поедноставување, дадено е дека секој отворен таг мора да има свој затворен таг и дека таговите немаат атрибути.
//
//На влез е даден бројот на редови во кодот и самиот XML со секој таг во посебен ред, а на излез треба да се испечати 1 или 0 за валиден или невалиден код, соодветно.
//
//Објаснување: Во модифицираниот XML код секој отворен таг е во облик [imeNaTag], а соодветниот затворен таг е во облик [/imeNaTag].
//
//Пример за правилно вгнездени тагови во XML e:
//
//[tag1] [tag2] Podatok [/tag2] [/tag1]
//
//Пример за неправилно вгнездени тагови во XML e:
//
//[tag1] [tag2] Podatok [/tag1] [/tag2]
//
//Input
//8
//[html]
//[head]
//[title]
//[/title]
//[/head]
//[body]
//[/body]
//[/html]
//output 1
//
//9
//[html]
//[head]
//[title]
//[/head]
//[/title]
//[/head]
//[body]
//[/body]
//[/html]
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str.trim());
        String [] redovi = new String[num];

        for (int i = 0; i < num; i++) {
            redovi[i] = br.readLine();
        }

        int valid = 1;
        ArrayStack<String> stack = new ArrayStack<>(num);
        for (int i = 0; i < num; i++) {
            if (redovi[i].charAt(0) == '['){
                if (redovi[i].charAt(1) == '/'){
                    if (!stack.peek().equals(redovi[i].substring(2, redovi[i].length()-1))){
                        valid = 0;
                        break;
                    }else{
                        stack.pop();
                    }
                }else{
                    stack.push(redovi[i].substring(1, redovi[i].length() - 1));
                }
            }
        }
        System.out.println(valid);
        br.close();

    }
}
