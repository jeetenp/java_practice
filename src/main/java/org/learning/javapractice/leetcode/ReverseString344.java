package org.learning.javapractice.leetcode;

public class ReverseString344 {

    public static void main(String[] args) {
        ReverseString344 service = new ReverseString344();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        service.reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = t;
        }
    }
}
