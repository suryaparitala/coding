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
    public int closestValue(TreeNode root, double target) {
        
        if(root == null){
            return -1;
            
        }
        
        return cval(root , root.val , target);
        
    }
    
    public int cval(TreeNode root , int val , double target){
        
        
       int ans = Integer.MIN_VALUE;
        
        if(root == null){// if we encounter a null, since according to the code below we are always moving in the right path i.e we check and move left or right based on the target value , so we can directly return null as it will be the best path before encountering null
            return val;
        }
        
        
        if((double)root.val == target ){
            
            return root.val;
            
        }
        
        
        
            
            
        if( Math.abs(target - root.val) < Math.abs(target - val) ){// here we compare the target with root.val and previos val,if an even closer value is found then just update the val
                val = root.val;  
        }
        
        if( target < root.val){// move according the target
            ans = cval(root.left, val ,target );
            
        }
        
        else if( target > root.val){
            ans = cval(root.right, val ,target );
            
        }
        
        if(ans == Integer.MIN_VALUE){//if ans is MIN_VALUE then it means neither of the recursive calls are evaluated.In that case return the closest obtained so far i.e val
            
            return val;
            
        }else{
            
            return ans;
        }
        
        
    }
}