package Voved_vo_Java;

import java.util.Scanner;

public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        int nonZeroIndex = n - 1;

        int[]result = new int[n];

        for (int i=n-1; i>=0; i--){
            if(arr[i] != 0){
                result[nonZeroIndex] = arr[i];
                nonZeroIndex--;
            }
        }

        for (int i=0; i<n; i++){
            System.out.print(result[i] + " ");
        }

    }

    public static void main (String[] args)
    {
    Scanner input = new Scanner(System.in);
    int n=input.nextInt();

    int[] arr = new int[n];
    for (int i=0; i<n; i++){
        arr[i] = input.nextInt();
    }
        System.out.println("Transformiranata niza e:");
    pushZerosToBeginning(arr, n);
    }
}