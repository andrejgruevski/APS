package Voved_vo_Java;

import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        StringBuilder obratenZbor = new StringBuilder(word);
        System.out.println(obratenZbor.reverse().toString());
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int brojZborovi = input.nextInt();
        input.nextLine();

        for (int i = 0; i < brojZborovi; i++) {
            String zbor=input.nextLine();
            printReversed(zbor);
        }
    }
}
