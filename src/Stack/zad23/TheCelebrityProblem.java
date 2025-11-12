package Stack.zad23;

import java.util.Scanner;
import java.util.Stack;

//A celebrity is a person who is known to all but does not know
// anyone at a party. A party is being organized by some people.
// A square matrix mat[][] of size n*n is used to represent people
// at the party such that if an element of row i and column j is set to 1
// it means ith person knows jth person. You need to return the index of
// the celebrity in the party, if the celebrity does not exist, return -1.
public class TheCelebrityProblem {
    public static int celebrity(int mat[][]) {
        Stack<Integer> stack = new Stack<>();
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.peek();
            stack.pop();
            int b = stack.peek();
            stack.pop();

            if (mat[a][b] != 0) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int c = stack.peek();
        stack.pop();

        for (int i = 0; i < n; i++) {
            if (i == c) continue;
            if (mat[c][i] != 0 || mat[i][c] == 0) {
                return -1;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(celebrity(matrix));

    }
}
