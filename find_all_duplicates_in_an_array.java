// faster approach , keep negating  val-1 indexes and the val that is +ve has two repeati
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(nums.length == 0){
            return ans;
        }
        
        int index = 0;
        for(int x : nums){
            
            int temp = Math.abs(x);
            
            if(nums[temp - 1] < 0 ){ // if we are revisitng a -ve val then its temp-1 is a repeat
                ans.add(temp-1 + 1);// since temp-1 is the index of +ve value and hence its actula value is  its index index+1 that is temp-1 +1 
                
                
            }
            nums[temp-1] = nums[temp-1]*-1; 
            
            
            index++;
        }
        
        return ans;
        
    }
}





// own solution

class Solution {
    
          
    public List<Integer> findDuplicates(int[] nums) {
        
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if(nums.length == 0){
            
            return ans;
        }
        
        for(int x : nums){
            
            int temp = Math.abs(x);
            if(nums[temp-1] > 0){
                
                nums[temp-1] = nums[temp-1] * -1;
                
            }
            
        }
        int index = 0;
        for(int x : nums){
            
            if(x>0){
                ans.add(index+1);
            }
            
            index++;
        }
        
        
        
        
        for(int i=0;i<nums.length ;i++){// reset all nums to +ve
            
            nums[i] = Math.abs(nums[i]);
            
        }
        
        
        // now using missing number and all the nums in the array negate everyting to find double negated elements
        

        for(int i = 0 ; i < nums.length ; i++ ){
            
            int val = Math.abs(nums[i]);
            int val2 = nums[val-1]*-1;
           nums[val-1] = val2;
        }
        
        for(int x : ans){// neagte the index postions of missing values 
            
            int temp = Math.abs(x);
            nums[temp-1] = nums[temp-1] * -1;
            
        }
        ans.clear();
        
        index = 0;
        for(int x :nums){// find the +ve numbers and add thier index+1 to ans list
            
            if(x>0){
                ans.add(index+1);
            }
            index++;     
        }
        
        
       return ans; 
        
        
        
    }
}