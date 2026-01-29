package FinkiBook.Hash.zad4;

import java.util.*;

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
//колку од нив имале доволно буџет за да го купат билетот; и
//од овие, кој од нив платил најголем износ?
//
//(погледнете го тест примерот!)
//
//(доколку има повеќе со ист најголем износ тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
//
//
//Ова ќе треба да го направите за сите M редови за тестирање!
public class Main {
    static void main() {
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

        sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();
        int counter = 0;

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] parts = line.trim().split("\\s+");

            String grad = parts[5];


            if (map.containsKey(grad)) {
                int max = 0;
                String maxCHoek = "";
                counter = 0;
                for (String s : map.get(grad)) {
                    String[] split = s.trim().split("\\s+");
                    int bilet = Integer.parseInt(split[6]);
                    int budzet = Integer.parseInt(split[2]);

                    if ((budzet >= bilet)) {
                        counter++;
                        if (bilet > max) {
                            max = bilet;
                            maxCHoek = s;
                        }
                    }

                }
                String[] split = maxCHoek.trim().split("\\s+");
                System.out.println("City: " + grad + " has the following number of customers:");
                System.out.println(counter);
                System.out.println("The user who spent the most purchasing for that city is:");
                System.out.println(split[0] + " " + split[1] + " with salary " + split[2] + " from address " + split[3] + " who spend " + split[6]);
                System.out.println();

            }

        }

    }
}
