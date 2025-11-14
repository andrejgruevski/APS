package DLL.zad47;

import java.util.Scanner;

import static java.lang.Integer.*;

public class Bus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int maxium = 0;
        int minium = 0;

        if (m == 0 ){
            minium = n;
            maxium = n;
        }else{
            minium = Math.max(n,m);
            maxium = n + m -1;
        }

        System.out.println(minium*100);
        System.out.println(maxium*100);
    }
}
