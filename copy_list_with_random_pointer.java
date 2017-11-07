/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head == null){
            return null;
        }
        
        RandomListNode curr = head;
        HashMap<RandomListNode , RandomListNode> map = new HashMap<RandomListNode , RandomListNode>();
        
        while(curr != null){ // store old and new node
            
            map.put(curr , new RandomListNode(curr.label));// for each node create a corresponding new listnode
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr != null){// again traverse all the old list nodes
            
            RandomListNode temp = map.get(curr);// get the new node associated with the old node
            temp.next = map.get(curr.next);//  ex - if curr.next is pointing to some node 3 then get the eqivalent new node for the corresponig old node 3 from the map
            temp.random = map.get(curr.random);// do it similarly for the random pointer
            
            curr = curr.next;
            
        }
        
        return map.get(head);
        
    }
}