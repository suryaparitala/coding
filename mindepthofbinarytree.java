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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        return (root.left == null || root.right == null)? left+right +1 : Math.min(left,right)+1;// unlike max depht we need an extra check to see if only left or right root are present, by doing so we make sure that the child that is present is considered as the least child node rather than taking a child node which is always not there and always contributes least value zero.
        
    }
}