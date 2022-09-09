package org.learning.javapractice.collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Basic {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("1", "1");
        map.put("1", "1");
        map.put(null, null);
        map.put("2", "2");

        System.out.println(map.get("1"));

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() +  " : " + entry.getValue());
        }

    }


}
