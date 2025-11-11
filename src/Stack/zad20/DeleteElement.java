package Stack.zad20;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DeleteElement {
    public static ArrayList<Integer> deleteElement(int arr[], int k){
        Stack<Integer> stack = new Stack<>();
        int counter = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++){

            while (!stack.isEmpty() && stack.peek() < arr[i] && counter < k){
                stack.pop();
                counter++;
            }
            stack.push(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        ArrayList<Integer> list = deleteElement(arr,k);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
