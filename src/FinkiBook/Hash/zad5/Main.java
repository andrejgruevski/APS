package FinkiBook.Hash.zad5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
//На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
//Ime Prezime budzhet ip_adresa vreme grad cena
//Пример
//Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
//Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.
//
//Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.
//
//Од редот за тестирање треба да го извадите градот и потоа да го одговорите следното прашање со овој град:
//
//Од сите N лица на влез, кои купуваат билет за до истиот град
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
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.trim().split("\\s+");

            String grad = parts[5];

            List<String> list = new ArrayList<>();

            if (!map.containsKey(grad)) {
                map.put(grad, new ArrayList<>());
            } else {
                list = map.get(grad);
            }
            list.add(line);
            map.put(grad, list);
        }
//        System.out.println(map);
        int m = sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] parts = line.trim().split("\\s+");

            String grad = parts[5];

            if (map.containsKey(grad)) {
                String maxLine = "";
                int counter = 0;
                int minSat = Integer.MAX_VALUE;
                int minMinuta = Integer.MAX_VALUE;
                for (String s : map.get(grad)) {
                    String[] p = s.trim().split("\\s+");
                    String vreme = p[4];
                    String[] clock = vreme.split(":");
                    int sat = Integer.parseInt(clock[0]);
                    int min = Integer.parseInt(clock[1]);

                    if (sat >= 12) {
                        counter++;

                        if (sat < minSat || (sat==minSat && min < minMinuta )) {
                            minSat = sat;
                            minMinuta = min;
                            maxLine = s;
                        }
                    }
                }
                String []mx = maxLine.trim().split("\\s+");
                System.out.println("City: "+mx[5]+" has the following number of customers:");
                System.out.println(counter);
                System.out.println("The user who logged on earliest after noon from that city is:");
                System.out.println(mx[0]+" "+mx[1]+" with salary "+mx[2]+" from address "+mx[3]+" who logged in at "+mx[4]);
                System.out.println();
            }

        }
    }

}
