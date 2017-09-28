class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1){
            
            return nums[0] == target ? 0 : -1;
        }
        
        if(nums.length == 2){
            if(nums[0] == target)
                return 0;
            else if(nums[1] == target)
                return 1;
            else{
                return -1;
            }
        }
        
        int start =0;
        int end = nums.length -1 ;
        
        int ans = search1(start , end , target , nums);
        
        return ans;
        
        
    }
    
    public int search1(int start , int end , int target , int[] nums){
        
        int ans = -1;
        
        int mid = (start + end)/2;
        
        if( target == nums[mid] ){
            
            System.out.println("Found the value at position" + mid);
            ans = mid;
            return ans;
        }
        if(start > end){
            return -1;
        }
        // System.out.println("Now new mid is " + nums[mid]  );
        // if(nums[start] == target || nums[end] == target){ // base case when single elements are left out that is mid and first and last all become the same element ex - [1,3,5] and target = 5 after few recuriosn we get start = 5 and last = 5 
        //     return nums[start] == target ? start : end;
        // }
        // if(mid == start || mid == end){// base case when single elements a
        //     return -1;
        // }
        
        
        
        
        
        if(nums[start]  <= nums[mid]){ // in the smooth zone  0,1,2,3,4 and mid = 2 
         
            
            
            if(target >= nums[start] && target < nums[mid] ){ // check if it is in smooth region
                 // System.out.println("This condition triggerd2 " );
               ans = search1(start , mid -1 , target , nums);// if yes then serach in smooth region by reducing the serch area size
            }
            else{ // if target not in smooth region check other region which is the right half
                
                ans = search1(mid+1 ,end  ,target ,nums);
            }
            
            
        }
        else if(nums[start]  > nums[mid]){ // in the uneven zone which is as [5,1,2,3,4] where start= 5 and mid =2 we see that elemnts after mid are all properly sorted
            
            
            if(target > nums[mid]  && target <= nums[end]){// so check if target is there is ordered region of uneven zone that is between mid and last
             ans =   search1(mid+1 , end , target , nums);// if yes serach in that region by narrowing down the search area
            }
            else{// if target not in that region then search in the unorders zone that is between start and mid-1
                ans =   search1(start , mid-1 , target , nums);
            }
            
            
        }
        
        return ans;
        
        
    }
}