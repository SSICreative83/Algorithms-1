public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        if(k <= 0) {
            return maxLen;
        }
        // Key: letter; value: the number of occurrences.
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                maxLen = Math.max(maxLen, i - start + 1);
            } else {
                if(map.size() >= k) {
                    while(map.size() >= k) {
                        char del = s.charAt(start);
                        if(!map.containsKey(del)) {
                            continue;
                        } else {
                            map.put(del, map.get(del) - 1);
                            if(map.get(del) <= 0) {
                                map.remove(del);
                            }
                        }
                        start++;
                    }
                    map.put(c, 1);
                } else {
                    map.put(c, 1);
                    maxLen = Math.max(maxLen, i - start + 1);
                }
            }
        }
        return maxLen;
    }
}
