class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> output = new ArrayList<>();
        place(0, board, n, output);
        
        return output;
    }
    
    private void place(int row, char[][] board, int n, List<List<String>> output) {
        
        if(row == n) {
            List<String> solution = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            output.add(solution);
            return;
        }
        
        for(int col = 0; col < n; col++) {
            board[row][col] = 'Q';
            boolean isConflicting = checkForConflicts(board, row, col);
            if(!isConflicting) {
                place(row + 1, board, n, output);
            }
            board[row][col] = '.';
        }
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