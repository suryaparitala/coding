/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {// note we need to add values greater than a given key to the original key value, so start from the right most as nothing is more than it and nothing needs to be added
    
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        
        if(root == null){
            return null;
        }
        
        convertBST(root.right);// go right first
        
        sum = sum + root.val;// now at this point we are at parent node after visiting its right node so add its value to sum so that the sum can be added to its left node later
        
        root.val  =   sum;//assign new sum as root.val,note since we already addded root.val to sum in previous statement we directly assign it
        
        convertBST(root.left);// now visit left child
        
        
            
        return root;
        
        
    }
    
    
}