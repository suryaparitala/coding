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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0){
            return null;
            
        }
        
        int prestart = 0;
        int instart = 0;
        int inend = inorder.length - 1;
        TreeNode ans = build(prestart , instart , inend , preorder , inorder);
        
        return ans;
        
    }
    
    public TreeNode build(int prestart , int instart , int inend , int[] preorder ,int[] inorder){
        
        
        // if(instart > preorder.length){
        //     return null;
        // }
        if(instart > inend){ // if inorder start more than inoreder end then it is a not possibel case so null
            return null;
            
        }
        
        int val = preorder[prestart];// get the preorder value and make a treenode
        
        TreeNode newnode = new TreeNode(val);
        
        int indexpos = 0;
        
        for(  ; indexpos < preorder.length ; indexpos++){ // find the corresponding position of the preoreder node in the inorder array
            
            if(inorder[indexpos] == val){
                break;
            }
        }
        
        newnode.left = build(prestart+1 , instart , indexpos -1 , preorder , inorder); // for the left subtree of newnode, prestart is the next element , and inorder values are between start and indexpos -1
        
        newnode.right = build(   prestart + (indexpos - instart) +1 , indexpos +1 ,inend , preorder , inorder);// for the right subtree , prestart is the current prestart + length of left inorder subtree, because left inorder subtree length and right inorder subtree length must match, as inorder the root is in the middle
        
        
        
        return newnode;
        
    }
}




