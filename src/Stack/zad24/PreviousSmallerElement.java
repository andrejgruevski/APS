package Stack.zad24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//Given an array arr[], find the Previous Smaller Element (PSE) for every element in the array.
//
//The Previous Smaller Element of an element x is defined as the first element to its left in the array that is smaller than x.
//If no such element exists for a particular position, the PSE should be considered as -1.
public class PreviousSmallerElement {
    public static ArrayList<Integer> prevSmaller(int arr[]){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            list.add(-1);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                list.set(i, stack.peek());
            }
            stack.push(arr[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(prevSmaller(arr));
    }
}
