class Solution {
    
    
    public int combinationSum4(int[] nums, int target) {
        
        if(nums.length == 0){
            return 0;
        }
        
        HashMap<Integer ,Integer> map = new HashMap<Integer ,Integer>();// to avoid multiple operatiosn to find the count 
        
        int ans = find(nums , target , 0 , map);
        
        return ans ;
        
    }
    
    public int find(int[] nums , int k , int sum ,HashMap<Integer ,Integer> map){
        
        int ans = 0;
        if(sum > k){// if while adding then sum goes more than target then it is invalid so return 
            return 0;
        }
        
        
        if(sum == k){// if the sum reaches the target then we found a way so retunr 1
           
            
            return  1;
        }
        
        
        if(map.containsKey(sum)){// if an already computed path exists then just return the answer
            return map.get(sum);
        }
        
        for(int i =0;i< nums.length ;i++){// since we have to find all possible combinations i.e (1,1,2) is different from (1,2,1) start the for loop again from i=0 for each and every sum that we get
            
            // sum = sum + nums[i];// use this if we are not dynamically adding sum + nums[i] in the recursive call in the next step
            
           ans = ans + find(nums , k , sum + nums[i],map);// for the current sum add the nums[i] and compute, if a path is found it returns 1 which we add to ans
             
            // sum = sum - nums[i];// if sum+nums[i] was not being used in recursive call and instead we were doing it before it the undo the sum for the i in the for loop ,Note : this commented portion and the commented portion before recurisve call are alterantives if we are not doing sum+nums[i] dynamically during the call
        }
        
        map.put(sum , ans);// put the answer computer before returing 
        
        return ans;
        
        
        
    }
}