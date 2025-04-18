 class StockPrice {
    TreeMap<Integer,Integer> map;
    TreeSet<int[]> set; //timestamp-price
    
    public StockPrice() {
        map = new TreeMap<>();
        set = new TreeSet<>((a,b)->a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)) {
            int oldPrice=map.get(timestamp);
            set.remove(new int[]{timestamp,oldPrice});
        }
            
        map.put(timestamp,price);
        set.add(new int[]{timestamp,price});
    }
    
    public int current() {
        return map.get(map.lastKey());
    }
    
    public int maximum() {
        return set.last()[1];
    }
    
    public int minimum() {
        return set.first()[1];
    }
}