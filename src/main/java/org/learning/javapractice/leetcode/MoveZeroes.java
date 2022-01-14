package org.learning.javapractice.leetcode;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes service = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        service.moveZeroes(nums);
        service.show(nums);
    }

    //0, 1, 0, 3, 12
    //1, 0, 0, 3, 12
    //1, 3, 12, 0, 0

    public void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        int currentIndex = 0;
        int nextIndex = 1;
        while (currentIndex < nums.length && nextIndex < nums.length) {
            if (nums[currentIndex] == 0 && nums[nextIndex] != 0) {
                int temp = nums[currentIndex];
                nums[currentIndex] = nums[nextIndex];
                nums[nextIndex] = temp;
                currentIndex++;
                nextIndex = currentIndex + 1;
            } else if (nums[currentIndex] != 0 && nums[nextIndex] == 0) {
                currentIndex++;
                nextIndex = currentIndex + 1;
            } else {
                nextIndex++;
            }
        }
    }

    public void moveZeroesWithExtraSpace(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                res[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
