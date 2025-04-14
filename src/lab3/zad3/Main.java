package lab3.zad3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вчитување на влезот
        int N = scanner.nextInt();  // број на позиции за светилки
        int M = scanner.nextInt();  // должина на улицата
        int[] positions = new int[N];

        for (int i = 0; i < N; i++) {
            positions[i] = scanner.nextInt();
        }

        // Сортирање на позициите за полесно покривање
        Arrays.sort(positions);

        int lightCount = 0;
        int coveredUpTo = 0;  // последната покриена позиција
        int i = 0;

        // Наоѓање минимален број на светилки
        while (coveredUpTo < M) {
            int bestPosition = -1;

            // Наоѓање најдобра позиција која ќе покрие непокриени делови
            while (i < N && positions[i] <= coveredUpTo + 1 + 2) {
                bestPosition = i;
                i++;
            }

            // Ако не може да се најде светилка за да се покрие остатокот од улицата
            if (bestPosition == -1) {
                System.out.println("-1");
                return;
            }

            // Поставување светилка на најдобрата позиција
            lightCount++;
            coveredUpTo = positions[bestPosition] + 2;
        }

        // Излез
        System.out.println(lightCount);
        scanner.close();
    }
}
