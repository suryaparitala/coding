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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        TreeNode t3 = null;
        
        if(t1 == null && t2 == null){
            return t3;
        }
        
        if(t1 == null || t2 == null){
            TreeNode notnull = t1 == null ? t2 : t1;
             t3 = new TreeNode(notnull.val);
        }
        if(t1 != null && t2 != null ){
             t3 = new TreeNode(t2.val + t1.val);
        }
        
        t3.left = mergeTrees(t1 == null ? null : t1.left , t2 == null ? null : t2.left); // we are sending to the next recurion so if t1 or t2 is null we cant send by telling null.left and null.right that leads to exception
        t3.right = mergeTrees(t1 ==null ? null: t1.right ,t2 == null ? null:t2.right);
         
        return t3;
    }
}