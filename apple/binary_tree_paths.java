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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> anslist = new ArrayList<String>();
        if(root == null ){
            
            return anslist;
            
        }
        
        String temp = "";
        find(root , temp , anslist);// pass a temporary string
        
        return anslist;
        
        }
    
    public void find(TreeNode root , String temp , List<String> anslist){
        
        // if(root == null){// if a node is leaf node then return it dont perform any opeartion
        //     return;
        // }
        if(root != null && root.left == null && root.right == null){// if it is a leaf node then dont need to add -> 
            
            anslist.add(temp + root.val );// no need to do new String(temp + root.val) and add because string are always pass by value
            
        }
        
        if(root.left != null){// as long as there is a child node which is not null we can go, this way we need not write if root ==null return 
            find(root.left , temp + root.val + "->",anslist );
        }
        
        
        if(root.right != null){
            find(root.right , temp + root.val + "->",anslist );
        }
        
        
        return;
    }
}