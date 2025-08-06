package Stack.zad10;
import java.util.Scanner;
import java.util.Stack;
public class DoubleBrackets {
    public static boolean foundDoubleBrackets(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int counter = 0;

                while (!stack.isEmpty() && stack.peek() != '('){
                    stack.pop();
                    counter++;
                }

                if (counter == 0){
                    return true;
                }

                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (foundDoubleBrackets(input)){
            System.out.println("Found double brackets!");
        }else{
            System.out.println("There is no double brackets.");
        }
    }
}
