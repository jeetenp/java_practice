package org.learning.programs;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeArrays {

    public int[] merge_1(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                result[i++] = arr1[p1];
                p1++;
            } else {
                result[i++] = arr1[p2];
                p2++;
            }
        }
        if (p1 < arr1.length) {
            for (int j = p1; j < arr1.length; j++) {
                result[i++] = arr1[j];
            }
        } else {
            for (int j = p2; j < arr2.length; j++) {
                result[i++] = arr2[j];
            }
        }
        return result;
    }

    public Integer[] merge_2(int[] arr1, int[] arr2) {
        Map<Integer,Boolean> mp = new TreeMap<Integer,Boolean>();
        for(int i = 0; i < arr1.length; i++)
        {
            mp.put(arr1[i], true);
        }
        for(int i = 0;i < arr2.length;i++)
        {
            mp.put(arr2[i], true);
        }
        return mp.keySet().toArray(new Integer[0]);
    }

    public Integer[] merge_3(int[] arr1, int[] arr2) {
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < arr1.length; i++)
        {
            set.add(arr1[i]);
        }
        for(int i = 0;i < arr2.length;i++)
        {
            set.add(arr2[i]);
        }
        return set.toArray(new Integer[]{});
    }

    public int[] merge_4(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        Arrays.sort(result);
        return result;
    }

    public int[] merge_5(int[] array1, int[] array2) {
        //Integer[] result = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Integer[]::new);
        int[] result = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray();
        return result;
    }

    public static void main(String[] args) {
        MergeArrays object = new MergeArrays();
        int[] arr1 = new int[]{1, 2, 3, 4, 9, 1};
        int[] arr2 = new int[]{5, 6, 7, 8};
        int[] a = object.merge_4(arr1, arr2);
        for(int i = 0;i < a.length;i++)
        {
            System.out.println(a[i]);
        }
    }

}
