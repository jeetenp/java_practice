package org.learning.javapractice.integers;

public class Power {

    public static void main(String[] args) {
        Power service = new Power();
        System.out.println(service.getPower1(19, 100));
        System.out.println(service.getPower(19, 100));
    }

    public double getPower1(double x, int n) {
        double ans = 1;
        for(int i = 0; i < n; i++) {
            ans = ans * x;
            System.out.println("Loop counter " + i);
        }
        return ans;
    }

    public double getPower(double x, int n) {
        double ans = 1.0;
        long num = n;
        int i = 0;
        if (n < 0) {
            num = -1 * num;
        }
        while (num > 0) {
            if (num % 2 == 0) {
                x = x * x;
                num = num / 2;
            } else {
                ans = ans * x;
                num = num - 1;
            }
            System.out.println("Loop counter " + i++);
        }
        if (n < 0) {
            return (double) (1.0) / (double) (ans);
        }
        return ans;
    }
}
