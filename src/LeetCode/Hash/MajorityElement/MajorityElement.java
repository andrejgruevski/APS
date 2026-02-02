package LeetCode.Hash.MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//
//
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2
public class MajorityElement {
    public static int majoEl(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0, majority = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1 + map.getOrDefault(nums[i], 0));
            if (map.get(nums[i]) > majority) {
                majority = map.get(nums[i]);
                result = nums[i];
            }

        }
        return result;
//        Arrays.sort(nums);
//        return nums[nums.length/2];
    }

    static void main() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(majoEl(nums));
    }
}
