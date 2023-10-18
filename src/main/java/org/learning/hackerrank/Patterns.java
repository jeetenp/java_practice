package org.learning.hackerrank;

public class Patterns {


    /*

     *****
     *****
     *****
     *****
     *****

     */
    public void pattern_1(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     *
     **
     ***
     ****
     *****
     */
    public void pattern_2(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
     */
    public void pattern_3(int size) {
        for (int i = 0; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /*
        1
        22
        333
        4444
        55555
     */
    public void pattern_4(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
    }

    /*

     *****
     ****
     ***
     **
     *

     */
    public void pattern_5(int size) {
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*

        12345
        1234
        123
        12
        1

     */
    public void pattern_6(int size) {
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    /*

         *
        ***
       *****
      *******
     *********

     */
    public void pattern_7(int size) {
        int star = 1;
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            star = star + 2;
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void pattern_8(int size) {
        int star = size;
        int space = 0;
        for (int i = 0; i > 0; i--) {
            for (int j = 0; j < star; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            star = star + 2;
            for (int j = 0; j < i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Patterns patterns = new Patterns();

        //patterns.pattern_1(5);
        //patterns.pattern_2(5);
        //patterns.pattern_3(5);
        //patterns.pattern_4(5);
        //patterns.pattern_5(5);
        //patterns.pattern_6(5);
        //patterns.pattern_7(5);
        patterns.pattern_8(5);
    }
}
