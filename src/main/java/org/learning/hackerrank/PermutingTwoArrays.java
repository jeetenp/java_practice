package org.learning.hackerrank;

import java.util.Collections;
import java.util.List;

public class PermutingTwoArrays {
    public String twoArrays(int k, List<Integer> A, List<Integer> B) {
        String result = "YES";
        Collections.sort(A);
        Collections.sort(B);
        for (int i = 0, j = A.size()-1; i < A.size(); i++, j--) {
            if((A.get(i) + B.get(j)) < k){
                result = "NO";
                break;
            }
        }
        return result;
    }
}
