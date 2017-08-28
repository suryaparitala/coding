public class Solution {
    public int lengthOfLIS(int[] nums) {
		
		
		if(nums.length == 0){
			return 0;
			
		
		int[] count = new int[nums.length]; // to keep track of  increasing sequence length upto that point/index
		for(int i=0 ; i< increasing_count.length ; i++)
			count[i] = 1; // because by default all elements are of increasing subsequence of length 1
		}
		
		for(int i= 1 ; i< nums.length ; i++){ // for each i start from j=0 always and compare
			for(int j= 0 ; j< i ; j++){
				if(nums[i] > nums[j] )// if the number before it is less
					count[i] = Math.max(ans[j]+1 , ans[i]);// choose the max among the two , i.e 1+ (the lesser numbers count contribution ) and our old increasing subsequnce length. Also we are adding 1 in 1+ (the lesser numbers contribution ) because that 1 represents adding our current number with which we are comparing j that is ellement i to the increasing sequence list.
			}
		}
		int ansval =0;
		for(int i=0;i< count.length ; i++){// loop and choose the biggest number from the count table.
		            if(count[i] > ansval){
		                ansval = count[i];
		            }
		        }
	   return ansval; 
	}
	}