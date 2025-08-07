package Stack.zad14;

import java.util.Scanner;
import java.util.Stack;

public class BallGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Character> box1 = new Stack<>();
        Stack<Character> box2 = new Stack<>();
        Stack<Character> box3 = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            box1.push(c);

            if (box1.size() >= 3) {
                char top1 = box1.pop();
                char top2 = box1.pop();
                char top3 = box1.pop();

                if (top1 == 'R' && top2 == 'R' && top3 == 'R') {

                    while (!box1.isEmpty() && box1.peek() == 'R') {
                        box1.pop();
                    }
                } else {
                    box1.push(top3);
                    box1.push(top2);
                    box1.push(top1);
                }
            }
        }

        while (!box1.isEmpty()) {
            if (box1.peek() == 'R') {
                box3.push(box1.pop());
            } else if (box1.peek() == 'B' && box2.isEmpty()) {
                box2.push(box1.pop());
            } else {
                while (!box1.isEmpty() && box1.peek() == 'G') box3.push(box1.pop());
                while (!box2.isEmpty() && box2.peek() == 'G') box3.push(box2.pop());
                while (!box1.isEmpty() && box1.peek() == 'B') box2.push(box1.pop());
                while (!box3.isEmpty() && box3.peek() == 'G') box2.push(box3.pop());
            }
        }


        while (!box2.isEmpty() && box2.peek() == 'G') box3.push(box2.pop());
        while (!box2.isEmpty() && box2.peek() == 'B') box3.push(box2.pop());

        while (!box3.isEmpty()) {
            System.out.println(box3.pop());
        }
    }
}
