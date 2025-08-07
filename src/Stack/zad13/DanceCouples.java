package Stack.zad13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DanceCouples {

    public static String secondPartner(String str){
        if (str.equals("LM"))return "LZ";
        else if (str.equals("LZ"))return "LM";
        else if (str.equals("OM"))return "OZ";
        else if (str.equals("OZ"))return "OM";
        else if (str.equals("SM"))return "SZ";
        else if (str.equals("SZ"))return "SM";
        else return "";
    }

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] tokens = input.split(" ");

        Stack<String> O = new Stack<>(); // basic
        Stack<String> S = new Stack<>(); // standard
        Stack<String> L = new Stack<>(); // latino

        for(String token : tokens){
            if (token.charAt(0) == 'O'){
                if (O.isEmpty()) O.push(token);
                else if (!O.peek().equals(token)) O.pop();
                else O.push(token);
            } else if (token.charAt(0) == 'S'){
                if (S.isEmpty()) S.push(token);
                else if (!S.peek().equals(token)) S.pop();
                else S.push(token);
            }else if (token.charAt(0) == 'L'){
                if (L.isEmpty()) L.push(token);
                else if (!L.peek().equals(token)) L.pop();
                else L.push(token);
            }
        }
        System.out.println(O.size() + S.size() + L.size());
        for(String token : O) System.out.println(secondPartner(token) + " ");
        for(String token : S) System.out.println(secondPartner(token) + " ");
        for(String token : L) System.out.println(secondPartner(token) + " ");



    }
}
