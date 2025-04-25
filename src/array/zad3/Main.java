//За дадена низа од N цели броеви, да се избришат елементите со вредност помала од просекот на сите елементи во низата. На пример за низата 1, 2, 3, 4, 5 просекот е (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3, што значи треба да се избришат елементите 1 и 2, што значи низата после оваа трансформација ќе биде 3, 4, 5.
//
//Влез: Првиот број од влезот е бројот на елементи во низата N, а потоа во следниот ред се дадени самите елементи одделени со празно место.
//
//        Излез: Низата пред и после направената трансформација.
package array.zad3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double avg =(double)sum / n;


        System.out.print("{");
        boolean first1 = true;
        for (int i = 0; i < n; i++) {
            if (!first1){
                System.out.print(",");
            }
            System.out.print(arr[i]);
            first1 = false;
        }
        System.out.print("}");

        System.out.println();


        System.out.print("{");
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= avg) {
                if (!first) {
                    System.out.print(",");
                }
                System.out.print(arr[i]);
                first = false;
            }
        }
        System.out.print("}");

    }
}
