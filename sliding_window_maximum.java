class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - (k-1)];// since we going window wise always the last k-1 elements are not covered 
        int j=0;//just a index to traverse over ans array
        if(k==0 ){
            return nums;
        }
        if(nums.length == 0){
            return ans;
        }
        
        Deque<Integer> q = new ArrayDeque<Integer>();// can also do Deque<Integer> q = new LinkedList<Integer>()
        
        for(int i =0;i<nums.length;i++){
            
            while(!q.isEmpty() && q.peek() < i-(k-1)){// if window is k=3 the and we are currently at i=5 we only need to care about previous 2 elements i.e elements at index 5,4,3 so so make sure that all the other elements are removed
                q.poll();
                
            }
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){// if the new element is greater than the older elements in the queue then the older element is useless as it will be domniated by new element alwasy so its redundant hence remove it. Check this for all the older elements 
                q.pollLast();
                
            }
            
            
            q.offer(i);// alwasys dont neglect to add new element into the queue beacuse even if it is smallest so far in future it might be the biggest
            
            if(i >= k-1){// after k-1 each increment of i will form a new window, and since alwasys the maximum of that window is stored at first we add it to the ans
                ans[j++] = nums[q.peek()];// since we are handling indexes not numbers
            }
        }
       return ans; 
    }
}