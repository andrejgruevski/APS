package lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[] niza = new int[n];
        for (int i = 0; i < n; i++) {
            niza[i] = input.nextInt();
        }

        int pozicija = binarnoPrebaruvanje(niza, m);

        if (pozicija == -1) {
            System.out.println("Ne postoi");
        } else {
            System.out.println(pozicija);
        }
    }


    public static int binarnoPrebaruvanje(int[] niza, int target) {
        int levo = 0;
        int desno = niza.length - 1;

        while (levo <= desno) {
            int sredina = levo + (desno - levo) / 2;

            if (niza[sredina] == target) {
                return sredina;
            }

            if (niza[sredina] < target) {
                levo = sredina + 1;
            }else{
                desno = sredina - 1;
            }
        }
    return -1;

}}
