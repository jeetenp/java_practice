package org.learning.programs;

public class FirstUniqueCharacter {

    public int firstUniqueCharacter(String value){
        for (int i = 0; i < value.length(); i++) {
            char character = value.charAt(i);
            if(value.indexOf(character) == value.lastIndexOf(character))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter service = new FirstUniqueCharacter();
        System.out.println(service.firstUniqueCharacter("leetcode"));
        System.out.println(service.firstUniqueCharacter("loveleetcode"));
        System.out.println(service.firstUniqueCharacter("aabb"));
    }
}
