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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null){// if no elements the its symmetric
            return true;
        }
        Boolean ans = false;
        ans = find(root.left , root.right);//since we want mirror roots left and  roots right must match
        
        return ans;
        
        
    }
    public boolean find(TreeNode root1, TreeNode root2 ){
        
        if(root1 == null && root2 == null ){// base case if both are null then they are same so true
            return true;
        }
        if(root1 == null || root2 == null){// already both null case is dealt above here if one is null and other isnt then return false
            return false;
        }
        if(root1.val != root2.val){// in an recuresicve level if both are different its pointless to contine so return false
            return false;
        }
        Boolean ans1 = find(root1.left , root2.right);//for left of root1 compare with right of root2
        Boolean ans2 = find(root1.right , root2.left);//for right of root1 compare with left of root because its mirrored
        
        return ans1 && ans2;
        
        
        
    }
}