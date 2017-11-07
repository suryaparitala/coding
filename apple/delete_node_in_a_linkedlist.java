/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
        
        ListNode* nextele = node->next; // in node->next is of type  pointer so declare our nextele as a pointer, we are string nextele so that we can free it in future
        
        node->val = nextele->val;// copy the values
        node->next = nextele->next;//copy yhe next pointer
        
        free(nextele);// free it
        
        
        
    }
    
    
};

// java solution
class Solution {
    public void deleteNode(ListNode node) {
        
        node.val = node.next.val;
        node.next = node.next.next;
        
        return;
        
        
    }
}