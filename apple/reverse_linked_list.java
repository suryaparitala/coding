/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode dummy = new ListNode(0);// create a dummy head and pass
    
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode ans = helper(head);// call helper dunction
        ans.next = null;
        
        return dummy.next;// remove the dummy
        
    }
    
    public ListNode helper(ListNode head){
        
        if(head == null){// when null encounterd then dummy head is passed
            return dummy;
        }
        
        ListNode newnode = new ListNode(head.val);// in every recuriosn a new node is made and it is attached to the next of retured node 
        
        ListNode revnode = helper(head.next);// the returned node will be the new head
        
        revnode.next = newnode;// the next of retured node is the new node
        
        return newnode;
        
        
        
        
    }
}