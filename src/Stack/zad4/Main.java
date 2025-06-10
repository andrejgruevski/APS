package Stack.zad4;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        boolean flag = true;

        while (true){
            String line = sc.nextLine().trim();

            if (line.equals("x")){
                break;
            }
            if (!line.startsWith("end")){
                stack.push(line);
            }else{
                String line2 = line.substring(3);
                if (stack.isEmpty() || !stack.peek().equals(line2)){
                    flag = false;
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()){
            flag = false;
        }
        if (flag){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }

    }
}
