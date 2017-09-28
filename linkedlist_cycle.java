/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null ){
            return false;
        }
        
        ListNode slowptr = head;
        ListNode fastptr = head;
        
        while(fastptr != null && fastptr.next != null ){// if the fastptr is on null then dont go further and if fastptr.next is null then we are on the last node so dont go further, this is similar to if slowptr!= null or slowptr.next!= null
            
            
            
            
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if(slowptr == fastptr){// dont do slowptr.val == fasrptr.val because if fastptr is null then null.val will give error
                return true;
            }
            
            
            
            
        }
        
        return false;
    }
}