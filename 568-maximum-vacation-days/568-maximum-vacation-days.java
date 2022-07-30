class Solution {
    
    int[][] flights;
    int[][] days;
    
    int cities;
    int weeks;
    
    int[][] dp;
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        this.flights = flights;
        this.days = days;
        
        this.cities = flights.length;
        this.weeks = days[0].length;
        
        this.dp = new int[cities][weeks];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return travel(0, 0);
    }
    
    private int travel(int city, int week) {
        
        if(week == weeks)
            return 0;
        
        int maxDays = Integer.MIN_VALUE;
        
        if(this.dp[city][week] != -1)
            return this.dp[city][week];
        
        int[] nextFlights = flights[city];
        for(int i = 0; i < cities; i++) {
            if(i == city) {
                int stayInCity = days[city][week] + travel(city, week + 1);
                if(stayInCity > maxDays) {
                    maxDays = stayInCity;
                }
            }
            else if(nextFlights[i] == 1) {
                int goToNextCity = days[i][week] + travel(i, week + 1);
                if(goToNextCity > maxDays) {
                    maxDays = goToNextCity;
                }
            }
        }
        this.dp[city][week] = maxDays;
        return maxDays;
    }
}