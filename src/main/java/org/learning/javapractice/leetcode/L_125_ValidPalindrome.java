package org.learning.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L_125_ValidPalindrome {

    public static void main(String[] args) {
        L_125_ValidPalindrome service = new L_125_ValidPalindrome();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        System.out.println(String.format("%s = %s", s1, service.isPalindrome(s1)));
        System.out.println(String.format("%s = %s", s2, service.isPalindrome(s2)));
        System.out.println(String.format("%s = %s", s3, service.isPalindrome(s3)));
    }
    public boolean isPalindrome1(String s) {

        return true;
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        List<String> ls = new ArrayList<>();
        int startIndex = 0;
        int endIndex = s.length() - 1;
        String alphaNumeric = "abcdefghijklmnopqrstuvwxyz0123456789";
        while (startIndex < endIndex) {
            String start = String.valueOf(s.charAt(startIndex)).toLowerCase();
            String end = String.valueOf(s.charAt(endIndex)).toLowerCase();

            if(alphaNumeric.indexOf(start) == -1) {
                startIndex++;
            }else if(alphaNumeric.indexOf(end) == -1) {
                endIndex--;
            }else{
                if (!start.equalsIgnoreCase(end)) {
                    return false;
                }
                startIndex++;
                endIndex--;
            }
        }
        return true;
    }
}
