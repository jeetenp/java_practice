package org.learning.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MiniMaxSum {

    public String miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        Integer min = 0;
        Integer max = 0;
        int[] m = new int[arr.size()];
        for(int i = 0; i<  arr.size(); i++){
            m[i] = arr.get(i);
        }
        Arrays.sort(m);
        long x=0;
        long y=0;
        for(int i=0;i<4;i++){
            x+=m[i];
        }
        for(int i=1;i<5;i++){
            y+=m[i];
        }
        System.out.println(x+" "+y);
        return (x+" "+y);
    }

}


