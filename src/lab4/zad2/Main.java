package lab4.zad2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
//        int result = 0;

        // vashiot kod ovde / your code goes here
        int[]tb = new int [x+1];

        for (int i = 1; i <= x; i++) {
            tb[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= x; i++) {
            for (int n = 1; n * n <= i; n++) {
                tb[i] = Math.min(tb[i],tb[i - n * n] + 1);
            }

        }

        System.out.println(tb[x]);
//        System.out.println(result);
    }
}
