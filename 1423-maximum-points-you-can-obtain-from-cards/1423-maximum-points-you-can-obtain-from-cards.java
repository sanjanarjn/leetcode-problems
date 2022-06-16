class Solution {
    
        public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int totalSum = 0;
        for(int point : cardPoints) {
            totalSum += point;
        }

        if(k >= n)
            return totalSum;
            
        int left = 0;
        int right = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        while(right < n) {
            sum += cardPoints[right];
            if(right - left + 1 == n - k) {
                minSum = Math.min(minSum, sum);
                sum -= cardPoints[left];
                left++;
            }
            right++;
        }
        return totalSum - minSum;
    }
}