/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
     private Point global_origin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        if(points == null || points.length == 0) {
            return new Point[0];
        }
        global_origin = origin;
        int minDist = Integer.MAX_VALUE;
        PriorityQueue<Point> heap = new PriorityQueue<Point>(k, new Comparator<Point>() {   //need to be a max heap!
            public int compare(Point a, Point b) {
                int diff = getDistance(b, global_origin) - getDistance(a, global_origin);
                if (diff == 0)
                    diff = b.x - a.x;
                if (diff == 0)
                    diff = b.y - a.y;
                return diff;
            }
        });
        for(int i = 0; i < points.length; i++) {
            heap.offer(points[i]);
            if (heap.size() > k)
                heap.poll();
        }
        
        Point[] res = new Point[heap.size()]; 
        int i = heap.size() - 1;
        while(!heap.isEmpty()) {    //iterate through right to left
            res[i] = heap.poll();
            i--;
        }
        return res;
    }
    
    public int getDistance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}
