/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // solution first iteration working but too much time 
//     public TreeNode sortedListToBST(ListNode head) {
        
//         if(head == null){
//             return null;
//         }
        
//         TreeNode root = null;
//         ListNode curr = head;
//         int count = 0;
//         while(curr != null){
//             count++;
//             curr = curr.next;
//         }
//         int low =0;
//         int high = count -1;
//         root = build(head , low , high , root);
        
//         return root;
//     }
    
    
//     public TreeNode build(ListNode head , int low ,int high , TreeNode root){
        
//         if(low > high){
//             return null;
//         }
//         int mid = (low + high)/2;
//         ListNode curr = head;
//         int count  = 0;
//         while(count < mid){
//             // System.out.println(mid);
//             count++;
//             curr = curr.next;
//         }
        
//         root = new TreeNode(curr.val);
//         // System.out.println("Created node" + root.val);
        
//         root.left = build(head , low , mid -1 , root.left);
//         root.right = build(head ,mid +1 , high, root.right);
        
//         return root;
        
//     }
    
    
    
        public TreeNode sortedListToBST(ListNode head) {
        
        if(head == null){
            return null;
        }
        
       
       TreeNode root = build(head , null);//since the tail node is null which is the last element
        
        return root;
    }
    
    
    public TreeNode build(ListNode head , ListNode tail){
        
        if(tail == head){
            return null;
        }
        ListNode slowptr = head;
        ListNode fastptr = head;
        while(fastptr != tail && fastptr.next != tail){//   in case of even 1,2,3,4,5,6 if tail is 6 then when we reach 5 the while loop stops as we are checking if fastptr.next != tail or not, so succesfully we will get mid as 3. And in case of odd ex- 1,2,3,4,5 in this case the fastptr exactly stops on last which is 5 so we have mid at 3, but it doesnt matter for odd because we always exclude the last so we technically have only 4 to arrange and in that case mid can be anything 2 or 3 both will give same height irrespective of the arrangement
            
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
        }
        
       TreeNode root = new TreeNode(slowptr.val);
        // System.out.println("Created node" + root.val);
        
        root.left = build(head , slowptr );// since slowptr is alaways pointing to mid
        root.right = build(slowptr.next , tail);//we want mid+1 so slowptr.next
        
        return root;
        
    }
    
    
    
    
}