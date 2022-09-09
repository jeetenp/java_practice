package org.learning.programs;

import java.util.*;

public class TwoSum {

    public int[] solution(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numToFind = target - nums[i];
            if (map.containsKey(numToFind)) {
                return new int[]{map.get(numToFind), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
