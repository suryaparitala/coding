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
        
        
        int count = 0;
        ListNode last = head;
        ListNode curr = head;
        while(curr != null){
            last = curr;
            curr = curr.next;
            count++;
        }
        k = k % count;// to deal with situtaiosn where k is more than count ex- k = 3 ,count = 2 in this case our net rotation = 1 because after rotation the length we get back the same list
        
        
        int shiftat = count - k;// the point where shift occurs , sice we are removing k nodes from right and moving to left, the roation occurs at count - k
        if(count == 1 || k == 0  || shiftat == 0){// when number of nodes is 1 and rotations are zero just return the head,also if shift at is zero it menas even after rotation it will look the same
            return head;
        }
        // System.out.println(shiftat);
        
        int i =0;
        ListNode newstart = head;
        ListNode newend = head;
        while(i < shiftat){// traverse to the point of shift , the node at the point of shift will be the new head and the element before it will be the new tail. 1,2,3,4,5,null k= 2 point of shift at index 5-2=3 so new head will be 4 and new tail will be the element before it i.e 3 
            newend = newstart;
            newstart = newstart.next;
            i++;
        }
        // System.out.println(" newstart " + newstart.val);
        // System.out.println(" newend " + newend.val);
        // System.out.println(" last " + last.val);
        newend.next = last.next;// assign new tail to null
        last.next = head;// assign old tail to head 
        head = newstart;//assign new start to head
        
        return head;
    }
}