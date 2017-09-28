class Solution {
    public int rob(int[] nums) {
//         if(nums.length == 0 ){
//             return 0;
//         } 
//         int max = 0;
        
        
//         int[] dp = new int[nums.length];
        
        
        
        
//         if(nums.length == 1){
//             return nums[0];
//         }
//         if(nums.length == 2){
//             return Math.max(nums[0] , nums[1]);
//         }
        
//         dp[0] = nums[0];// 
//         dp[1]= Math.max(nums[0] , nums[1]);
        
//         int i = 2;
//         while(i < nums.length){// since we are starting from i=2 assign values for dp[0] and dp[i]
            
//             System.out.println(dp[i-1] + " and " + (dp[i-2] + nums[i]) );
            
//             dp[i] = Math.max(dp[i-1] , nums[i]+dp[i-2]);// if he is at some house he choose max between whether to rob the current house and take all the previous i-2 house assets ot is it profitable to rob previous house
//             System.out.println(max );
//             i++;
//             }
        
        
//         return dp[nums.length -1];
        
  
        
// more optimal O(1) space solution
        
        if(nums.length == 0 ){
            return 0;
        } 
        int max = 0;
        
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0] , nums[1]);
        }
        
        int prev = 0;// since at initila case there is nothing to assign so just keep it zero
        int prevprev = 0;
        int val = 0;
        
        int i = 0;
        while(i < nums.length){ // start from 0 and check for all the cases , it will work if we manually assign prev = Math.max(nums[0] , nums[1]) and prevprev = nums[0] and start the while loop from 2. But things will get complicated when doing house robber II where if we dont take prev and prevprev as 0 we need to manually assign them which will be complicated
            
            val = Math.max(prev , nums[i] + prevprev);
            
            prevprev = prev;
            prev = val;
            i++;
            
            
        }
        return val;
        
        
    }
}