class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            
            dp[i] = 1;
            count[i] = 1;
        }
        int maxlen = Integer.MIN_VALUE; 
        
        
        
        for(int i=0; i<nums.length ; i++){
            
            for(int j=0 ; j<i ; j++){
                
                if(nums[j] < nums[i]){// checking the number smaller than current number
                    
                    if(dp[j]+1 > dp[i]){ // new max is found
                        
                        dp[i] = dp[j]+1;//update the new max in dp[i]
                        count[i] = count[j];// intitlally there is 1 in all count so its is just copying
                    }
                    
                    else if(dp[i]-1 == dp[j]){//after finding the max len  further we find dp[i]-1 anywhere in the array then just increnmt count, note we are doing dp[i]-1 and checking because dp[i] will have max len till that point including itself                         
                        count[i] = count[i] + count[j];
                    }
                    
                }
                
                
            }
            
            maxlen = Math.max(maxlen , dp[i]);
        }
         int ans = 0;
    for(int i=0;i<dp.length;i++){// find the number of such max length possible and add all their counts
        
        if(dp[i] == maxlen){
            ans = ans + count[i];
        }
        
    }
        return ans;
        
    }
   
    
}