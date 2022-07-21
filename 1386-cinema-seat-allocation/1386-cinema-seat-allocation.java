class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, Set<Integer>> reserved = new HashMap<>();
        for(int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            Set<Integer> seats = reserved.getOrDefault(row, new HashSet<>());
            seats.add(reservedSeat[1]);
            reserved.put(row, seats);
        }
        // 2-5
        // 4-7
        // 6-9
        
        int families = 0;
        for(int row : reserved.keySet()) {
            Set<Integer> seats = reserved.get(row);
            for(int i = 2; i + 3 <= 9;) {
                if(seats.contains(i) || seats.contains(i + 1)) {
                    i += 2;
                    continue;
                }
                else if(seats.contains(i + 3) || seats.contains(i + 2)) {
                    i += 4;
                    continue;
                }
                i += 4;
                families++;
            }
        }   
        families += (n - reserved.size()) * 2;
        return families;
    }
}