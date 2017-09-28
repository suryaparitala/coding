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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        
        if(nums.length == 0){
            return null;
        }
        int low =0;
        int high = nums.length -1;
        TreeNode root = null;
        root =  build(nums , low , high,root);
        return root;
        
    }
    
    public TreeNode build(int[] nums , int low ,int high,TreeNode root){
        
        if(low > high  ){// note in the base condition we do low > high then when we have mid = low = high = 0 for example then according to recursive calls we do root.left = build(nums , 0 , -1(0-1) , root.left ) and root.right = build(nums , 1 , 0 , root.right) both of which will fail. instead if we put something like if(low < 0 || high > nums.length-1) as base it will never check and return null for cases where low =1 and high =0 since both conditiosn are fine according to it
            
            return null;
        }
        
        int mid = (low + high )/2;
        root = new  TreeNode(nums[mid]);
        
            root.left = build(nums ,low , mid-1 ,root.left );
            root.right = build(nums , mid+1 , high, root.right);
        
        
        return root;
        
    }
    

}