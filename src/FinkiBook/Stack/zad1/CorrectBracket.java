package FinkiBook.Stack.zad1;

import java.util.Scanner;
import java.util.Stack;

//Да се провери коректноста на заградите во еден израз. Еден израз има коректни
//загради ако:
//        - За секоjа лева заграда, подоцна следува соодветна десна заграда - За секоjа
//десна заграда претходно постои лева заграда
//- Секоj под-израз ме´гу пар од две загради содржи коректен броj на загради.
//Примери на изрази со коректни и некоректни загради: s x (s – a) x (s – b) x
//        (s - c) коректни
//(– b + sqrt[b2 – 4ac]) / 2a коректни
//s x (s – a) x (s – b x (s – c) некоректни
//s x (s – a) x s – b) x (s – c) некоректни
public class CorrectBracket {
    public static void isCorrect(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '[') {
                if (c == ']') {
                    stack.pop();
                }
            } else if (!stack.isEmpty() && stack.peek() == '{') {
                if (c == '}') {
                    stack.pop();
                }

            } else if (!stack.isEmpty() && stack.peek() == '(') {
                if (c == ')') {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Bracket correct");
        } else {
            System.out.println("Bracket incorrect");
        }
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        isCorrect(line);
    }
}
