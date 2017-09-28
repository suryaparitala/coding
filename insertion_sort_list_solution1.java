/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {// insertion sort is wall method
        
        if(head == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode walllast = head;
        ListNode wallfirst = head;
        
        while(curr != null){
            
            if(walllast.val <= curr.val){
                
                walllast = curr;// just increase the wall and move
                curr = curr.next;
            }
            else{
                
                ListNode temp = wallfirst;// assigning random node to iterate from the start and compare
                ListNode prev = null; // keep a track of the previous pointer 
                while(temp.val <= curr.val ){// the while loop will exit once we reach a bigger elemnt that curr and prev will point to the node before it
                    prev = temp;
                    temp = temp.next;
                    
                }
                
                if(prev == null ){
                
                    prev = new ListNode(-100);// if prev is null it means curr must be inserted before the starting node, hence create a fake prev and insert it. Also finally after we insert a new node after fake prev make the curr that we recently inseted in the beginning of the list as the new wallfirst
                    walllast.next = curr.next; // jumping over curr and making curr next walllast's next
                    prev.next = curr;// making curr the tail of prev
                    curr.next = temp;// making temp the tail of curr

                    curr = walllast.next;// preparing current for the next iteration
                    wallfirst = prev.next;// Also finally after we insert a new node after fake prev make the curr that we recently inseted in the beginning of the list as the new wallfirst
                    
                    
                }else{
                    
                    walllast.next = curr.next; // jumping over curr and making curr next walllast's next
                    prev.next = curr;// making curr the tail of prev
                    curr.next = temp;// making temp the tail of curr

                    curr = walllast.next;// preparing current for the next iteration
                }
                
                
            }
            
            
        }
        
        return wallfirst;
        
    }
}