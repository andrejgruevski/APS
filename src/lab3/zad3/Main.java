package lab3.zad3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] positions = new int[N];

        for (int i = 0; i < N; i++) {
            positions[i] = scanner.nextInt();
        }


        Arrays.sort(positions);

        int lightCount = 0;
        int coveredUpTo = 0;
        int i = 0;


        while (coveredUpTo < M) {
            int bestPosition = -1;


            while (i < N && positions[i] <= coveredUpTo + 1 + 2) {
                bestPosition = i;
                i++;
            }


            if (bestPosition == -1) {
                System.out.println("-1");
                return;
            }


            lightCount++;
            coveredUpTo = positions[bestPosition] + 2;
        }


        System.out.println(lightCount);
        scanner.close();
    }
}
