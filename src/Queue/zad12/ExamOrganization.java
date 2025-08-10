package Queue.zad12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ExamOrganization {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> eTest = new LinkedList<>();
        Queue<String> practical = new LinkedList<>();
        Queue<String> both = new LinkedList<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i =0; i<n; i++){
            eTest.add(br.readLine());
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i =0; i<m; i++){
            practical.add(br.readLine());
        }

        int k = Integer.parseInt(br.readLine().trim());
        for (int i =0; i<k; i++){
            both.add(br.readLine());
        }

        LinkedList<String> eventETest = new LinkedList<>();
        LinkedList<String> eventPractical = new LinkedList<>();

        while(!eTest.isEmpty()) eventETest.add(eTest.poll());

        while (!both.isEmpty()){
            String student = both.poll();
            eventETest.add(student);
            practical.offer(student);
        }

        while (!practical.isEmpty())eventPractical.add(practical.poll());

        int etesttermini = (int) Math.ceil((double)(n+k)/20);
        int praktichnotermini = (int) Math.ceil((double)(m+k)/20);

        System.out.println("Polagaat e-test: ");
        for (int i = 1; i<=etesttermini; i++){
            System.out.println("Termin "+ i + ":");
            int printed = 0;

            while (printed < 20 && !eventETest.isEmpty()){
                System.out.println(eventETest.poll());
                printed++;
            }
        }

        System.out.println("Polagaat zadachi: ");
        for (int i = 1; i<=praktichnotermini; i++){
            System.out.println("Termin "+ i + ":");
            int printed = 0;

            while (printed < 20 && !eventETest.isEmpty()){
                System.out.println(eventPractical.poll());
                printed++;
            }
        }
    }

}
