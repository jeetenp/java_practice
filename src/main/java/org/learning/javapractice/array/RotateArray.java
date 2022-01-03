package org.learning.javapractice.array;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int nums2[] = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
        rotateArray.leftRotate(nums, 2);
        rotateArray.rightRotate(nums2, 2);
    }

    void leftRotate(int nums[], int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++){
            int temp = nums[0];
            for (int j = 0; j < n - 1; j++)
                nums[j] = nums[j+1];
            nums[n-1] = temp;
        }
        System.out.print("Left Rotate : ");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }

    void rightRotate(int nums[], int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++){
            int temp = nums[n - 1];
            for (int j = 0; j < n - 1; j++)
                nums[n - j - 1] = nums[n - j - 2];
            nums[0] = temp;
        }
        System.out.print("Right Rotate : ");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }
}
