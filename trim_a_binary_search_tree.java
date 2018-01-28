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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        
        if(root == null){
            return null;
        }
        
        if(root.val > R){ // if value is more than right ,go left and trim the right part
            
            return trimBST(root.left , L , R);// directly retunr without assigning it to anything else, as once this if condition  is entered then it means the value is out of bounds so do not assign it to anything
        }
        if(root.val < L){// if a value is less than lower bound, then go right
            
            return trimBST(root.right , L , R);// direclty return without assign it to anything as it a out of given range
            
        }
        
        root.left = trimBST(root.left , L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
}