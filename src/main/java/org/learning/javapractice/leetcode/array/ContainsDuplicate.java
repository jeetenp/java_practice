package org.learning.javapractice.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = new int[]{1,1,2};
        System.out.println(containsDuplicate.containsDuplicate_mine(nums));
        System.out.println(containsDuplicate.containsDuplicate_method_1(nums));
    }

    public boolean containsDuplicate_mine(int[] nums) {
        Set set = new HashSet();
        for (int num: nums)
            set.add(num);
        return (nums.length != set.size());
    }

    // best way
    public boolean containsDuplicate_method_1(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num: nums){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
