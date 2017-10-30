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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        
//         if(root == null ){
//             return Integer.MIN_VALUE;// doing this so that we need not write other function to compute kthsmallest
//         }
        
//         int ans1 = kthSmallest(root.left , k);
        
//         count++;
//         if(count == k){// since it goes inorder traversal k th smallest is the k th root it visits in a BST
//             return root.val;
//         }
//        int ans2 =  kthSmallest(root.right , k);
        
//        return ans1 ==  Integer.MIN_VALUE ? ans2 : ans1;// to deal with cases where ans1 = actaul answer and ans2 = Integer.MIN_VALUE, if both are min value return which ever doesnt matter, at any point if we find the answer and its is there in one of ans1 or ans2 then return the one with the answer
        
        
        int count = 0;
        int ans = Integer.MIN_VALUE;
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        
        TreeNode p = root;
        
        while(!stk.isEmpty() || p!=null){
            
            if(p!=null){// keep pushing left nodes onto the stack
                
                stk.push(p);
                p = p.left;
                
                
            }
            else{// if there are no more left nodes then we pop the node process it and go right
                
                TreeNode temp = stk.pop();// remove the node and process it
                count++;
                System.out.println(temp.val + " and " + count);
                
                if(count == k){
                    ans = temp.val;
                    return ans;
                }
                p = temp.right;// now make p as the right node of temp and continue i.e if that node has left child keep adding it 
                
                
            }
            
        }
        return ans;
    }
}