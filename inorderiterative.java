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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
         if(root == null){
             return list;
         }
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        while(!stk.isEmpty() || root != null){ // also keep root != null because in some cases eventhough the stack is empty all nodes are not covered , in that case root is not null so we can use it.
            // also we can use root != null as the first entry point into the loop , as intially stk is empty
            if(root != null){
                stk.push(root);
                root = root.left;
            }
            else{
                root = stk.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}