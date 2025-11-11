package Stack.zad21;
import java.util.Scanner;
import java.util.Stack;

public class RemoveConsecutiveSame {
    public static int removeConsecutiveSame(String[] arr) {

        Stack<String> stack = new Stack<>();
        int n = arr.length;


        for(int i=0;i<n;i++){
          if (!stack.isEmpty() && stack.peek().equals(arr[i])){
              stack.pop();
          }else {
              stack.push(arr[i]);
          }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        line = sc.nextLine();


        System.out.println(removeConsecutiveSame(line.split(" ")));

    }
}
