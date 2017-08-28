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
    public int maxDepth(TreeNode root) {
        // Method 1 using queue
        // Queue<TreeNode> q = new LinkedList<TreeNode>();
        // int depth =0;
        // if(root == null){
        //     return 0;
        // }
        
        // q.offer(root);
        
        // while(!q.isEmpty()){
            
        //     for(int i=0; i<q.size(); i++){
        //         TreeNode temp = q.poll();
        //         if(temp.right != null){
        //             q.offer(temp.right);
        //         }
        //         if(temp.left != null){
        //             q.offer(temp.left);
        //         }
        //     }
        //     depth++;
            
        // }
        // return depth;
        
        //method 2 using recursion
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left,right)+1; // get the dominant child add the node itself and pass , here nodes asked not edges so add1
    }
}