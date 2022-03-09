package org.learning.javapractice.leetcode;

public class RotateImage {

    public static void main(String[] args) {
        int[][] a1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] a2 = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        RotateImage solution = new RotateImage();
        solution.rotate(a1);
        solution.show(a1);
        System.out.println();
        solution.rotate(a2);
        solution.show(a2);
    }
    public void show(int[][] matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int size = matrix[0].length;
        int count = size / 2;
        for (int i = 0; i < count; i++) {
            rotateLayer(matrix, i,i, size-i);

        }

    }

    public void rotateLayer(int[][] matrix, int startRow, int startCol, int len) {
        for (int i = startCol; i < len - 1; i++) {
            int nextStartRow = startRow;
            int nextStartCol = i;

            int temp = matrix[startRow][i];
            for (int j = 0; j < 4; j++) {
                int t = nextStartRow;
                nextStartRow = nextStartCol;
                nextStartCol = matrix[0].length - 1 - t;
                int a = matrix[nextStartRow][nextStartCol];
                matrix[nextStartRow][nextStartCol] = temp;
                temp = a;
            }

        }
    }

    /* if len = 3
    loop of layer 1 : sr=0, sc=0, len - 1
    one cycle of 4 steps:
    0,2 save
    0,0 - 0,2 #
    2,2 save
    0,2 - 2,2 #
    2,0 save
    2,2 - 2,0 #
    2,0 - 0,0 #   cycle complete

    1,2 save
#   0,1 - 1,2
    2,1 save
    1,2 - 2,1
    1,0 save
    2,1 - 1,0
    1,0 - 0,1   cycle complete
     */

}
