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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        ArrayList<List<Integer>> anslist = new ArrayList<List<Integer>>();
        if(root == null){
            return anslist;
        }
        ArrayList<Integer> list = new ArrayList();
        pathsum1(root , sum ,0 ,list ,anslist);
       // System.out.println(anslist);

    return anslist;        
    }
    
    public void pathsum1(TreeNode root , int targetsum ,int currentsum , ArrayList<Integer> list , ArrayList<List<Integer>> anslist){
        
        if(root == null)
            return;
        currentsum += root.val;
        list.add(root.val);
        
        if(currentsum == targetsum){
            if(root.left == null && root.right == null){
                // System.out.println("WHILE ADDING TO FINAL ANS");
                // System.out.println(list );
               
                anslist.add(new ArrayList<Integer>(list)); // why should i create new linked list isnt java call by refernce also i am not changing anything for anslist in future iterations but why is it changing??
                //  System.out.println("added to anslist");
                //   System.out.println(anslist);
                
            }
        }
        
        
        pathsum1(root.left , targetsum ,currentsum ,list ,anslist);
        pathsum1(root.right , targetsum ,currentsum ,list , anslist);
        
        //System.out.println(list + "before");
        list.remove(list.size()-1);
        //  System.out.println("printing ans list");

        //  System.out.println(anslist);

        // System.out.println(list + "after");
        
    
        
        return;
    }
}