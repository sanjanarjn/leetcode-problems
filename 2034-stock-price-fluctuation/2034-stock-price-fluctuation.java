class StockPrice {

    PriorityQueue<TimePrice> minHeap, maxHeap;
    Map<Integer, Integer> priceByTime;
    int latestTime = -1;
    
    public StockPrice() {
        minHeap = new PriorityQueue<>((tp1, tp2) -> Integer.compare(tp1.price, tp2.price));
        maxHeap = new PriorityQueue<>((tp1, tp2) -> -Integer.compare(tp1.price, tp2.price));
        priceByTime = new HashMap<>();
    }
    
    public void update(int timestamp, int price) {
        latestTime = Math.max(timestamp, latestTime);
        
        TimePrice tp = new TimePrice(timestamp, price);
        minHeap.add(tp);
        maxHeap.add(tp);
        
        priceByTime.put(timestamp, price);
    }

    public int current() {
        return priceByTime.get(latestTime);
    }
    
    public int maximum() {
        
        while(!maxHeap.isEmpty()) {
            TimePrice maxPair = maxHeap.peek();
            if(maxPair.price == priceByTime.get(maxPair.ts)) {
                return maxPair.price;
            }
            maxHeap.remove();
        }
        return -1;
    }
    
    public int minimum() {
       while(!minHeap.isEmpty()) {
            TimePrice minPair = minHeap.peek();
            if(minPair.price == priceByTime.get(minPair.ts)) {
                return minPair.price;
            }
            minHeap.remove();
        }
        return -1;
    }
}

class TimePrice {
    int ts;
    int price;
    
    public TimePrice(int ts, int price) {
        this.ts = ts;
        this.price = price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */