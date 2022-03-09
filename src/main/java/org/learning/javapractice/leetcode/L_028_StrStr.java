package org.learning.javapractice.leetcode;

public class L_028_StrStr {
    public static void main(String[] args) {
        L_028_StrStr service = new L_028_StrStr();
        String haystack = "hello", needle = "ll";
        //String haystack = "aaaaa", needle = "bba";
        //String haystack = "", needle = "";
        System.out.println(String.format("%s", service.strStr(haystack, needle)));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0) {
            return 0;
        }
        if (needle.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if(i+needle.length() > haystack.length())
                return -1;
            if(haystack.substring(i, needle.length()+i).equalsIgnoreCase(needle))
                return i;
        }
        return -1;
    }
}
