/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null || root == p || root == q)  return root;
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
//         if(left != null && right != null)   return root;
//         return left != null ? left : right;
//     }
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        if(root == null){
            
            return null;
        }
        
        if(root == p || root == q){ // dont keep root.val and p.val and q.val, directly keep root == p because there may exist two nodes with the same val
            
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right  = lowestCommonAncestor(root.right , p , q);
        
        if(left != null && right != null){
            
            return root;
            
        }
        
        return left == null ? right : left ;
        
        
        
        
    }
}