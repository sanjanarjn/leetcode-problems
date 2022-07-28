class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sCount = getCount(s);
        Map<Character, Integer> tCount = getCount(t);
        
        Map<Character, Integer> largerMap = sCount;
        Map<Character, Integer> smallerMap = tCount;
        if(tCount.size() > sCount.size()) {
            largerMap = tCount;
            smallerMap = sCount;
        }

         for (char key : largerMap.keySet()) {
            if (!smallerMap.containsKey(key))
                return false;

            int count1 = smallerMap.get(key);
            int count2 = largerMap.get(key);
            if (count1 != count2)
                return false;
        }
        
        return true;
        
    }
    
    private Map<Character, Integer> getCount(String s) {
        
        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }
}