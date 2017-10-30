class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> anslist = new ArrayList<>();
        
        if(nums.length == 0){
            return anslist;
        }
        
        HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
        
        for(int x : nums){// use map to keep count of variables and use them
            
            if(!map.containsKey(x)){
                map.put(x , 0);
            }
            
            map.put( x , map.get(x) + 1 );
            
        }
        
        Arrays.sort(nums);
        
        List<Integer> temp = new ArrayList<Integer>();
        
        find( nums , anslist , temp , map );// since we need all pemutatations we need to start from i=0 for all numbers
        
        return anslist; 
        
    }
    
    public void find(int[] nums , List<List<Integer>> anslist , List<Integer> temp  , HashMap<Integer, Integer> map){
        
        
        if(temp.size() > nums.length){
            return;
        }
        if(temp.size() == nums.length){
        
            anslist.add(new ArrayList(temp));    
            return;
            
        }
        
        for( int i = 0 ; i < nums.length ; i++ )// since we need all pemutatations we need to start from i=0 for all numbers unlike for other type of sums where we start from i=start 
            
            if(i > 0 && nums[i] == nums[i-1]){// if the prev element same as this just ignore it
                continue;
            }
            
            if(map.get(nums[i]) == 0){// use map to keep count of used nums 
                continue;
            }
            
            else{
                
                
            map.put(nums[i] , map.get(nums[i]) - 1 );
            temp.add(nums[i]);
            
            find(nums , anslist , temp , map);// no need for start index as we want all possible combos we start from i=0 for all
            
            map.put(nums[i] , map.get(nums[i]) + 1 );
            temp.remove(temp.size()-1);
            
            }
            
        }
        
        
        
    }
}