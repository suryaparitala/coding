/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return root;
        }
        
        if(!covers(root,p) || !covers(root,q)){
            return null;
        }
        
        if(root == p || root == q)
            return root;
        boolean isponleft = covers(root.left , p);
        boolean isqonleft = covers(root.left , q);
        
        if(isponleft != isqonleft){
            return root;
        }
        
        TreeNode godirection = isponleft == true ? root.left : root.right ;
        
        TreeNode ans = lowestCommonAncestor(godirection , p , q);
        
        return ans;
        
    }
    
    public boolean covers(TreeNode root ,TreeNode p){
        if(root == null)
            return false;
        if(root == p)
            return true;
        boolean coversleft = covers(root.left ,p);
        boolean coversright = covers(root.right ,p);
        
        return coversleft || coversright;
    }
}