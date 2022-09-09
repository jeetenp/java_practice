package org.learning.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {
    public int lonelyinteger(List<Integer> a) {
        if(a.size() == 1){
            return a.get(0);
        }
        Map<Integer, Integer> map = new HashMap();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> uniqueNumbers = new ArrayList<>();
        for(Integer i: a){
            if(uniqueNumbers.contains(i)){
                numbers.add(i);
                uniqueNumbers.remove(i);
            }else{
                uniqueNumbers.add(i);
            }
        }
        return uniqueNumbers.get(0);
    }
}
