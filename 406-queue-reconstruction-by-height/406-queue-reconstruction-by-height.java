class Solution {
      public int[][] reconstructQueue(int[][] people) {

        Comparator<int[]> comparator = (int[] a, int[] b) -> {
            int compare = Integer.compare(a[0], b[0]);
            if(compare == 0)
                return Integer.compare(a[1], b[1]);
            return -compare;
        };
        Arrays.sort(people, comparator);

        List<int[]> queue = new LinkedList<>();
        for(int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[people.length][2]);
    }

}