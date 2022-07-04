class Solution {
    public int candy(int[] ratings) {
       
        int i = 1;
        int n = ratings.length;
        
        int count = 0;
        
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        while(i < n) {
            candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : candies[i];
            i++;
        }
        i = n - 2;
        count += candies[n - 1];
        while(i >= 0) {
            candies[i] = ratings[i] > ratings[i + 1] ? Math.max(candies[i], candies[i + 1] + 1) : candies[i];
            count += candies[i];
            i--;
        }       
        return count;
    }
}