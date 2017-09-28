/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode head = null ;// instance and static variables can be let left uninitialized which will take default values
    public boolean isPalindrome(ListNode head) {
        
        this.head = head;
        if(head == null){
            return true;
        }
        ListNode curr = head;
        
        
        int nodes = 0;
        while(curr != null ){ // to count number of nodes
        
        nodes++;
        curr = curr.next;
            
        }
        
        int lastindex = nodes -1;// last index is 1 less than number of nodes
        
        int revnodeindex = (lastindex/2) + 1;// the value if node to be reversed a,b,c,b,a we only reverse the nodes after c and check 
        
        
        ListNode revhead = head;
        ListNode revheadprev = null;
        int index =0;
        while(index < revnodeindex){ // compute the head from which things are to be reversed. Also we keep track of revheadprev the node before the revhead so that after getting a new head after reveresal we can append it
                revheadprev = revhead;
                revhead = revhead.next;
                index++;
            }
        ListNode newrevhead = revlinkedlist(revhead);// a new head is returned after reversal
        
        revheadprev.next = newrevhead;// assign the newhead returned after reversal to its previous nodes next
        
        ListNode slowptr = head;// start of the list
        ListNode fastptr = newrevhead;// it is the point from where linkedlist was reversed
        
        while(fastptr != null){
            
            if(slowptr.val != fastptr.val){
                return false;
                
            }
            slowptr = slowptr.next;
            fastptr = fastptr.next;
            
        }
        
        
        
        return true;
        
    }
    
    
    public ListNode revlinkedlist(ListNode revhead){// to reverse the head and return the new head
            
            ListNode curr = revhead;
            
            
            
        ListNode prev = null;
        ListNode next = null;
        while(curr != null ){
            
            next = curr.next;// safely store the curr.next node in next as we are now changing curr.next to a new node
            curr.next = prev;// point curr.next to a new node which is the one behind it
            prev = curr;// to move forward make prev as current and current as next
            curr = next;
            
        }
        
        return prev;
        
        
            
            
            
        }
        
}