class Solution {
    
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return place(0, board, n);
    }
    
    private int place(int row, char[][] board, int n) {
        
        if(row == n) {
            return 1;
        }
        
        int count = 0;
        for(int col = 0; col < n; col++) {
            board[row][col] = 'Q';
            boolean isConflicting = checkForConflicts(board, row, col);
            if(!isConflicting) {
                count += place(row + 1, board, n);
            }
            board[row][col] = '.';
        }
        return count;
    }
    
    private boolean checkForConflicts(char[][] board, int row, int col) {
        
        int n = board.length;
        boolean isConflicting = false;
        
        //check for row conflicts
        for(int i = 0; i < n; i++) {
            if(i == col)
                continue;
            if(board[row][i] == 'Q') {
                isConflicting = true;
                break;
            }
        }
        
        if(isConflicting)
            return isConflicting;
        
        //check for column conflicts
        for(int i = 0; i < n; i++) {
            if(i == row)
                continue;
            if(board[i][col] == 'Q') {
                isConflicting = true;
                break;
            }
        }
        
        if(isConflicting)
            return isConflicting;
        
        return checkDiagonalConflicts(board, row, col);
    }
    
    private boolean checkDiagonalConflicts(char[][] board, int row, int col) {
        
        int n = board.length;
        
        //LEFT UP Diagonal
        int i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 'Q') {
                return true;   
            }
            i--;
            j--;
        }
        
        
        //LEFT DOWN Diagonal
        i = row + 1;
        j = col - 1;
        while(i < n && j >= 0) {
            if(board[i][j] == 'Q') {
                return true;   
            }
            i++;
            j--;
        }
        
        //RIGHT UP Diagonal
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < n) {
            if(board[i][j] == 'Q') {
                return true;   
            }
            i--;
            j++;
        }
        
        //RIGHT DOWN Diagonal
        i = row + 1;
        j = col + 1;
        while(i < n && j < n) {
            if(board[i][j] == 'Q') {
                return true;   
            }
            i++;
            j++;
        }
        
        return false;
    }
}