class Solution {
    
    public List<List<Integer>> combine(int n, int k) { 
        return combine(1, 0, n, k);
    }
    
    private List<List<Integer>> combine(int i, int count, int n, int k) {
        
        if(count == k) {
            List<List<Integer>> output = new ArrayList<>();
            output.add(new ArrayList<>());
            return output;
        }
        
        if(i > n)
            return new ArrayList<>();
        
        List<List<Integer>> output = new ArrayList<>();
        List<List<Integer>> excluding = combine(i + 1, count, n, k);
        List<List<Integer>> including = combine(i + 1, count + 1, n, k);
        
        for(List<Integer> eachIncl : including) {
            eachIncl.add(i);
            output.add(eachIncl);
        }
        output.addAll(excluding);
        
        return output;
    }
}
