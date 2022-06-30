/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Pair {
    int level;
    List<NestedInteger> integers;
    
    Pair(int level, List<NestedInteger> integers) {
        this.level = level;
        this.integers = integers;
    }
}

class Solution {
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0, nestedList));
        
        int level = 0;
        int maxDepth = -1;
        boolean allIntegers = false;
        
        int sum = 0;
        while(!stack.isEmpty()) {
            
            Pair pair = stack.pop();
            List<NestedInteger> nextNestedIntegers = new ArrayList<>();
            List<NestedInteger> nextFlatIntegers = new ArrayList<>();
            
            for(NestedInteger nInteger : pair.integers) {
                if(allIntegers) {
                    sum += (maxDepth - pair.level + 1) * nInteger.getInteger();
                    continue;
                }
                
                if(nInteger.isInteger()) 
                    nextFlatIntegers.add(nInteger);
                else 
                    nextNestedIntegers.addAll(nInteger.getList());
                  
            }
            level++;
            if(nextFlatIntegers.size() > 0) {
                stack.push(new Pair(level, nextFlatIntegers));
            }
            if(nextNestedIntegers.size() > 0) {
                stack.push(new Pair(level, nextNestedIntegers));
            }
            else {
                allIntegers = true;
                maxDepth = maxDepth == -1 ? level : maxDepth;
            }
        }
        return sum;
    }
}
























