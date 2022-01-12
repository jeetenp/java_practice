package org.learning.javapractice.sudoku;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Sudoku {

    public static void main(String[] args) {
        Sudoku service = new Sudoku();
        Integer[][] game = new Integer[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9}
        };

        Integer[][] game1 = new Integer[][]{
                {5, 3, null, null, 7, null, null, null, null},
                {6, null, null, 1, 9, 5, null, null, null},
                {null, 9, 8, null, null, null, null, 6, null},
                {8, null, null, null, 6, null, null, null, 3},
                {4, null, null, 8, null, 3, null, null, 1},
                {7, null, null, null, 2, null, null, null, 6},
                {null, 6, null, null, null, null, 2, 8, null},
                {null, null, null, 4, 1, 9, null, null, 5},
                {null, null, null, null, 8, null, null, 7, 9}
        };

        service.displaySudoku(game1);
    }

    public void verify(Integer[][] game) {
        Map<Key, Value> emptyCells = new HashMap<>();
        Map<Key, Value> filledCells = new HashMap<>();
    }

    public void displaySudoku(Integer[][] game) {
        System.out.print("  _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                System.out.print((game[i][j] == null ? " " : game[i][j]) + "  ");
                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            if ((i + 1) % 3 == 0) System.out.print("\n  _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.println();
        }
    }
}