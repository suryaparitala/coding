/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {// the sum asks us to give the smallest element in the tree one after the other,not next smallest after root

    Stack<TreeNode> stk = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        
        
    
        TreeNode curr = root;
        while(curr != null){
           
            stk.push(curr);
            curr = curr.left;
            
        }
        
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {// if stack is empty return true or else return false
        
        if(!stk.isEmpty()){
            
            return true;
        }
        else{
            return false;
        }
        
    }

    /** @return the next smallest number */
    public int next() {// pop the top element from the stack and futher process it
        
        TreeNode ans = stk.pop();
        
        if(ans.right != null){// if the removed element has right node add it and its left children as well
            
            
            TreeNode curr = ans.right;
            while(curr != null){
                
                stk.push(curr);
                curr = curr.left;
            }
        
        }
        
        return ans.val;
}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */