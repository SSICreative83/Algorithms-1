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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if(root == null)    return null;
        DoublyListNode res = new DoublyListNode(root.val);
        if(root.left == null && root.right == null) {
            return res;
        }
        
        DoublyListNode left = bstToDoublyList(root.left);
        DoublyListNode right = bstToDoublyList(root.right);
        
        if(left != null) {
            DoublyListNode p = left;
            while(p.next != null) {
                p = p.next;
            }
            
            p.next = res;
            res.prev = p;
        }
        
        if(right != null) {
            res.next = right;
            right.prev = res;
        }
        
        return left == null ? res : left;
    }
}
