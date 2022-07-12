import java.util.HashMap;
import java.util.Collections;

class Solution {
        int n;
    int[] matchsticks;
    int[] edges;



    public boolean makesquare(int[] matchsticks) {

        
        this.n = matchsticks.length;
        this.matchsticks = Arrays.stream(matchsticks).boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        
        int sum = 0;
        for(int match : matchsticks) {
            sum += match;
        }

        if(sum % 4 != 0)
            return false;

        int edge = sum/4;
        this.edges = new int[] {edge, edge, edge, edge};

        return partition(0, sum);
    }

    private boolean partition(int i, int totalSum) {

        if(i == n)
            return totalSum == 0;

        if(totalSum == 0)
            return false;

        int elem = matchsticks[i];
        for(int j = 0; j < edges.length; j++) {

            if(elem > edges[j])
                continue;

            edges[j] -= elem;
            totalSum -= elem;

            boolean canPartition = partition(i + 1, totalSum);
            if(canPartition)
                return true;

            edges[j] += elem;
            totalSum += elem;
        }
        return false;
    }
}