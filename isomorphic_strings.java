class Solution {
    public boolean isIsomorphic(String s, String t) { // for the words to have same pattern their index positions , repeating words must in in string s must have same index 
        
        
        // the idea is if a new character is added to the map then it will return null , but if an already exisitng value is to be added to the previous index is returned , and we compare the what the put of both map1 and map2 retunr to see if they have a pattern
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();
        
        
        for(int i =0 ;i< s.length() ;i++){
            
            if( map1.put(s.charAt(i)  , i) != map2.put(t.charAt(i)  , i) ){ // when we do a map.put() if a new value is being added then null is returned, else if its is getting updated the old value is returned 
                
                return false;
            }
            
            
        }
        
        return true;
        
    }
}