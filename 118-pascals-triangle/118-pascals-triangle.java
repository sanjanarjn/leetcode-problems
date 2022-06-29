class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascals = new ArrayList<>();
        
        List<Integer> prevRow = Arrays.asList(1);
        pascals.add(prevRow);
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 0; j < prevRow.size() - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);
            pascals.add(row);
        
            prevRow = row;
        }
        return pascals;
    }
}