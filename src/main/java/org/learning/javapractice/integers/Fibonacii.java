package org.learning.javapractice.integers;

public class Fibonacii {
    public static void main(String[] args) {
        Fibonacii fibonacii = new Fibonacii();
        System.out.println(fibonacii.solution1(8));
    }
    // 0 1 2 3 4 5 6 07 08 09 10 11
    // 0 1 1 2 3 5 8 13 21 34 55 89
    public long solution1(int n) {
        int firstNum = 0;
        int secondNum = 1;
        if (n == 0 ) return 0;
        if (n == 1 ) return 1;
        for (int i = 2; i <= n; i++) {
            int temp = secondNum;
            secondNum = firstNum + secondNum;
            firstNum = temp;
        }
        return secondNum;
    }

    public long solution2(int n) {
        if (n == 0 ) return 0;
        if (n == 1 ) return 1;
        return 1;
    }
}
