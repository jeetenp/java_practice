package org.learning.hackerrank;

import java.util.List;

public class SubarrayDivision1 {
    public int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        for (int i = 0; i < s.size() && (i+m) <= s.size(); i++) {
            int toIndex = i+m;
            int subSetSum = s.subList(i, toIndex).stream().mapToInt(Integer::valueOf).sum();
            if(subSetSum == d){
                count++;
            }
        }
        return count;
    }
}
