class Solution {
    public int[] findErrorNums(int[] nums) {
        
        
        int[] ans = new int[2];
        if(nums.length == 0){
            
            return ans;
        }
        int rep = 0;
        boolean repfound = false;
        
        for(int x : nums){// make negative at val - 1 index 
            
            x = Math.abs(x);
            int index = x-1;
            
            if(!repfound && nums[index] < 0 ) { // if something is already negative it means it has been visited before, so the x is the repeating item(because we are coming to that index by doing x-1)
                
                rep = x;
                repfound = true; // once the repetaing element is found, dont again check for -ve again as it is unnecessary checks
                
            }
            if(nums[index] > 0){ // simultanesouly keep negating the visitned elements
                nums[x-1] = -1*nums[x-1];
                
            }
        }
        
        int missing = 0;
        int index = 0;
        for(int x : nums){ // in this loop check if something is +ve, if its is +ve then it is unvisited , so the the value that brings to that index is missing 
             
            if(x > 0){
                missing = index+1;
                break;
            }
            
            index++;
            
        }
        
        ans[0] = rep;
        ans[1] = missing;
        return ans;
        
        
        
    }
}