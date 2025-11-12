package Stack.zad22;

import java.util.Scanner;
import java.util.Stack;

public class ModificatedLanguage {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);


       Stack<String> stack = new Stack<String>();

       while (true){
           String line = sc.nextLine();
           if(line.equals("x")) break;

           if (!line.startsWith("end")){
               stack.push(line);
           }else if (stack.isEmpty()){
               stack.push(line);
           }else{
               if (line.charAt(7) == stack.peek().charAt(4)){
                   stack.pop();
               }
           }
       }

       if(stack.isEmpty()){
           System.out.println("Valid");
       }else{
           System.out.println("Invalid");
       }
    }
}
