class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            int count = countMap.getOrDefault(c, 0) + 1;
            countMap.put(c, count);
        }
        for(int i = 0; i< s.length(); i++) {
            if(countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}