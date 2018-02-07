/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        
        if(l1 == null || l2 == null){
            
            return l1 == null ? l2 : l1;
        }
        
        int carry = 0;
        int sum = 0;
        
        ListNode dummyhead = new ListNode(0);
        ListNode head = dummyhead;
        while( l1 != null || l2 != null ){
            
            //System.out.println(carry + " this is the carry ");
            sum = sum +carry;
           int l1val =  l1 == null ? 0 : l1.val;
           int l2val =   l2 == null ? 0 : l2.val;
            sum = sum + l1val+l2val;
            
            ListNode newnode = new ListNode(0);// create a new node
            head.next = newnode; // attatch it to the head
            head = newnode;// make this new node as the head for the next iteration
            newnode.val = sum % 10;
            carry = sum/10;
            
            //System.out.println(newnode.val + " carry" + carry);
            
            sum = 0;// make sum = 0 for the next iteration
            
               if(l1 != null){ // if already on null dont go further null.next will lead to exceptoion
                   l1 = l1.next;
               }
                if(l2 != null){
                   l2 = l2.next;
               }
            
        }
        
        if(carry != 0){ // if carry is left over add at last 
            ListNode newlast = new ListNode(carry);
            head.next = newlast;
        }
        
        
        return dummyhead.next;
    
        }
}