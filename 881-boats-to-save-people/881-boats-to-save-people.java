class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length - 1;
        
        int boats = 0;
        int count = 0;
        
        while(i <= j) {   
            int currSum = people[i] + people[j];
            if(currSum <= limit) {
                i++;
                j--;
            }
            else {
                j--;
            }
            boats++;
        }
        return boats;
    }
}