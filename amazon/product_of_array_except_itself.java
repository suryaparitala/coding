class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        
        int[] ans = new int[nums.length];
        if(nums.length == 0){
            return ans;
        }
        
        ans[0] = 1;
        for(int i = 1;i<nums.length;i++){// getting the left product of all the numbers
            
            ans[i] = nums[i-1]*ans[i-1];
            
        }
        
        int right = 1;
        
        
        for(int i = nums.length -1 ; i >=0 ; i-- ){
            
            ans[i] = ans[i]* right;
            right = right * nums[i];
            
        }
        
        return ans;
        
    }
}