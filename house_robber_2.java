class Solution {
    public int rob(int[] nums) {
        
        
        if(nums.length == 0){
            return 0;
            
        }
        
        
        return Math.max(rob1(nums, 0 ,nums.length-1) , rob1(nums,1,nums.length));// choose max among two things i.e excluding first house or exluding last house. since the pattern is circular we cant choose both first and last house
    }
    
    public int rob1(int[] nums , int start ,int end){// same as house robber 1 only differnce is that we are passing start and end
       
        if(nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums.length == 2){
            return Math.max(nums[0] , nums[1]);
        }
        
        int prevprev =0;
        int prev =0;
        
        
        
        int temp = 0;
        
        while(start < end){
            
            temp = Math.max(prev , prevprev + nums[start]);
            prevprev = prev;
            prev = temp;
            
            
            start++;
            
        }
        
        
        return temp;
        
        
    }
    
    
    
}