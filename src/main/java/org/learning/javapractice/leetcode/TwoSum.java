package org.learning.javapractice.leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum service = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        int[] ints = service.twoSum(nums, target);
        System.out.println(ints[0] + " - " + ints[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                start = map.get(diff);
                end = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{start, end};
    }
}
