package array.zad2;

import java.util.Arrays;

class CFG{
    static int getSecondLargest(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        for (int i=n-2; i>=0; i--){
            if(arr[i]!=arr[n-1]){
                return arr[i];
            }
        }
        return -1;
    }
}
public class main {
    public static void main(String[] arr) {
      
    }
}
