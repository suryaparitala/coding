/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode first_even_node = head.next;
        ListNode evenhead = head.next;
        ListNode oddhead = head;
        
        
        while(evenhead != null && evenhead.next != null){// we only need to check even nodes because odd is always behind even, so if even stops then odd stops right behind it
            
            oddhead.next = oddhead.next.next;// skip the next node and assign them to the next
            evenhead.next = evenhead.next.next;
            
            oddhead = oddhead.next;//move the oddhead so that it is ready for the next iteartion
            evenhead = evenhead.next;// move the evenhead so that it is ready for the next iteration
            
        }
        
        oddhead.next = first_even_node;// assign the first even node to the tail of the odd node
        
        return head;
    }
}