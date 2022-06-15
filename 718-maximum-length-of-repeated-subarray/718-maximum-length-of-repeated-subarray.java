class Solution {
    public int findLength(int[] A, int[] B) {
        int result = 0;
        int aLastIndex = A.length - 1;
        int bLength = B.length;
        for (int i = 0; i < A.length + B.length - 1; ++i) {
            
            int aStart = Math.max(0, aLastIndex - i);
            int bStart = Math.max(0, i - aLastIndex);
            int numConsecutiveMatches = 0;
            for (int aIdx = aStart, bIdx = bStart; aIdx < A.length && bIdx < B.length; ++aIdx, ++bIdx) {
                numConsecutiveMatches = A[aIdx] == B[bIdx] ? numConsecutiveMatches + 1 : 0;
                result = Math.max(result, numConsecutiveMatches);
            }
        }
        return result;
    }
}