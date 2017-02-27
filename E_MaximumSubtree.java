public class Solution {
    /**
     * @param root the root of binary tree
     * @return the maximum weight node
     */
     
    TreeNode res;
    int max;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if(root == null) {
            return null;
        }
        sum(root);
        return res;
    }
    
    public int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int sum = root.val + sum(root.left) + sum(root.right);
        if(sum > max) {
            max = sum;
            res = root;
        }
        return sum;
    }
}
