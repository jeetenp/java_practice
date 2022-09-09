package org.learning.javapractice.sorting;

public class SelectionSort extends  AbstractSort {

    public void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if(a[min] > a[j])
                    min = j;
            }
            swap(a, min, i);
        }
    }

    public static void main(String[] args) {
        SelectionSort object = new SelectionSort();
        int a[] = {7, 6, 5, 4, 3, 2, 1};
        object.sort(a);
        object.display(a);
    }
}
