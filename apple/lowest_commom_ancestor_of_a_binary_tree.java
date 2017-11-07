/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        
        if(root == p || root == q){// if root is equal to any of the keys then reutn root
            return root;
            
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right  = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null){// if root gets both its left and right as not null , then return that root
            return root;
            
        }
        
        
        return left == null ? right : left;// return the not null root among the two, if now return anything doesnt matter,in our case returning left
        
        
        
    }
}