/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // using recursion
//         if(l1 == null ){
//             return l2;
//         }
//         if(l2 == null){
//             return l1;
//         }
        
//         ListNode temp;// create a temp node
        
//         if(l1.val <= l2.val ){// choose the least one among the two nodes and assign it to temp, push list head corresponding to least element to the next  
            
//             temp = l1;
//             l1 = l1.next;
//            temp.next =  mergeTwoLists(l1,l2);// now do newleast.next = recrive using updated lists
            
//         }
//         else{
            
//             temp = l2;
//             l2 = l2.next;
//             temp.next = mergeTwoLists(l1,l2);
//         }
        
//         return temp;
//     }
        
 
    // iterative approach
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
       if(l1 == null){
           return l2;
       }
        if(l2 == null){
            return l1;
            
        }
        
        ListNode head;
        if(l1.val < l2.val){
            
            head = l1;
        }
        else{
           head = l2;
            l2 = l1;
            l1 = head;
            
            
        }
        
        
        
        
        while(l1.next  != null && l2 != null){// loop breals when l2 is null or l1.next is null , this is because we are comparing l1.next.val with l2 so we dont want the l1 to reach null
           
            if(l1.next.val < l2.val){
                
                l1 = l1.next;
            }
            else{
                
             ListNode  afterl1 = l1.next; // preserving lists after l1 and l2  
             ListNode   afterl2 = l2.next;
                
                l1.next = l2;// now re assignng the pointers l1.next is pointed to new low
                l2.next = afterl1;// l2.next is again mergerd with the l1
                
            //     if (l2.next != null) {
            //     l2 = afterl2;
            // }
                l2 = afterl2;// now again make l2 as afterl2 for future purposes
                
            }
            
            
            
            
            
            
        }
       
       
       if(l1.next == null && l2 != null)// finally after the while loop exist if at all there are elements left over in l2 we just append them to l1.Note by the time l1 reaches its end all the l1 nodes are properly sorted
        l1.next = l2;
       
       return head;
   }      
        
}