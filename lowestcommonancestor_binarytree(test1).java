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
    
    
    boolean found = false; 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;
        if(p == null || q == null)
            return null;
            
        TreeNode ancestor = null;
        
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();  
        //findpath(root,p,list1);
        
        found = false;
        
        ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
        findpath(root,q,list2);
        
        Iterator<TreeNode> itr1 = list1.iterator();
        Iterator<TreeNode> itr2 = list2.iterator();
        
        while(itr1.hasNext()){
            System.out.println("list1 value is  " + itr1.next().val);
        }
        while(itr2.hasNext()){
            System.out.println(" list2 value is  " + itr2.next().val);
        }
        
        
        
        
        for(int i=0 ; i< Math.min(list1.size() , list2.size()) ; i++){
            
            System.out.println("here1" +" " + Math.min(list1.size() , list2.size()) +" vlaues are " + list1.get(0).val +" " +list2.get(0).val);
            if(list1.get(i).val == list2.get(i).val){
                System.out.println("here2");
                ancestor = list1.get(i);
            }
        }
        return ancestor;
    }
    
    public void findpath(TreeNode root,TreeNode item ,ArrayList<TreeNode>list){
        if(root == null){
            return;
        }
        
        if(root.val == item.val)
            found = true;
            
        if(!found){
            findpath(root.left , item , list);
        }
        if(!found){
            findpath(root.right , item , list);
        }
        else{
            System.out.println("adding  here to the list"+ root.val);
            list.add(0,root);
        }
        
        return;
    }
}