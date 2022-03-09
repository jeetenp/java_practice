package org.learning.javapractice.leetcode;

public class L_008_StringToInteger {
    public static void main(String[] args) {
        L_008_StringToInteger service = new L_008_StringToInteger();
        String s1 = "42";
        String s2 = "-42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        System.out.println(String.format("%s = %s", s1, service.myAtoi(s1)));
        System.out.println(String.format("%s = %s", s2, service.myAtoi(s2)));
        System.out.println(String.format("%s = %s", s3, service.myAtoi(s3)));
        System.out.println(String.format("%s = %s", s4, service.myAtoi(s4)));
        System.out.println(String.format("%s = %s", s5, service.myAtoi(s5)));
    }

    public int myAtoi(String s) {

        if(s == null || s.isEmpty())
            return 0;
        int sign = 1;
        int len = s.length();
        int start = 0;
        s = s.trim();
        if(s.isEmpty())
            return 0;
        Character c1 = s.charAt(0);
        if(c1.equals('+')){
            sign = 1;
            start++;
        }else if(c1.equals('-')){
            sign = -1;
            start++;
        }

        long result = 0;

        for (int i = start; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            try {
                int num = Integer.parseInt(c);
                result = (result * 10)  + num;
                if(result * sign > Integer.MAX_VALUE || result * sign < Integer.MIN_VALUE)
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }catch (NumberFormatException e){
                break;
            }
        }
        result = result * sign;
        return (int) result;
    }
}
