class Solution {
    public int minPartitions(String n) {
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n.length(); i++) {
            max = Math.max(max, Integer.parseInt(String.valueOf(n.charAt(i))));
        }
        return max;
    }
}