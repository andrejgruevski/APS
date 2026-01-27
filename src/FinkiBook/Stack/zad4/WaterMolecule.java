package FinkiBook.Stack.zad4;


import java.util.Scanner;
import java.util.Stack;

public class WaterMolecule {
    public static String h2o(String s) {
        int counter = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'H') {
                if (!stack.isEmpty()) {
                    if (stack.peek().equals('H')) {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            } else {
                if (c == 'O') {
                    if (stack.size() >= 2) {
                        counter++;
                        stack.pop();
                        stack.pop();
                    }
                } else {
                    if (c == ' ') {
                        continue;
                    } else {
                        stack.push(c);
                    }

                }
            }
        }

        System.out.println(counter);
        return stack.toString();
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(h2o(s));
    }
}
