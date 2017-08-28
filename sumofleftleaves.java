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
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        int ans =0;
        
        int left = sumOfLeftLeaves(root.left);
        
        if(root.left != null) // to check if left child exists
            if(root.left.left == null && root.left.right == null) //  to check if left child is a leaf node
                ans = root.left.val;
        
        int right = sumOfLeftLeaves(root.right);
        
        return ans + left + right;
        
        
    }
}