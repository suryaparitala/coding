/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null){// makes sure the least we divide is only a list with one node , this is the point upto which the division of linkedlist occurs. Also when base case reaches return head not null
            return head;
        }
        
        ListNode mid = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast!= null && fast.next!= null){
            
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            
            
        }
        mid = slow;
        prev.next = null;// cut the linkedlist into two by adding null to the node before mid 
        
        ListNode l1 = sortList(head);// dividing the main array to two sub lists with head and mid
        ListNode l2 = sortList(mid);
        
        ListNode newhead = merge(l1,l2);// this will first happened when l1 and l2 have only 1 node or no nodes in their list. After that the nodes become accumailated and will get merged
        
        return newhead;
        
        
        
    }
    
    public ListNode merge(ListNode h1 , ListNode h2){
        
        ListNode tempfirst = new ListNode(-1);// some temp node which will be used as head for the resultant node and then be discarded
        
        ListNode curr = tempfirst;// reference to tempfirst on using which we can perform operation,since at the last we return tempfirst.next we want to the refernce to tempfirst intact
        
        
        while(h1!= null && h2 != null){// keep and because the while loop must stop if any one fails
         
            if(h1.val < h2.val){
                
                curr.next = h1;
                curr = curr.next;//move over and make curr ready for the next iteration
                h1 = h1.next;
                
            }
            else{
                
                
                curr.next = h2;
                curr = curr.next;
                h2 = h2.next;
            }
            
        }
        
        if(h1 != null){ // after the while loop if h1 exists it means we have exhauted h2 but not h1. Also note that we are using if not while as in case of arrays because in LinkedList everything is pointers so we just have to change the pointer
            
            curr.next = h1;
            
        }
        
        if(h2 != null){// only one of the if loop will happen either h1 is null or h2 is null . Not both
            
            curr.next = h2;
        }
        
        return tempfirst.next;// since we appended everything to a dummy node in the start
        
        
        
        
        
    }
}