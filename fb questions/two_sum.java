class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        
        if(nums.length == 0){
            return ans;
        }
        HashMap map = new HashMap<Integer ,Integer>();
        for(int i=0; i<nums.length ;i++){// note if i get dupicates hashmap will overeide and save the most recent duplicate. Ex if 3,3 map will save 3|1 only as key and value
            map.put(nums[i] , i);
        }
        
       System.out.println(map.get(3));
       
        
        for(int i=0;i<nums.length ;i++){
            if(map.containsKey(target - nums[i]  )){
                ans[0]=i;
                ans[1] = (int)map.get(target - nums[i]);
                if(ans[0] != ans[1]){ // since it cant consider same element twice even if we ignore it the loop goes on finds  the next correct counterpart. ex - 3,2,4 target = 6  we dont want already we are choosing nums[i] as 3 again we cant take 3 from the map as both are same so in that case we dont return value and contine for next set of correct numbers 
                    return ans;
                }
            }
        }
        
        return ans;
    }
}