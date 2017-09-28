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
    public int findBottomLeftValue(TreeNode root) {
        
        int ans = 0;
        if(root == null){
            return ans;
        }
        
        
        
        
  // solution 1      
        
//         Queue<TreeNode> que = new LinkedList<TreeNode>();//  
//         int level = 1;
//         que.add(root);
//         ArrayList<Integer> levellist = null;
//         TreeNode temp = null;
      
//         while(!que.isEmpty()){
//              levellist = new ArrayList<Integer>();
//             int size = que.size();
            
//             for(int i=0; i< size ; i++){
                
//                  temp = que.poll();
//                 levellist.add(temp.val);
//                 if(temp.left != null){
//                     que.add(temp.left);
//                 }
//                 if(temp.right != null){
//                     que.add(temp.right);
//                 }
                
//             }
             
    
//         }
//         // System.out.println(temp.val);
//         return levellist.get(0);// just do a normal bfs or level order traversal and extract the first element in the last row, modifiaction would be that evertime create a new linekdlist levelist to overwrite the previous one 
        
        
        
   // more efficient solution - if we observe we are adding elements left to right into the templist becuase we adding left first and then adding right leaf elements. If we reverser the order and add the right elements first and then next left our temp will eend up at left most root of last row which is what we need     
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();//  
        int level = 1;
        que.add(root);
        
        TreeNode temp = null;
      
        while(!que.isEmpty()){
             
            int size = que.size();
            
            for(int i=0; i< size ; i++){
                
                 temp = que.poll();
                
                
                if(temp.right != null){// first add right elements and then left so that left is left at last in the temp variable
                    que.add(temp.right);
                }
                if(temp.left != null){
                    que.add(temp.left);
                }
                
            }
             
    
        }
         System.out.println(temp.val);// by doing so we are avoiding the overhead of stroing the entire last row and extracting the lest most element in the last row.Since we are adding first right leaves and then left leaves we end having leftmost leaf in last row stored in temp 
        return temp.val;
       
    }
}