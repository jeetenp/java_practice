package org.learning.javapractice.integers;

public class Factorial {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.getFactorial(8));
    }

    public long getFactorial(int n){
        long result = 1;
        for(int i = 1; i <= n; i++){
            result = result * i;
        }
        return result;
    }
}
