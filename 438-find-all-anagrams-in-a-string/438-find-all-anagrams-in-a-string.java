class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        
        int pLen = p.length();
        int sLen = s.length();
        
        int[] pCount = new int[26];
        for(int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        
        int[] sCount = new int[26];
        
        int left = 0;
        int right = 0;
        List<Integer> output = new ArrayList<>();
        while(right < sLen) {
            
            sCount[s.charAt(right) - 'a']++;
            if(right - left + 1 == pLen) {
                if(Arrays.equals(sCount, pCount)) {
                    output.add(left);
                }
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return output;
    }
}