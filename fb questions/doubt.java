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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<LinkedList<Integer>> anslist = new List<LinkedList<Integer>>();
        if(root == null){
            return anslist;
        }
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        int level = 1;
        stk.push(root);
        LinkedList<Integer> levellist = new LinkedList<Integer>();
        while(!stk.isEmpty()){
            
            int size = stk.size();
            
            for(int i=0; i< size ; i++){
                
                TreeNode temp = stk.pop();
                levellist.add(temp.val);
                if(temp.left != null){
                    stk.push(temp.left);
                }
                if(temp.right != null){
                    stk.push(temp.right);
                }
            }
            anslist.add(new LinkedList<TreeNode>(levellist));
            level++;
            levellist.clear();
            
        }
        return anslist;
        
    }
}