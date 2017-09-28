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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum =0;
        if(root == null){
            return sum;
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            // return  sum + root.left.val; note we cant just do return after finding a leaf because if done so if the first node has a leaf then the code will directly return only traversing the left node instead of traversing the remaining tree ex - [3,9,20,null,null,15,7] for this it checks that 9 is a left leaf and directly return only 9 instead of traversing the right of the first node and checking for remainng left leaves
            
            sum = sum + root.left.val; // add the left leaf sum and instead of returning further continue recurison to cover the entire tree
            
        }
        
        sum = sum + sumOfLeftLeaves(root.left);
        sum = sum + sumOfLeftLeaves(root.right);
        
        return sum;
        
        
    }
}