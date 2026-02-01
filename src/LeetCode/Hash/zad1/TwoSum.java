package LeetCode.Hash.zad1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Даден е низа од цели броеви nums и цел број target, вратете индекси на двата броја такви што нивниот збир еtarget .
//
//Може да претпоставите дека секој влез би имал точно едно решение и не смеете да го користите истиот елемент двапати.
//
//Можете да го вратите одговорот по кој било редослед.
//
//
//
//Пример 1:
//
//Влез: nums = [2,7,11,15], target = 9
//Излез: [0,1]
//Објаснување: Бидејќи nums[0] + nums[1] == 9, враќаме [0, 1].
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
   public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println((Arrays.toString(twoSum(nums, target))));
    }
}
