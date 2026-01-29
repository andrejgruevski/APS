package FinkiBook.Hash.zad3;

import java.util.*;

public class Epidemic {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String opshtina = parts[0];
            String prezime = parts[1];
            String status = parts[2];

            List<String> list = new ArrayList<>();
            String concat = prezime + " " + status;
            if (!map.containsKey(opshtina)) {
                map.put(opshtina, new ArrayList<>());
            } else {
                list = map.get(opshtina);
            }
            list.add(concat);
            map.put(opshtina, list);

        }
        String key = sc.nextLine();
        int pozitiivni = 0;
        int negativni = 0;
        if (map.containsKey(key)) {
            for (String s : map.get(key)) {
                String[] parts = s.split(" ");
                if (parts[1].equals("negative")) {
                    negativni++;
                } else {
                    pozitiivni++;
                }
            }
        }
        System.out.println(pozitiivni + " " + negativni);
        double result = (double) pozitiivni / (negativni + pozitiivni);
        System.out.println(result);
    }
}
