public class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        // n^2 appraoch
//         int ans =0;
//         if(nums.length == 0)
//             return ans;
//         int currmin = Integer.MAX_VALUE;
//         for(int i=0; i< nums.length -1;i++){
//             int sum = nums[i];
//             if(sum >= s){
//                     currmin = Math.min(currmin , 1); 
//                     continue;
//                 }
//             for(int j= i+1; j<nums.length ; j++){
                
                
                
//                 sum = sum + nums[j];
                
//                 if(sum >= s){
//                     currmin = Math.min(currmin , j-i+1); 
//                     continue;
//                 }
//             }
//         }
//         return currmin == Integer.MAX_VALUE ? 0 : currmin;
        
        // o(n) appraoch
        
        int sum =0;
        int ans =0;
        int currmin = Integer.MAX_VALUE;
        if(nums.length == 0 )
             return ans;
        int j=0; // it is at the left most point and is moved to right if sum is more than the required target
        for(int i=0; i< nums.length ; i++){
            
            sum = sum + nums[i];// keep. moving i to the right 
            
            while(sum >= s){
                currmin = Math.min(currmin , i-j+1);// store the min number of elements which satisfy the condition
               sum = sum - nums[j++];// since sum is >= the target move the left most pointer to right to check if any other possiblities exist.If not just continue moving the i pointer to the right. 
                
            }
        }
        
        return currmin == Integer.MAX_VALUE ? 0 : currmin; // if there is no subarray which >= target we are left with curr as the MAX_VALUE but we must return 0 not MAX_VALUE so put a condition and check.
        
        
    }
}





