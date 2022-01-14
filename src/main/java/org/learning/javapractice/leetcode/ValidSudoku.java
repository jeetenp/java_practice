package org.learning.javapractice.leetcode;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution service = new Solution();
        char[][] nums = new char[][]
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        System.out.println(service.isValidSudoku(nums));
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean check = true;
        for (int i = 0; i < 9 && check; i++) {
            for (int j = 0; j < 9 && check; j++) {
                if (board[i][j] != '.') {
                    check = isValid(board, i, j);
                    if (!check) break;
                }
            }
            if (!check) break;
        }
        return check;
    }

    public boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[row][col] != '.' && i != col && board[row][col] == board[row][i]) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[row][col] != '.' && i != row && board[row][col] == board[i][col]) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startCol; j < startCol+3; j++) {
                if (board[row][col] != '.' && board[row][col] == board[i][j] && ( row != i && col != j )) {
                    return false;
                }
            }
        }
        return true;
    }
}
