package org.learning.javapractice.sorting;

public class InsertionSort extends AbstractSort {

    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int emptyPos = i;

            while (emptyPos > 0 && a[emptyPos - 1] > value) {
                a[emptyPos] = a[emptyPos - 1];
                emptyPos = emptyPos - 1;
            }
            a[emptyPos] = value;
        }
    }

    public static void main(String[] args) {
        InsertionSort object = new InsertionSort();
        int a[] = {7, 6, 5, 4, 3, 2, 1};
        object.sort(a);
        object.display(a);
    }
}
