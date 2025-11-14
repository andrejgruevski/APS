package DLL.zad48;
import java.util.*;
public class LongestIncreasingSubsequence {

    public static int najdolgaOpagackaSekvenca(int[]a){
        int n = a.length;
        if (n == 0) return 0;

        int []dp = new int[n];

        Arrays.fill(dp,1);
        int max = 1;

        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <i ; j++) {
                if (a[j] > a[i] && dp[j] +1 > dp[i]) {
                    dp[i] = dp[j] +1;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
