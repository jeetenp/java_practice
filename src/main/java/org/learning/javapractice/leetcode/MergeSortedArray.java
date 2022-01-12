package org.learning.javapractice.leetcode;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray service = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        service.merge(nums1, 3, nums2, 3);
        System.out.println("");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int resultIndex = 0;
        int nums1Index = 0;
        int nums2Index = 0;
        for (int i = 0; i < m + n; i++) {
            if (nums1Index < m) {
                if (nums1[nums1Index] <= nums2[nums2Index]) {
                    result[resultIndex++] = nums1[nums1Index++];
                } else if (nums1[nums1Index] > nums2[nums2Index]) {
                    result[resultIndex++] = nums2[nums2Index++];
                }
            } else {
                result[resultIndex++] = nums2[nums2Index++];
            }
        }
        nums1 = result;
    }
}
