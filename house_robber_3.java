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
    public int rob(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        HashMap<TreeNode , Integer> map = new HashMap<TreeNode , Integer>();
        return rob2(root,map);
        
    }
    
    
    public int rob2(TreeNode root , HashMap<TreeNode , Integer> map){
        
        
        if(root == null){
            return 0;
        }
        
        int val = 0;
        if(map.containsKey(root)){
            return map.get(root);
        }
        
        if(root.left !=null){// make sure we rob the grandchilren and not the children
            val = val + rob(root.left.left);
            val = val + rob(root.left.right);
        }
        if(root.right !=null){
            val = val + rob(root.right.left);
            val = val + rob(root.right.right);
        }
        
        int otherval = 0;
        // here we go root.left and root.right to got the children nodes and recursively compute the value get if we rob them.
        otherval = otherval + rob(root.left);
        otherval = otherval + rob(root.right);// for every given root node it goes to its left and right childs to check what would be the case if we rob the child instead of grandchilren and the root itself. All the information is stored and is sent in a bottom up manner
        int rand = Math.max(val + root.val , otherval);
        map.put(root, rand);
        return rand;// starting from the very last node we compute robbing which is better, i.e robbing the child nodes or robbing the current node and the grandchildren.
        
        
        // also since for every rob we calculate the once without the child and with the childern and when we go up the recursion we calcualte the root.left and root.right , for these two again we calcualte one without the child and the one with the child, but for down depper iterations we must have already done that. So just use hashmap to retreive the values
        
        
    }
}
