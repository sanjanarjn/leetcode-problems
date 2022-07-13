/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    public int findCelebrity(int n) {
        
        int celebrity = -1;
        Set<Integer> notPossible = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(notPossible.contains(i))
                continue;
            
            boolean isCelebrity = true;
            for(int j = 0; j < n; j++) {
                if(i == j)
                    continue;
                
                if(knows(j, i)) {
                    notPossible.add(j);
                }
                
                if(knows(i, j) || !knows(j, i)) {
                    isCelebrity = false;
                    break;
                }
                
            }
            if(isCelebrity) {
                celebrity =  i;
                break;
            }
        }
        return celebrity;
    }
}