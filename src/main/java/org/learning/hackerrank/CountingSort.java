package org.learning.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
    public List<Integer> countingSort(List<Integer> arr) {
        List<Integer> lstResult = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            lstResult.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            int index = arr.get(i);
            lstResult.set(index, lstResult.get(index) + 1);
        }
        return lstResult;
    }


}
