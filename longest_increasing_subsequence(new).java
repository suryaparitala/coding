class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return 1;
        }
        
        int[] dp = new int[nums.length];
        
        for(int i=0;i<dp.length ;i++){// initialize the array to 1
            dp[i] = 1;
            
        }
        int max = Integer.MIN_VALUE;
        
        for(int i=1;i < nums.length;i++){// start from i=1 as we know at index 0 the longest length is 1
            
            int local = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){// starting from 0 till index i  
                
                if(nums[j] < nums[i] ){ // checking all the small number before nums[i]
                    
                    local = Math.max(dp[j],local);// among the all the numbers smaller than curret number check which has highest length and that is stored in local
                    
                }
                
            }
            
            dp[i] = local == Integer.MIN_VALUE ? 1 : local+1;// if local is still min_value no suitable found so just keep 1 else do local+1 because the length till that point + adding current number to the increasing list  
            
            
           max = Math.max(max , dp[i]); 
        }
        
        
        
        return max;
    }
}