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
    
//     HashSet<Integer> set = new HashSet<Integer>();
//     public boolean findTarget(TreeNode root, int k) {
        
//         if(root == null){
//             return false;
//         }
        
//         if(set.contains(k - root.val)){
//             return true;
            
//         }
//         set.add(root.val);
        
//         boolean  ans1 = findTarget(root.left , k);
//         boolean ans2 = findTarget(root.right , k);

//         return ans1 || ans2;
        
//     }
    
 
  // even better solution  
    public boolean findTarget(TreeNode root, int k) {
        
        
        if(root == null){
            return false;
        }
        
        return findTarget2(root , root , k);// we need a third parameter also which is explained in future commtns
        
       }
    
    
     public boolean findTarget2(TreeNode root, TreeNode curr ,int k) {
        
        
        if(curr == null){
            return false;
        }
        
        int tofind = k - curr.val;// assuming that root.val is one of the numbers we need to find its counter part
        
        if(search(root , curr ,tofind) ){ // we also need to always have the root becuase for a given val we need to serach its counter part starting from the root, or else we may miss out some values, ex - 1,2,3 and target = 4 case, when we choose 1 as our first val to find the second val we need to start seraching from the topmost root 
            return true;
        }
        
      boolean ans1 = findTarget2(root , curr.left , k);// run serach function on all the nodes
      boolean ans2 = findTarget2(root, curr.right , k);
        
        
        return ans1 || ans2;
        
       }
    
    
    public boolean search( TreeNode root ,TreeNode curr ,   int k ){
        
        
        if(root == null){
            return false;
        }
        
        if(root.val == k && root != curr){// we need to write root!=curr because since we are searching again from top using root we may encounter the first value we picked again and again choose it as second counter part also ex - try with 1,2,3 and target = 6
            return true;
        }
        
       boolean ans1 =  (root.val > k) && (search(root.left,curr , k));// this short hand notation, since we are doing and , only if root.val > k is true only then it goes to search(root.left , k) to check if its ans
           
           
          boolean ans2 = (root.val < k) && (search(root.right,curr , k)); // similarly if root.val is less than target then go right
        
        
        
        return ans1 || ans2; // return (root->val == value) && (root != cur) || (root->val < value) && search(root->right, cur, value)  || (root->val > value) && search(root->left, cur, value);
        
        // this is like the short hand version of all statemtns in the return statement
            
            
        
        
        
    }
    
}