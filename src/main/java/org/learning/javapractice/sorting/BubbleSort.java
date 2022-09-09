package org.learning.javapractice.sorting;

public class BubbleSort extends  AbstractSort {

    public void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++){
                if(a[i] > a[j])
                    swap(a, i, j);
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort object = new BubbleSort();
        int a[] = {7, 6, 5, 4, 3, 2, 1};
        object.sort(a);
        object.display(a);
    }
}
