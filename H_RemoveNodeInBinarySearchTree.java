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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
    }
    
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }
        
        if (node.val == value) {
            return parent;
        }
        if (value < node.val) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
        if(node.left == null && node.right == null) {   //case 1: no child, delete it directly
            if(parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if(node.left == null || node.right == null) {  //case 2: 1 child, make parent point to its child
            if(node.left == null) {
                if(parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            } else {
                if(parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }                
            }
        } else {    //case 3: 2 children
            //step 1: find minimum in right subtree, and its parent
            TreeNode min = node.right;
            TreeNode minParent = node;
            while(min.left != null) {
                min = min.left;
            }
            if(minParent.right == min) {
                
            } else {
                minParent = minParent.right;
                while(minParent.left != min) {
                    minParent = minParent.left;
                }
            }
            
            //step 2: replace node's value with min in right subtree
            node.val = min.val;
            
            //step 3: delete min
            deleteNode(minParent, min);
        }
    }
}
