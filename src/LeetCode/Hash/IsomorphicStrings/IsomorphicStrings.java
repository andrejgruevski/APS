package LeetCode.Hash.IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
//Example 1:
//
//Input: s = "egg", t = "add"
//
//Output: true
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (!mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), i);
            }
            if (!mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), i);
            }

            if (!mapS.get(s.charAt(i)).equals(mapT.get(t.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(isIsomorphic(s,t) ? "TRUE" : "FALSE");
    }
}
