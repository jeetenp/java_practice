package org.learning.javapractice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber service = new SingleNumber();
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(service.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.size() > 0 ? set.iterator().next() : 0;
    }

    public int singleNumber1(int[] nums) {
        int result = 0;
        for(int num: nums) {
            System.out.println("");
            result ^= num;
        }
        return result;
    }
}
