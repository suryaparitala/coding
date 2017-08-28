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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        Boolean ans = false;
        
        if(s == null && t == null){
            return true;
        }
        if(s == null && t!= null || s!= null && t == null)
            return false;
    
        if(s.val == t.val){
            System.out.println(s.val);
             ans = compare(s,t);
             System.out.println(ans);
        }
        
        
        Boolean leftans = isSubtree(s.left , t);
        Boolean rightans = isSubtree(s.right , t);
        
        return leftans || rightans || ans; // here we use or because even if we its true for any subtree it must be true overall
        
    }
    
    public boolean compare(TreeNode root1 , TreeNode root2){
        if(root1 == null && root2 == null)    
            return true;
        if(root1 == null && root2 != null || root1 != null && root2 == null)    
            return false;
        if(root1.val != root2.val)
            return false;
        Boolean leftans = compare(root1.left , root2.left);
        Boolean rightans = compare(root1.right , root2.right);
        
        return leftans && rightans;
    }
}