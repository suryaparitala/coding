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
    public int pathSum(TreeNode root, int sum) {
        
        int count =0;
        
        if(root == null ){
            return count;
        }
            count = pathsumdfs(root , sum , 0);
        
        int leftcount = pathSum(root.left , sum);
        int rightcount = pathSum(root.right , sum);
        
        return leftcount + rightcount + count;
        
    }
    
    public int pathsumdfs(TreeNode root,int targetsum , int currentsum){
        int count =0;
        
        
        if(root == null){
            
            return count;
        }
        
        
        
        currentsum += root.val; //  add the value of the root to current sum before traversing since in java primitives are call by value when recursion goes back current sum is also reverted
        
        System.out.println(currentsum);
        
        int leftcount = pathsumdfs(root.left , targetsum , currentsum ); // also tried pathsumdfs(root.left , targetsum , currentsum + root.val) but this doesnt work as it fails at the null case. When it goes to null it negelcts adding the root element before it
        
        
        if(currentsum == targetsum){
            
           // System.out.println("found a path " + root.val);
            count++;
        }
        int rightcount = pathsumdfs(root.right , targetsum , currentsum );
        
        return count + leftcount + rightcount;
        
    }
}