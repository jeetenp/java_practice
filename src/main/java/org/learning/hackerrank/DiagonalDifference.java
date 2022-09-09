package org.learning.hackerrank;

import java.util.List;

public class DiagonalDifference {

    /**
     *      0   1   2
     *   0  11  2   4
     *   1  4   5   6
     *   2  10  8   -12
     * @param arr
     * @return
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int ltr = 0;
        int rtl = 0;
        int ltrIndex = 0;
        int rtlIndex = arr.size() - 1;
        for (int i = 0; i < arr.size(); i++) {
            ltr = ltr + arr.get(i).get(ltrIndex++);
            rtl = rtl + arr.get(i).get(rtlIndex--);
        }
        return Math.abs(ltr - rtl);
    }
}
