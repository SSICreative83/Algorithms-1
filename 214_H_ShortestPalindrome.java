public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        
        int index = 0;
        for(int i = s.length() / 2; i >= 0; i--) {
            if(isPalindrome(s, i, 1)) { //even first, "aabba"
                index = 2 * i + 1;
                break;
            }
            if(isPalindrome(s, i, 0)) { //odd
                index = 2 * i;
                break;
            } 
        }
        
        StringBuilder remainder = new StringBuilder(s.substring(index + 1));
        return remainder.reverse() + s;
    }
    
    public boolean isPalindrome(String s, int center, int shift) {
        int start = center, end = center + shift;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if(start >= 0) {
            return false;
        }
        return true;
    }
}
