package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();

        int[] cifri = new int[n];
        for (int i = 0; i < n; i++) {
            cifri[i] = input.nextInt();
        }

        Arrays.sort(cifri);

        StringBuilder najgolemBroj = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            najgolemBroj.append(cifri[i]);
        }

        System.out.println(najgolemBroj);
    }
}
