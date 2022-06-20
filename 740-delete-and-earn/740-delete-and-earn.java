class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int maxNum = Integer.MIN_VALUE;
        Map<Integer, Integer> points = new HashMap<>();
        for(int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }
        
        int[] maxPoints = new int[maxNum + 1];
        for(int i = 1; i <= maxNum; i++) {
            int pointsForNum = points.getOrDefault(i, 0);
            maxPoints[i] = i == 1 ? pointsForNum :  Math.max(maxPoints[i-1], pointsForNum + maxPoints[i - 2]);
        }
        return maxPoints[maxNum];
    }
}