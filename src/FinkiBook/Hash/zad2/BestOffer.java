package FinkiBook.Hash.zad2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//На еден светски познат предавач секоjдневно му пристигнуваат понуди да држи
//предавања. За секоjа понуда се дадени датуми, време на почеток, градот и износот на хонорарот за предавањето (во долари).
// Ваша задача е за даден датум да
//го прикажете предавањето кое би му донело наjголема заработка на предавачот.
//Доколку нема понуди за дадениот датум да се испечати „No offers”.
//Влез: Во првиот ред од влезот е даден броjот на понуди, а во секоj нареден
//ред се дадени: датумот и времето на предавањето (формат dd/mm/yyyyhh:mm),
//градот во коj ´ке се одржува предавањето и износот на хонорарот. Во последниот
//ред е даден датумот за коj треба да испечатите коjа понуда е наjдобра за тоj
//датум.
//        Излез: Деталите на понудата за тоj датум.
//Пример:
//Влез:
//7
//27/01/2016 14:00 NewYork 6000
//28/01/2016 08:00 Paris 3000
//28/01/2016 14:00 Munich 5000
//27/01/2016 09:00 Beijing 8000
//27/01/2016 08:00 Seattle 4000
//28/01/2016 09:00 SaltLakeCity 10000
//28/01/2016 09:00 Lagos 12000
//27/01/2016
//Излез:
//09:00 Beijing 8000
public class BestOffer {

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, String> bestOffer = new HashMap<>();
        Map<String, Integer> bestMoney = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String date = parts[0];
            String time = parts[1];
            String city = parts[2];
            int money = Integer.parseInt(parts[3]);

            if (!bestMoney.containsKey(date) || money > bestMoney.get(date)) {
                bestMoney.put(date, money);
                bestOffer.put(date, time + " " + city + " " + money);
            }
        }
        String key = sc.nextLine();
        if (bestOffer.containsKey(key)) {
            System.out.println(bestOffer.get(key));
        } else {
            System.out.println("No offers");
        }
    }
}
