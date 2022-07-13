class WordDistance {

    Map<String, List<Integer>> indexMap;
    
    public WordDistance(String[] wordsDict) {
        indexMap = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            List<Integer> indices = indexMap.containsKey(word) ? indexMap.get(word) : new ArrayList<>();
            indices.add(i);
            indexMap.put(word, indices);
        }
    }
    
    public int shortest(String word1, String word2) {
        
        List<Integer> first = indexMap.get(word1);
        List<Integer> second = indexMap.get(word2);
        
        int i = first.size() - 1;
        int j = second.size() - 1;
        
        int min = Integer.MAX_VALUE;
        while(i >= 0 && j >= 0) {
            int firstElem = first.get(i);
            int secondElem = second.get(j);
            
            min = Math.min(min, Math.abs(firstElem - secondElem));
            
            if(firstElem > secondElem) {
                i--;
            }
            else {
                j--;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */