package FinkiBook.Stack.zad2;

import java.util.Scanner;
import java.util.Stack;

public class PostfixNotation {
    public static int solution (String line) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char c =  line.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            }else{
                if (stack.size() >=2){
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    if (c == '+'){
                        stack.push(num1 + num2);
                    }else if (c == '-'){
                        stack.push(num1 - num2);
                    }else if (c == '*'){
                        stack.push(num1 * num2);
                    }else if (c == '/'){
                        stack.push(num1 / num2);
                    } else if (c == 'x') {
                        stack.push(num1 * num2);
                    }
                }
            }
        }
        if (stack.size() != 1){
            System.out.println("Nevaliden vlez nedostasuva operator");
        }else{
            result = stack.pop();
        }

        return result;
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(solution(line));
        System.out.println(line);
    }
}
