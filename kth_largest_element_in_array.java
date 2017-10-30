class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        int lo = 0;
        int hi = nums.length-1;
        
        k = nums.length - k;//index position that we need to find
        while(lo < hi){
            
             int j = partition(nums , lo , hi);
            
            if(j < k){// need to find 6 the index but found 4 th index
                
                lo = j+1;
            }
            else if(j > k){// need to find 6 th index but found 8 th index
                
               hi = j-1; 
            }
            else{//this is the case when we actually found the index
                break;
            }
            
        }
        return nums[k];
        
    }
    public int partition(int[] nums , int lo , int hi){
        int i = lo;// need not compensate because choosing lo as the pivot so not an issue if we skip ot while doing ++i
        int j = hi+1;//doing hi+1 to compensate for adjsutment in while loop where we are starting from --j
        
        while(true){
            while(i<hi && nums[++i] < nums[lo]);
            while(j>lo && nums[--j] > nums[lo]);
            
            if(i>=j){
                break;
            }
            swap(nums,i,j);
            
        }
        swap(nums,lo,j);//keep lo to its actual place in the array after partitioning
        
        return j;
        
        
    }
    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}