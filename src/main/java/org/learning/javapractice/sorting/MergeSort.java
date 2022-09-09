package org.learning.javapractice.sorting;

import java.util.Arrays;

public class MergeSort extends AbstractSort {

    public void sort(int[] a) {

        if(a.length < 2){
            return;
        }
        int mid = a.length / 2;
        int[] leftArray = Arrays.copyOfRange(a, 0, mid);
        int[] rightArray = Arrays.copyOfRange(a, mid, a.length);
        sort(leftArray);
        sort(rightArray);
        merge(leftArray, rightArray, a);
    }
    public void merge(int[] left, int[] right, int[] full){
        int i  = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                full[k++] = left[i++];
            }else{
                full[k++] = right[j++];
            }
        }
        while (i < left.length){
            full[k++] = left[i++];
        }
        while (j < right.length){
            full[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort object = new MergeSort();
        int a[] = {7, 6, 5, 4, 3, 2, 1, 0};
        object.sort(a);
        object.display(a);
    }
}
