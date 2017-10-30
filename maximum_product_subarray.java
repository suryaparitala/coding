class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
         int res = nums[0];//intitially asuume the final ans as nums[0]
        
        cont[] dp = new cont[nums.length];// make dp array of the type cont to store max and min details
        
        dp[0] = new cont(nums[0],nums[0]);//since for the first element nums[0] both the max and min is itself
        
        
        
        for(int i = 1 ; i < nums.length ; i++){
            
            dp[i] = new cont(0,0);// create a dummy and then assign actual values
            
           
                dp[i].max = Math.max( Math.max(nums[i]*dp[i-1].max , nums[i]*dp[i-1].min ), nums[i]);//assign dp[i].max to  the max among the bunch, i.e multiply the previosu dp[i-1].max and dp[i-1].min with current number and take the max, by doing so even if both -ve the mulplied new result which is +Ve goes to max, also keep nums[i] because if old is 0 then we dont want to leave nums[i], ex  [0,2] dp[i-1] = [max = 0 ,min =0] multiply anythin with it will give zero , so also keep nums[i]
                dp[i].min = Math.min(Math.min(nums[i]*dp[i-1].max , nums[i]*dp[i-1].min ), nums[i]);
            
                res = Math.max(res , Math.max(dp[i].max , dp[i].min));//choose the final max
            System.out.println(dp[i].min + " and " + dp[i].max + " and res " + res );
        }
        
        return res;
        
    }
    
    
}
class cont{ // container to store max and min values after multiplying with each number in nums[] array
    
    int max = 1;
    int min = 1;
    public cont(int max , int min ){
        this.max = max;
        this.min = min;
        
    }
}