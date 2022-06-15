class Solution {
        public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        int i = 0;
        int j = 0;

        int[] s1Count = new int[26];
        for(int s1Idx = 0; s1Idx < s1.length(); s1Idx++) {
            char c = s1.charAt(s1Idx);
            s1Count[c - 'a'] = s1Count[c - 'a'] + 1;
        }


        int[] s2Count = new int[26];
        while(j < s2.length()) {
            char jChar = s2.charAt(j);
            s2Count[jChar - 'a'] = s2Count[jChar - 'a'] + 1;
            int windowSize = j - i + 1;
            if(windowSize == s1.length()) {
                if(Arrays.equals(s1Count, s2Count)) {
                    return true;
                }
                char iChar = s2.charAt(i);
                s2Count[iChar - 'a'] = s2Count[iChar - 'a'] - 1;
                i++;
            }
            j++;
        }
        return false;
    }
}