package lab5.zad2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int n = input.nextInt();
        input.nextLine();

        Queue<String> nosiDokumentiQueue = new LinkedList<>();
        Queue<String> indexQueue = new LinkedList<>();
        Queue<String> srednoDokumentiQueue = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            String studentName = input.nextLine();
            int appliesDocuments = input.nextInt();
            int takesIndex = input.nextInt();
            int takesSecondaryDocuments = input.nextInt();
            input.nextLine();


            if (appliesDocuments == 1) {
                nosiDokumentiQueue.add(studentName);
            }
            if (takesIndex == 1) {
                indexQueue.add(studentName);
            }
            if (takesSecondaryDocuments == 1) {
                srednoDokumentiQueue.add(studentName);
            }
        }


        while (!nosiDokumentiQueue.isEmpty() || !indexQueue.isEmpty() || !srednoDokumentiQueue.isEmpty()) {
            if (!nosiDokumentiQueue.isEmpty()) {
                String student = nosiDokumentiQueue.poll();
                if (!indexQueue.contains(student) && !srednoDokumentiQueue.contains(student)) {
                    System.out.println(student);
                }
            }
            if (!indexQueue.isEmpty()) {
                String student = indexQueue.poll();
                if (!nosiDokumentiQueue.contains(student) && !srednoDokumentiQueue.contains(student)) {
                    System.out.println(student);
                }
            }
            if (!srednoDokumentiQueue.isEmpty()) {
                String student = srednoDokumentiQueue.poll();
                if (!nosiDokumentiQueue.contains(student) && !indexQueue.contains(student)) {
                    System.out.println(student);
                }
            }
        }
    }
}
