class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int count =1;
        
        for(int i=1; i < nums.length ; i++){
            
            if(nums[i-1] < nums[i] ){
                
                count++;
                max = Math.max(count , max);
            }else{
                count = 1;
            }
            
        }
        return max == Integer.MIN_VALUE ? 1 : max;
    }
}