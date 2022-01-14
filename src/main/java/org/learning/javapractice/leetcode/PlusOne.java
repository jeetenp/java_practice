package org.learning.javapractice.leetcode;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne service = new PlusOne();
        int[] nums = new int[]{0};
        int[] ints = service.plusOne(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                if(i == 0 && digits[i] == 9){
                    digits[i] = digits[i] + carry;
                }else{
                    digits[i] = digits[i] + 1;
                }
                carry = 0;
                break;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }
        if(carry == 1){
            int[] a = new int[digits.length+1];
            a[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                a[i+1] = digits[i];
            }
            digits = a;
        }
        return digits;
    }
}
