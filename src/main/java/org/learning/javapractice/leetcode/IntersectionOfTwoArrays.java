package org.learning.javapractice.leetcode;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        IntersectionOfTwoArrays service = new IntersectionOfTwoArrays();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(service.intersect1(nums1, nums2));
    }


    public int[] intersect1(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;

        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] < nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int len = nums1Length > nums2Length ? nums2Length : nums1Length;

        Map<Integer, List<Integer>> map = convertMap(nums2);
        return process(nums1, map, len);
    }

    public int[] process(int[] nums, Map<Integer, List<Integer>> map, int len) {
        int index = 0;
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                //result[index++] = num;
                result.add(num);
                List<Integer> list = map.get(num);
                list.remove(0);
                if (list.isEmpty())
                    map.remove(num);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public Map<Integer, List<Integer>> convertMap(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            } else {
                map.get(num).add(i);
            }
        }
        return map;
    }

}
