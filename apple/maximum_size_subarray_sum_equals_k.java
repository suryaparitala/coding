class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int ans =0;
        if(nums.length == 0){
            return ans;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();// store number of ways to get the current number
        
        map.put(0,1);// to deal with if the number itself is k then k-k = 0 which is 1 way
        
        int sum = 0;
        for(int i=0 ; i<nums.length ; i++){
            
            sum = sum + nums[i];
            
            if(map.containsKey(sum - k)){//if we already have a certain sum we check is map has its counter part if its there get its occurence value
                
                ans = ans + map.get(sum-k);
                
            }
            
            if(map.containsKey(sum)){// keep the sum in the for future counterpart use
                
                map.put(sum,map.get(sum)+1);
            }
        else{// if sum is not there in map add it 
            map.put(sum ,1);
        }
            
            
            
        }
        
        return ans;
        
    }
}