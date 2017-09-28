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
        
        
        
        ArrayList<String> list = new ArrayList<String>();
        if(root == null){
            return list;
        }
        String str = "";
        search(list , str , root);
        return list;
        
    }
    public void search(ArrayList<String> list , String str , TreeNode root){
        
        // System.out.println( "priting the string "+ root.val);
        if(root == null ){
            return;
        }
        if(root!= null && root.left == null && root.right ==null ){
            
            
            list.add(str + root.val);// if we do any manipulation in string it is stored as a new string, String even though is not a primitive data type it behaves like one. So for string when we pass a it a new object of it will be created using the data. So when we again go back in recurison the changes are not reflected like it happens for arraylist. 
            return;
        }
        
        search(list, str + root.val + "->" , root.left);
        search(list, str + root.val + "->" , root.right);
        
        return;
        
        
        
        
        
    }
}