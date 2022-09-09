package org.learning.programs;

public class ReverseString {

    public String reverse_1(String value){
        String result = "";
        for (int i = value.length()-1; i >=0; i--) {
            result = result + value.charAt(i);
        }
        return result;
    }

    public String reverse_2(String value){
        StringBuilder sb = new StringBuilder(value);
        sb.reverse();
        StringBuffer sb1 = new StringBuffer(value);
        sb1.reverse();
        return sb.toString();
    }

    public String reverse_3(String value){
        char[] chars = value.toCharArray();
        String result = "";
        for (int i = chars.length - 1; i >=0; i--) {
            result = result + value.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseString object = new ReverseString();
        System.out.println(object.reverse_1("Jeeten"));
        System.out.println(object.reverse_2("Jeeten"));
        System.out.println(object.reverse_3("Jeeten"));
    }


}
