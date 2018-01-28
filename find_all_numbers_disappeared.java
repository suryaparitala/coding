class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
    ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if(nums.length == 0){
            
            return ans;
            
        }
        
        for(int x : nums){
           int temp = Math.abs(x);// since if we the value is neagative then go to index-1 neagate the value at index-1 
            
            if(nums[temp-1] > 0){ // if already the value at index x-1 is negative then leave it , if not negate it
                nums[temp-1] = nums[temp-1] * -1;// negate the value at index x-1
                
            }
            
        }
        
        int index = 0;
        for(int x : nums){
            
            if(x > 0){ // if a postive number found the its corrsponig index+1 value is no there in the list that is why it couldnt be neagted
                
                ans.add(index+1);
                
            }
            
            index++;
        }
       return ans; 
    }
}