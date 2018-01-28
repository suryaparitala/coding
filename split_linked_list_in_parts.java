/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        
        ListNode[] anslist = new ListNode[k];
        
        if(root == null){
            return anslist;
        }
        
        ListNode temp = root;
        int len = 0;
        
        while(temp != null){
            
            temp = temp.next;
            len++;
        }
        
        int div = len / k;
        int rem = len % k;
        
        ListNode prev = null; 
        ListNode curr = root;
        
        for(int i=0 ; i < k ;i++ ,rem--){
            
            
            ListNode head = curr;
            ListNode first = curr;// to store the location of first node as it is stored in the array
            
            for(int j = 0; j < div + (rem > 0 ? 1 : 0) -1; j++){// we do -1 because if 1->2->3 we can reach to 3 in 2 steps
                
                if(head != null){
                    head = head.next;
                }
            
            }
            
            if(head != null){ // af the for loop is over its time to start a new list, so prepare the curr for next iteration
           // System.out.println(head.val);
            
            curr = head.next;// move curr to next elemetn for next iteraiton
            head.next = null;//since head is now pointing to last element on the list make it null
            anslist[i] = first;
            }
            
        }
        
        return anslist;
        
        
        
    }
}