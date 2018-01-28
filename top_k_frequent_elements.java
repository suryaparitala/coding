class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
    
        if( nums.length == 0 ){
            return ans;
        }
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int x : nums){
            
            if(!map.containsKey(x)){
                
                map.put(x , 0);
                
            }
            
            map.put(x , map.get(x)+1);
            
            
        }
        
        
        List<Integer>[] bucket = new List[nums.length + 1 ];// if there is only one number and it is 1, then its index will be at 1.
        
        for( int n : map.keySet()){// for the frequency index position in the list add what is value has the frequency
            
            int x = map.get(n);
            
            if(bucket[x] == null){
                
                bucket[x] = new ArrayList<Integer>();
                
            }
            bucket[x].add(n);
            
            
            
        }
        
        int n = bucket.length-1 ;
        while( n >= 0  && ans.size() < k ){
            
            if(bucket[n] != null){
                ans.addAll(bucket[n]);
                
            }
           
            n--;
        }
    
        return ans;
    }
}