class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        
        if(nums.length == 0){
            return 0;
        }
        
        int begin = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while(end <= nums.length ){// we are going upto nums.length becuase we dont want to miss last iteartion since we are doing end++, it will skip the last iteration
            
            
            if(sum < s && end < nums.length){
                
                sum = sum + nums[end++];
            }
            
            else if(sum >=s ){// if sum is equal to or more than the required sum we start reducing thwe window 
                
               
                   
                if(end - begin < min){
                   // System.out.println("sum - " + sum + " and " + begin + " " + end);
                    min = end - begin;
                }
                
                sum = sum - nums[begin++];
                
                
            }
            else{// this is important as becuase if both the conditions fails it will be looping without exiting
                break;
            }
                
            }
            
            
            
            
            
            
        
        // if(sum == s && end - begin < min){
        //     System.out.println(begin + " and " + end);
        //     min = end - begin;
        // }
        
        return min == Integer.MAX_VALUE ? 0 : min; 
        
    }
}