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
    public ListNode detectCycle(ListNode head) {
        
        /* therory l1 = distance from start to the start of the loop
         l2 = distance from start of loop to meeting point
         distance traveeled by slow = l1 + l2;
         dsitance travelled by fast = l1 + l2 + n*c where c = lenght of ciricle and n = number of times it travelled;
         Since fast ptr is twice as fast as slow we have 2*(l1+l2) = l1+ l2 + nc ; we will be left with l1 + l2 = nc ; l1 = nc - l2 ; l1 = (n-1)c + (c - l2) now since (n-1)c is all full circles just ignore it we have c-l2 which is what is left after travelling l2*/
        
        if(head == null){
            return null;
        }
        
        ListNode fast =head;
        ListNode slow = head;
        ListNode meet = null;
        
        while(fast != null && fast.next != null){// finding the meeting point 
            
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow){
                meet = slow;
                break;// must keep break beacuse if there os no break the while loop will never stop and keep going
            }
        }
        // if(meet != null )
        // System.out.println(meet.val);
        if(meet == null){// if we did not find any meet then return null
            return null;
        }
        slow = head;
        fast = meet;
        while(slow != fast){
            
            fast = fast.next;
            slow = slow.next;
            
            
        }
        
        return slow;
        
    }
}