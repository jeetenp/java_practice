package org.learning.javapractice.leetcode;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray service = new RotateArray();
        int[] nums = new int[]{1, 2, 3};
        int k = 4;

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        service.rotate_1(nums, k);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = 0; j < n - 1; j++)
                nums[n - j - 1] = nums[n - j - 2];
            nums[0] = temp;
        }
    }

    public void reverse(int[] nums, int start, int end) {
        int s = start;
        int e = end;
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    public void rotate_1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
