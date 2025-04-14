package lab5;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            Stack<String> stack = new Stack<>();
            boolean flag = true;

            while (true) {
                String linija = input.nextLine().trim();

                if (linija.equals("x")) {
                    break;
                }

                if (!linija.startsWith("end")) {
                    stack.push(linija);
                }else {
                    String funkName = linija.substring(3);
                    if (stack.isEmpty() || !stack.peek().equals(funkName)) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }
            input.close();
    }
}
