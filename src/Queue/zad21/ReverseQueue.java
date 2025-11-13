package Queue.zad21;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;

        int front = q.peek();
        q.poll();

        reverseQueue(q);

        q.add(front);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        reverseQueue(queue);
        System.out.println(queue);
    }
}
