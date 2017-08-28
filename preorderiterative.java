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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
         if(root == null){
             return list;
         }
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        while(!stk.isEmpty() || root != null){ // also keep root != null because in some cases eventhough the stack is empty all nodes are not covered , in that case root is not null so we can use it.
            // also we can use root != null as the first entry point into the loop , as intially stk is empty
            if(root != null){
                stk.push(root);
                list.add(root.val); // add the list as soon as we get to the root , since it is pre order
                root = root.left;
            }
            else{
                root = stk.pop();
                
                root = root.right;
            }
        }
        return list;
    }
}