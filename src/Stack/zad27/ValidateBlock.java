package Stack.zad27;

import java.util.Scanner;
import java.util.Stack;
//Даден е модифициран програмски јазик во кој блоковите започнуваат со beginX и завршуваат со endX, каде X е име на блок.
//
//Блоковите можат да бидат вгнездени, но мора да се затвораат по LIFO редослед.
//
//Влез
//
//Се внесуваат редови со тагови (beginX или endX) сè додека не се внесе "END".
//
//Излез
//
//Испечати:
//
//"Valid" – ако кодот е валиден
//
//"Invalid" – ако кодот не е валиден
public class ValidateBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        boolean flag = true;
        while (true) {
            String command = sc.nextLine();
            if (command.equals("END")) break;

            if (command.startsWith("begin")) {
                stack.push(command.substring(5));
            } else if (command.startsWith("end")) {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }

                String name = command.substring(3);
                if (!stack.peek().equals(name)) {
                    flag = false;
                    break;
                }
                stack.pop();
            }

        }
        if (flag && stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
