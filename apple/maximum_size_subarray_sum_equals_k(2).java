class Solution {
    public int maxSubArrayLen(int[] nums, int k) {// small tweak for Subarray Sum Equals K instead of keeping count in this problem keep index
        
       int max = 0;
        if(nums.length == k){
            return max;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();// to store sum and its corresponding index
        //map.put(0,0);//donot keep value at 0 as 0 as some other position may have a 0 value 
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            
            sum = sum + nums[i];// sum till index i
            
            if(sum == k){
               max = Math.max(max,i+1); // i.e the sum upto now is k without any counter part needed so it is total array till i 
            }
            
            if(map.containsKey(sum - k)){// if map has the counter part get the index position
               
                int len = (i- map.get(sum-k));// number of elements between the current index and the counter parts index
                
                max = Math.max(max ,len);
                
                //System.out.println("max is "+ max +"at " + i + "and "+ map.get(sum-k));
            }
                
            if(map.containsKey(sum)){// if map already contains a specific sum do nothing as we want max range so let the old sum be along with its old index position
               
            }
            else{// if the sum is a new sum add it along with its index
                map.put( sum ,i);
                
            }
            
        }
        return max;
        
    }
}