class Solution {
    public void moveZeroes(int[] nums) {
        
        if(nums.length == 0){
            return;
        }
        
        int index = 0; // to keep  a track of the postion.
        
        for(int i=0; i< nums.length ; i++){// find the non zero element and keep placing it at index positon and increment index
            if(nums[i] != 0){
                
                nums[index++] = nums[i];
                
            }
        }
        for(int j= index ; j< nums.length ; j++){// the left over index places fill with zero
            nums[j]=0;
        }
        
        
        return;
    }
}