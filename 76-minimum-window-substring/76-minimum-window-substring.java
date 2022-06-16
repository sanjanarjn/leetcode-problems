class Solution {
        public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        int left = 0;
        int right = 0;

        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int windowLen = Integer.MAX_VALUE;
        String minWindow = "";

        Map<Character, Integer> sCount = new HashMap<>();

        int charCount = 0;
        while (right < sLen) {

            char sChar = s.charAt(right);
            if (tCount.containsKey(sChar)) {
                sCount.put(sChar, sCount.getOrDefault(sChar, 0) + 1);

            }


            while (isValidWindow(sCount, tCount)) {
                if (right - left + 1 < windowLen) {
                    windowLen = right - left + 1;
                    minWindow = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                if(sCount.containsKey(leftChar)) {
                    int count = sCount.get(leftChar) - 1;
                    if (count == 0) {
                        sCount.remove(leftChar);
                    } else {
                        sCount.put(leftChar, count);
                    }
                }
                left++;
            }
            right++;
        }
        return minWindow;
    }

    private boolean isValidWindow(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {

        for(char c : tCount.keySet()) {
            if(sCount.containsKey(c)) {
                int countValInS = sCount.get(c);
                if(countValInS < tCount.get(c))
                    return false;
            }
            else return false;
        }
        return true;
    }
}