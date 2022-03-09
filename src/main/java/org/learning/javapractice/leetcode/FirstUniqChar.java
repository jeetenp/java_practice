package org.learning.javapractice.leetcode;

import java.util.*;

public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar service = new FirstUniqChar();
        System.out.println(service.firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c);
                map.put(c, map.get(c)+1);
                list.remove(c);
            }else{
                map.put(c, 1);
                list.add(c);
            }
        }
        return list.size() > 0 ? s.indexOf(list.get(0)) : -1;
    }

}
