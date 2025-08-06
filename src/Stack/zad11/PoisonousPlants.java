package Stack.zad11;

//Во една градина имаа одреден броj на растениjа. Секое од растениjата е третирано со одредена количина на пестициди. После секоj ден, ако некое растение има
//пове´ке пестициди од растението што е лево од него (односно е послабо), истото
//умира.
//Со дадени инициjални вредности за количината на пестициди во секое растение, треба да се одреди после коj ден по ред (броjот на денот) нема ве´ке да
//умира ни едно растение, односно после коj ден нема да има растениjа кои имаат
//пове´ке пестициди од тие што се до нив од лева страна.
//Влез: Во влезот во првиот ред е даден броjот на растениjа, а потоа за секое
//растение е дадена количината на пестициди.
//Излез: На излез треба да се испечати броjот на денот по коj ве´ке нема да
//умира ни едно растение.

import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] plants =  new int[n];

        for (int i = 0; i < n; i++) {
            plants[i] = sc.nextInt();
        }
        Stack<int[]> stack = new Stack<>();
        int days = 0;
        for (int i = 0; i<n; i++){
            int count = 0;

            while (!stack.isEmpty() && plants[i]<=stack.peek()[0]){
                count=Math.max(count,stack.peek()[1]);
                stack.pop();
            }
            if (stack.isEmpty()){
                count=0;
            }else{
                count+=1;
            }
            days = Math.max(days,count);
            stack.push(new int[]{plants[i],count});
        }
        System.out.println(days);
    }
}
