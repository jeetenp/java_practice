package org.learning.javapractice.leetcode;

import java.util.Arrays;

public class MaximumSubarray {


    public static void main(String[] args) {
        MaximumSubarray service = new MaximumSubarray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        /*
        System.out.println(service.maxSubArray_mine(nums));
        System.out.println(service.maxSubArray_mine(nums));
        nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(service.maxSubArray_mine(nums));
        */
        System.out.println(service.maxSubArray_1(nums));
    }

    public int maxSubArray_mine(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int[] subarr = Arrays.copyOfRange(nums, i, j);
                int b = Arrays.stream(subarr).sum();
                if (i == 0 && j == 1)
                    sum = b;
                else if (sum < b)
                    sum = b;
            }
        }
        return sum;
    }

    public int maxSubArray_1(int[] nums) {
        int sum = 0;
        int maxSoFar = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > maxSoFar)
                maxSoFar = sum;
            if (sum < 0)
                sum = 0;
        }
        return maxSoFar;
    }
}
