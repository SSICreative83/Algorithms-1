public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        if(s == null || s.length() == 0) {
            return s;
        }
        
        return dfs(s);
    }
    
    public String dfs(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        if(s.indexOf('[') == -1) {  //no brackets
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int start = -1;
        int end = -1;
        boolean nextlevel = false;
        boolean isNum = false;
        int number = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '[') {
                if(stack.isEmpty()) {
                    start = i;
                    nextlevel = true;
                }
                stack.push(i);
                
            } else if(cur == ']'){
                int j = stack.pop();
                if(stack.isEmpty()) {
                    end = i;
                    nextlevel = false;
                    String res = dfs(s.substring(start + 1, end));
                    while(number > 0) {
                        sb.append(res);
                        number--;
                    }
                }
            } else if(Character.isDigit(s.charAt(i))) {
                if(!nextlevel) {
                    isNum = true;
                    number = 10 * number + (s.charAt(i) - '0');
                }
            } else {
                if(!nextlevel){
                    sb.append(s.charAt(i));
                }
            } 
        }
        
        return sb.toString();
    }
}
