class Solution {
    
    char[][] rotated;
    
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        
        this.rotated = new char[n][m];
        
        for(int i = 0; i < m; i++) {
            rotateRow(m - i - 1, box[i]);
        }
        return rotated;
    }
    
    private void rotateRow(int rotatedCol, char[] row) {
        
        int n = row.length;
        
        int col = rotatedCol;
        int i = n - 1;
        int j = n - 1;
        
        while(i >= 0 && j >= 0) {
            if(row[i] == '.') {
                i--;
                continue;
            }
            else if(row[i] == '*') {
                while(j > i) {
                    rotated[j--][col] = '.';
                }
                rotated[j--][col] = '*';
                i--;
            }
            else {
                rotated[j--][col] = row[i--];
            }
        }
        while(j >= 0) {
            rotated[j--][col] = '.';
        }
    }
}