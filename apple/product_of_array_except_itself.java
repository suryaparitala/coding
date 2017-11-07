class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        
        
        ans[0] = 1;// because left of first number is nothing so keep 1
        
        for(int i=1;i<nums.length;i++){
            
            ans[i] = ans[i-1]*nums[i-1]; 
        }
        
        // now to find the right products
        
        int right = 1;
        for(int i= nums.length -1 ; i >= 0 ; i-- ){
            
            ans[i] = ans[i]*right;
            right = right * nums[i];// make right ready for the next iteration
            
            
            
        }
        
        return ans;
        
    }
}