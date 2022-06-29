class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        
        List<Integer> prevRow = Arrays.asList(1);
        if(rowIndex == 0)
            return prevRow;
        
        List<Integer> row = null;
        for(int i = 1; i <= rowIndex; i++) {
            
            row = new ArrayList<>();
            row.add(1);
            for(int j = 0; j < prevRow.size() - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);
            prevRow = row;
        }
        return row;
    }
}