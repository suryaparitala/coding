class Solution {
    public int[] plusOne(int[] nums) {
        
        if( nums.length == 0){//if length is zero then return the nums
            
            return nums;
            
        }
        
        for(int i = nums.length -1 ; i >= 0 ; i--){ // iterate from last
            
            if(nums[i] < 9){// if a number is less than 9 then if we add it 1 to it we get no carry so just return
                
                nums[i]++;
                
                return nums;
            }
            
            else{//else not needed because since we are using return in the if case it directly acts like a if else
                nums[i] = 0;// if a number is greater than 9 then adding 1 will make it zero
            }
            
            
            
        }
        
        int[] ans = new int[nums.length + 1];// if even after the whole for loop the ans is not retunred then it means we have something like 9999 and we need to 1 ourselves manually
        ans[0] = 1;
        
        return ans;
        
        
        
        
        
    }
}