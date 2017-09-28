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

        List<List<Integer>> anslist = new ArrayList<List<Integer>>();// since list is a interface we cant instantiate it, so make the outer conrainer an arraylsit or a linked list and again internally keep it as a list and then assign internal list to what ever you want like in this case i made it to LinkedLsit


        // why unable to use List<ArrayList<Integer>> anslist = new ArrayList<ArrayList<Integr>>();dont know why this is not compatible with List<List>

        if(root == null){
            return anslist;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();// unclear why que is based on linked list
        int level = 1;
        que.add(root);
      LinkedList<Integer> levellist = new LinkedList<Integer>();
        while(!que.isEmpty()){

            int size = que.size();

            for(int i=0; i< size ; i++){

                TreeNode temp = que.poll();
                levellist.add(temp.val);
                if(temp.left != null){
                    que.add(temp.left);
                }
                if(temp.right != null){
                    que.add(temp.right);
                }
            }

             anslist.add(new LinkedList(levellist));// now since i am creating a new linked list and adding what ever i do with levellist will not effect my Linkedlist in the final anslist
            level++;
            levellist.clear();//clearing the linkedlist to be used in the next iteration

        }
        return anslist;

    }
}
