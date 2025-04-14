package lab3.zad2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    int time;
    int profit;

    public Task(int time, int profit) {
        this.time = time;
        this.profit = profit;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читање на бројот на задачи
        int n = scanner.nextInt();
        Task[] tasks = new Task[n];

        // Читање на времето и заработката за секоја задача
        for (int i = 0; i < n; i++) {
            int time = scanner.nextInt();
            int profit = scanner.nextInt();
            tasks[i] = new Task(time, profit);
        }

        // Сортирање на задачите според заработката по час во опаѓачки редослед
        Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                double r1 = (double) t1.profit / t1.time;
                double r2 = (double) t2.profit / t2.time;
                return Double.compare(r2, r1);
            }
        });

        int availableHours = 40;
        double maxProfit = 0;

        // Сметање на максималната заработка за 40 часа
        for (Task task : tasks) {
            if (availableHours >= task.time) {
                // Ако имаме доволно време за целата задача, ја додаваме целата заработка
                maxProfit += task.profit;
                availableHours -= task.time;
            } else {
                // Ако немаме доволно време, земаме делумно од задачата
                maxProfit += (double) task.profit * availableHours / task.time;
                break;
            }
        }

        // Печатење на резултатот
        System.out.printf("%.0f\n", maxProfit);

        scanner.close();
    }
}
