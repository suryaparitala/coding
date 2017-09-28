class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     
        int k = m+n -1;
        int i= m-1;
        int j = n-1;
        
        
        
        while(  i >= 0  && j >= 0 ){ // make sure to keep both i && j more than zero. If m=0 then i will be -1 .in that case dont enter the loop
            
            
            if(nums1[i] > nums2[j]){
                
                nums1[k] = nums1[i];
                k--;
                i--;
                
            }
            else{
                
                nums1[k] = nums2[j];
                k--;
                j--;
            }
            
        }
       
            
            while( j>=0 ){ // if both i is zero and we still have j copy elements from second array to the first
            nums1[k] = nums2[j];
            j--;
            k--;
        } 
        
        
        
    }
}