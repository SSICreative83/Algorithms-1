/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode1(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) {
            return node;
        }
        if(root.left == null && root.val > node.val) {
            root.left = node;
            return root;
        }
        if(root.right == null && root.val < node.val) {
            root.right = node;
            return root;
        }
        
        if(root.val < node.val) {
            insertNode(root.right, node);
        } else {
            insertNode(root.left, node);
        }
        
        return root;
    }
    
    //Iterative
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root == null) {
            return node;
        }
        
        TreeNode pre = root;
        TreeNode p = root;
        while(p != null) {
            pre = p;
            if(p.val < node.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        
        if(pre.val < node.val) {
            pre.right = node;
        } else {
            pre.left = node;
        }
        return root;
    }
}
