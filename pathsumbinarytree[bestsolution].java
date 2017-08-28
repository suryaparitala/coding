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
    public int pathSum(TreeNode root, int sum) {
        
        int count =0;
        if(root == null)
            return count;
        HashMap<Integer , Integer> map = new HashMap();
        map.put(0,1);
        count = pathsum1(root , sum , 0 , map);
        
        return count;
        
    }
    
    public int pathsum1(TreeNode root , int targetsum ,int currentsum , Map<Integer,Integer> map){
        int count =0 ;
        
        if(root == null){
            return count;
        }
        
        currentsum = currentsum + root.val;
        
        // also first check if curr - target there in hashmap and then add currsum to hashmap or else it will lead to discrepencies. As for a given currsum the map should store all the values behind it not ahead of it or along with it. 
        
        if(map.containsKey(currentsum - targetsum)){ // if map contians the subtracted value then add count 
            System.out.println("Matched " +" and netsum value there is " + map.get(currentsum - targetsum));
            
            
            if(map.get(currentsum - targetsum) > 0 ){
                System.out.println(currentsum + " at this place count is increased " + map.get(currentsum - targetsum));
                count += map.get(currentsum - targetsum); // we do map.get(currentsum - target ) instead of count++ because we want to conisder all possilble paths that gave (currentsum - targetsum) . Better understood with this exmaple [5,-5,null,5,4,8,11,null,13,4,7,2,null,null,5,1] and sum = 22 , in this case for 27 we have 5 in hashmap which has 2 path. One path is 5 and other path is 5,-5,5. Both of which lead to subtracted from 27 lead to 22.
                
                
                
                //map.put(currentsum - targetsum , map.get(currentsum - targetsum) - 1 ); no need to do this we need not decrease the currentsum - target sum , the deletion part or clean up for next set of nodes is done at the last
            }
        }
        
        if(map.containsKey(currentsum)){ // if it contains key then add it to the current value
            map.put(currentsum , map.get(currentsum)+1);
        }
        else{
            map.put(currentsum , 1);
        }
        System.out.println(currentsum+ " " +  map.get(currentsum));
        
        
        
        // if(currentsum == targetsum){ // some random shit
        //     count++;
        // }
        count += pathsum1(root.left , targetsum , currentsum , map);
        count += pathsum1(root.right , targetsum , currentsum , map);
        
        System.out.println("remove " + currentsum);
        map.put(currentsum , map.get(currentsum) -1); // undo work for set of nodes , after a left node and right node is done just remove the current sum so that it doesnt effect the count in some other path
        return count;
    }
    }