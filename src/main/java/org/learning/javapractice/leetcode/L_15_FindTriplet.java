package org.learning.javapractice.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L_15_FindTriplet {

    boolean find3Numbers(int a[], int arr_size, int sum)
    {
        int l, r;

        /* Sort the elements */
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(list);

        /* Now fix the first element one by one and find the
           other two elements */
        for (int i = 0; i < arr_size - 2; i++) {

            // To find the other two elements, start two
            // index variables from two corners of the array
            // and move them toward each other
            l = i + 1; // index of the first element in the
            // remaining elements
            r = arr_size - 1; // index of the last element
            while (l < r) {
                if (list.get(i) + list.get(l) + list.get(r) == sum) {
                    System.out.print("Triplet is " + list.get(i) + ", " + list.get(l) + ", " + list.get(r));
                    break;
                }
                else if (list.get(i) + list.get(l) + list.get(r) < sum)
                    l++;

                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
    boolean find3Numbers_my(int a[], int arr_size, int sum) {
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(list);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            int k = j + 1;
            while (k < list.size()
                    && list.get(j) < sum
                    && list.get(k) < sum) {
                if (list.get(i) + list.get(j) + list.get(k) == sum) {
                    System.out.println(list.get(i) + " " + list.get(j) + " " + list.get(k));
                }
                j++;
                k = j + 1;
            }
        }
        return false;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        L_15_FindTriplet triplet = new L_15_FindTriplet();
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        int sum = 6;
        int arr_size = a.length;

        triplet.find3Numbers(a, arr_size, sum);
    }
}
