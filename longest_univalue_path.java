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
    
    public int len = 0;
    public int longestUnivaluePath(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        longpath(root, root.val);
        
        return len;
        
    }
    
    public int longpath(TreeNode root , int val){
        
        if(root == null){
            
            return 0;
        }
        
        
        int left = longpath(root.left,root.val);
        
       int right = longpath(root.right, root.val);
        
        len = Math.max(len , left + right); // since left and right only store continous length that are possible,and they all compare with root.val we can directly add them
        
        if(root.val == val){// then parent node and child node are same
            return Math.max(left,right)+1;// since we are comparing with the parent node return the max continous length obtained so far, if the parent is same as child increase the max among left and right by 1 and push higher
            
        }
        // parent not same as current  so return 0, i.e if continuity break then just return 0
            return 0;
        
        
        
    }
}