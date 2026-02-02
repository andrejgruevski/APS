package Stack.zad28;

import java.util.Scanner;
import java.util.Stack;

public class SimulateTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<String>stack = new Stack<>();

        for (int i=0; i<=n; i++){
            String line = sc.nextLine();
            if (line.startsWith("TYPE")){
                String[]p = line.split(" ");
                stack.push(p[1]);
            }else if (line.startsWith("UNDO")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else if (line.startsWith("SHOW")){
                System.out.println(stack);
            }
        }
    }
}
