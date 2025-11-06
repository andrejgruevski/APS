package lab3.zad4;

import java.util.Arrays;
import java.util.Scanner;

//Дадени се N возови со време на пристигање и поаѓање. Да се најде минималниот број на платформи потребен за да се сместат тие возови.
//Влез: Првиот број од влезот е бројот на возови N, а потоа во следниот ред минутата на пристигнување и минутата на поаѓање на возот.
//Излез: Најмалиот потребен број на платформи за да се сместат сите возови
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []departure = new int[n];
        int []arrival = new int[n];
        for (int i = 0; i < n; i++) {
            departure[i] = sc.nextInt();
            arrival[i] = sc.nextInt();
        }
        Arrays.sort(departure);
        Arrays.sort(arrival);
        int platforms = 0, result = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (departure[i]<=arrival[j]) {
                platforms++;
                i++;
            }else{
                platforms--;
                j++;
            }
            result = Math.max(result, platforms);
        }
        System.out.println(result);
    }
}
