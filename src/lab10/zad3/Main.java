package lab10.zad3;

import java.util.*;

public class Main {
    static class Task {
        String name;
        int duration;

        public Task(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, Task> tasks = new HashMap<>();
        Map<String, List<String>> dependencies = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String[] taskInfo = scanner.nextLine().split(" ");
            String taskName = taskInfo[0];
            int duration = Integer.parseInt(taskInfo[1]);
            tasks.put(taskName, new Task(taskName, duration));
            dependencies.put(taskName, new ArrayList<>());
            inDegree.put(taskName, 0);
        }


        int m = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < m; i++) {
            String[] dependency = scanner.nextLine().split(" ");
            String dependent = dependency[0];
            String prerequisite = dependency[1];

            dependencies.get(prerequisite).add(dependent);
            inDegree.put(dependent, inDegree.get(dependent) + 1);
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> earliestCompletion = new HashMap<>();


        for (String task : inDegree.keySet()) {
            if (inDegree.get(task) == 0) {
                queue.add(task);
                earliestCompletion.put(task, tasks.get(task).duration);
            }
        }

        int totalTime = 0;

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentCompletionTime = earliestCompletion.get(current);

            for (String dependent : dependencies.get(current)) {
                inDegree.put(dependent, inDegree.get(dependent) - 1);
                if (inDegree.get(dependent) == 0) {
                    queue.add(dependent);
                }


                earliestCompletion.put(dependent, Math.max(earliestCompletion.getOrDefault(dependent, 0),
                        currentCompletionTime + tasks.get(dependent).duration));
            }

            totalTime = Math.max(totalTime, currentCompletionTime);
        }



        System.out.println(totalTime);
    }
}

