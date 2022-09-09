package org.learning.hackerrank;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        double pCount = 0;
        double nCount = 0;
        double oCount = 0;
        for (Integer i : arr) {
            if (i > 0 ){
                pCount++;
            }else if (i < 0 ){
                nCount++;
            }else {
                oCount++;
            }
        }

        DecimalFormat df= new DecimalFormat("#.000000");
        System.out.println(df.format(pCount/arr.size()));
        System.out.println(df.format(nCount/arr.size()));
        System.out.println(df.format(oCount/arr.size()));

    }

}