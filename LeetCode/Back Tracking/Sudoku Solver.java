//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//Empty cells are indicated by the character '.'.
//
//You may assume that there will be only one unique solution.
//
//
//A sudoku puzzle...
//
//
//...and its solution numbers marked in red.

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null || board.length==0 || board.length!=9 || board[0].length!=9)
            return;
        helper(board, 0, 0);
    }
    boolean helper(char[][] board, int i, int j){
        if(i==9)
            return true;
        if(j==9)
            return helper(board, i+1, 0);
        if(board[i][j]=='.'){
            for(int k=0; k<9; k++){
                char ch = (char) ('1' + k);
                board[i][j] = ch;
                if(isValid(board, i, j)){
                    if(helper(board, i, j+1)){
                        return true;
                    }
                }
                board[i][j] = '.';
            }
        }else{
            return helper(board, i, j+1);
        }
        return false;
    }
    boolean isValid(char[][] board, int i, int j){
        for(int k=0; k<9; k++){
            if(board[k][j]==board[i][j] && k!=i)
                return false;
            if(board[i][k]==board[i][j] && k!=j)
                return false;
        }
        for(int m=(i/3)*3; m<(i/3)*3+3; m++){
            for(int n=(j/3)*3; n<(j/3)*3+3; n++){
                if( (m!=i || n!=j) && board[m][n]==board[i][j] )
                    return false;
            }
        }
        return true;
    }
}