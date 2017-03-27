public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here

        double start = 0.0;
        double end = x;
        double eps = 1e-12;
        
        if(end < 1.0) { //sqrt(0.64) = 0.8, which is larger than x
            end = 1.0;
        }
        
        while(end - start > eps) {
            double mid = (end + start) / 2;

            if(mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
