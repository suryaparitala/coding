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
        
        if(root == null)
            return root;
            
        if(root == p || root == q) // if root hits p and q first then that will be the least common ancestor as we are starting our traversal from the top and the next node is bound to be below it. 
            return root;
            
        if(root.val >= p.val && root.val < q.val  || root.val >= q.val && root.val < p.val) // since we dont know among p and q which one is the bigger item.
            return root;
        TreeNode ans  = null;
        if(root.val < p.val && root.val < q.val) // if both lie on right side of root
             ans = lowestCommonAncestor(root.right , p ,q);
        if(root.val > p.val && root.val > q.val)// if both lie on the left side of the root
             ans = lowestCommonAncestor(root.left , p ,q);
        
        return ans;
        
        
        
        
    }
}