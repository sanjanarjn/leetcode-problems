class Solution {
    
    public List<String> wordSubsets(String[] A, String[] B) {
        
        int[] bmax = new int[26];
        for (String b: B) {
            int[] bCount = getCount(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        for (String a: A) {
            if(isUniversal(a, bmax)) {
                ans.add(a);
            }
        }
        return ans;
    }
    
    private boolean isUniversal(String a, int[] bmax) {
        int[] aCount = getCount(a);
        for(int i = 0; i < 26; i++) {
            if(aCount[i] < bmax[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getCount(String S) {
        int[] count = new int[26];
        for (char c: S.toCharArray())
            count[c - 'a']++;
        return count;
    }
}