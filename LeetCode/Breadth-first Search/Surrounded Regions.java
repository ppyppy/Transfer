//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//For example,
//X X X X
//X O O X
//X X O X
//X O X X
//After running your function, the board should be:
//
//X X X X
//X X X X
//X X X X
//X O X X

public class Solution {
    private LinkedList<Integer> queue = null;
    public void solve(char[][] board) {
        if(board==null || board.length==0)
            return;
        int m = board.length;
        int n = board[0].length;
        queue = new LinkedList<Integer>();
        for(int i=0; i<n; i++){
            BFS(0, i, board);
            BFS(m-1, i, board);
        }
        for(int i=0; i<m; i++){
            BFS(i, 0, board);
            BFS(i, n-1, board);
        }
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                else if(board[i][j]=='A')
                    board[i][j] = 'O';
            }
    }
    private void fill(int i, int j, char[][] board) {
         int row = board.length;
         int col = board[0].length;
         if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
             return;
         queue.addFirst( i*col+j );
         board[i][j] = 'A';
    }
    private void BFS(int i, int j, char[][] board){
        int col = board[0].length;
        fill(i, j, board);
        while(!queue.isEmpty()){
            Integer value = queue.removeLast();
            int x = value/col;
            int y = value%col;
            fill(x-1, y, board);
            fill(x+1, y, board);
            fill(x, y-1, board);    
            fill(x, y+1, board);
        }
    }
}
