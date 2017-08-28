class intersectionofnodes{
	
	public static void main(String[] args){
		
	}
	
	public LinkedListNode findpoint(LinkedListNode head){
		LinkedListNode fast = head;
		LinkedlIstNode slow = head;
		
		if(fast =null || fast.next == null) // if its not a loop then return null
			return null;
		while(true){  // when it breaks out the both fast and slow are at the same point and are k steps away from start. 
					 //  For the fast pointer to catch up with slow pointer(intially slow is at start of loop , fast is k steps into the loop or loopsize - k from the behind of the slow node which is at the start of loop). So slow catches up in more (loopsize - k steps) steps.
					 // That means slow pointer travels from start (loopsize - k steps) steps so is at (loopsize - k steps) index positon and that is where they meet. So they slowponter has now only k steps to travel as it has now already travelled loopsize - k steps.
			if(slow == fast){
				break;
			}
			slow = slow.next;
			dast = fast.next.next;
		}
		slow = head;
		while(fast != slow){// when this loop breaks they are at the start of the loop
			slow= slow.next;
			fast = fast.next;
		}
		return slow;
	}
}