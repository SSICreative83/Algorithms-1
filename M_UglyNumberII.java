class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
     
    public int nthUglyNumber(int n) {
        if(n <= 0) {
            return -1;
        }
        PriorityQueue<Long> uglys = new PriorityQueue<>();
        uglys.add(1l);
        Set<Long> set = new HashSet<>();
        set.add(1l);
        
        for(int i = 1; i < n; i++) {
            long cur = uglys.poll();
            
            if(!set.contains(cur * 2)) {
                uglys.offer(cur * 2);
                set.add(cur * 2);
            }
            if(!set.contains(cur * 3)) {
                uglys.offer(cur * 3);
                set.add(cur * 3);
            }
            if(!set.contains(cur * 5)) {
                uglys.offer(cur * 5);
                set.add(cur * 5);
            }
        }
        
        return uglys.poll().intValue();
    }
};
