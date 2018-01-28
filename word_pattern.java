class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        String[] arr = str.split(" ");
       
        if(pattern.length() != arr.length){
            return false;
        }
        
        HashMap<String , String > map1 = new HashMap<>();
        HashMap<String , String> map2 = new HashMap<>();
        
        // we need two maps because abcd and "cat cat cat cat" if we use onle one map it wont detect
        
        for(int i =0 ;i< pattern.length() ; i++){
            
            String key = pattern.charAt(i) + "";
            String value = arr[i];
            
            if(map1.containsKey(key)){ // if map1 has the key then value int the map and the value we have must be same
                
                if(!map1.get(key).equals(value)){
                    
                    return false;
                }
                
            }
            if(map2.containsKey(value)){
                
                if(!map2.get(value).equals(key)){// also if map2 has a matching the its corresponding attached value must match
                  
                    return false;
                }
                
                
            }
            else{ // if no matchings found we add it to the maps
                
                map1.put(key , value);
                
                map2.put(value , key);
                
            }
            
            
        }
        
        return true;
        
        
        
    }
}