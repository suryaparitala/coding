class Solution {
    public void rotate(int[] nums, int k) {// 1,2,3,4,5 and k=2 means rotate two elements from right to left. That is rotate entire array to the right by two steps
        
        if(nums.length == 0){
            return;
        }
        reverse(nums , 0 , nums.length - 1 );//rotate the entire array
        reverse(nums , 0 , k-1);// since we are doing based on index positiosn shift the first two elemtns i.e ot 2-1 elements
        reverse(nums , k , nums.length-1);// reversr the remaining k to nums.length-1 elements
        
    }
    
    public void reverse(int[] nums , int start , int end){// to rotate the array
        
        int temp = 0;
        while(start < end){
            
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
            
        }
        
    }
}