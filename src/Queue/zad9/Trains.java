package Queue.zad9;

import java.util.*;

public class Trains {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> wagons = new ArrayList<>();
        Stack<Integer> oldTrain = new Stack<>();

        for (int i = 0; i < N; i++) wagons.add(sc.nextInt());
        for (int i =0; i<wagons.size(); i++){
            if (wagons.get(i) > 0) oldTrain.push(wagons.get(i));
            else{
                wagons.remove(i);
                i--;
            }
        }
        Collections.sort(wagons);
        Queue<Integer> tmp = new LinkedList<>();
        LinkedList<Integer> newTrain = new LinkedList<>();

        while (!oldTrain.isEmpty()){
            tmp.offer(oldTrain.pop());
        }
        int i = 0;
        while (!tmp.isEmpty()){
            int wagon = tmp.poll();
            if (wagon == wagons.get(i)){
                newTrain.add(wagon);
                i++;
            }else tmp.offer(wagon);
        }
        System.out.println(newTrain);
    }
}
