/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null){
            return null;
        }
        
        ListNode curr = head;
        int len =0;
        ListNode tail = null;
        while(curr != null){
            
            tail = curr;
            curr = curr.next;
            len++;
            
        }
        
        
        k = k % len; // if k more than len then instead of going a complete cycle we can skip
        tail.next = head;// form a cycle
        
        
        for(int i=0;i < len - k ;i++ ){// rotate cycle len - k times, move the tail pointer the reamining len - k times
            
            
            tail = tail.next;
            
        }
        
        ListNode newhead = tail.next;// the next val afthe the tail is the new head
        tail.next = null;//break the cycle
        
        return newhead;
        
    }
}