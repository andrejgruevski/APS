package FinkiBook.Hash.zad6;

import java.util.*;
//На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
//Ime Prezime budzhet ip_adresa vreme grad cena
//Пример
//Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
//Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.
//
//Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.
//
//Од редот за тестирање треба да ја извадите IP адресата на мрежата и потоа да го одговорите следното прашање со оваа мрежа:
//
//Од сите N лица на влез, кои што се поврзуваат со истата мрежа (од било кој домаќин во мрежата)
//колку од нив се вклучиле подоцна од 11:59; и
//од овие, кој од нив се вклучил најрано?
//
//(погледнете го тест примерот!)
//
//(доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
//
//
//Ова ќе треба да го направите за сите M редови за тестирање!
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<>();

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.trim().split("\\s+");
            String ip = parts[3];
            String net[] = ip.split("\\.");
            String network = net[0] + "." + net[1] + "." + net[2];
            List<String> list = new ArrayList<>();
            if (!map.containsKey(network)) {
                map.put(network, new ArrayList<>());
            } else {
                list = map.get(network);
            }
            list.add(line);
            map.put(network, list);
        }
//       System.out.println(map);

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] token = line.trim().split("\\s+");
            String ip = token[3];
            String net[] = ip.split("\\.");
            String network = net[0] + "." + net[1] + "." + net[2];

            int minHour = Integer.MAX_VALUE;
            int minMinute = Integer.MAX_VALUE;

            if (map.containsKey(network)) {
                String answer = "";
                int counter = 0;
                for (String s : map.get(network)) {
                    String[] parts = s.trim().split("\\s+");
                    String vreme = parts[4];
                    String[] clock = vreme.split(":");
                    int hour = Integer.parseInt(clock[0]);
                    int minute = Integer.parseInt(clock[1]);


                    if (hour >= 12) {
                        counter++;

                        if (hour < minHour || (hour == minHour && minute < minMinute)) {
                            minHour = hour;
                            minMinute = minute;
                            answer = s;
                        }
                    }
                }
                System.out.println("IP network: " + network + " has the following number of users:");
                System.out.println(counter);
                System.out.println("The user who logged on earliest after noon from that network is:");
                String[] a = answer.trim().split("\\s+");
                System.out.println(a[0] + " " + a[1] + " with salary " + a[2] + " from address " + a[3] + " who logged in at " + a[4]);
                System.out.println();
            }
        }

    }
}
