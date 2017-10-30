class Solution {
    public String minWindow(String s, String p) { //  same as find all anagrams just fing min length string among all the possibilities
        
        
        int min = Integer.MAX_VALUE;
        String ans = "";
        
        if(s.length() == 0 && p.length() == 0){
            
            return ans;
        }
        
        HashMap< Character , Integer > map = new HashMap< Character , Integer >();
        
        for(int i=0;i<p.length();i++){
            char temp = p.charAt(i);
            if(!map.containsKey(temp)){
                map.put(temp , 0);
            }
            
            map.put(temp , map.get(temp) + 1);
            
        }
        
        int counter = map.size();
        int begin = 0;
        int end = 0;
        while(end < s.length()){
            
            char temp = s.charAt(end++);
            if(map.containsKey(temp)){
                
                map.put(temp , map.get(temp) -1);// reduce the count , the map indicates the number of elements needed to reach the target , i.e when the map reaches 0 for a certain character it means we do not need that character 
                
                if(map.get(temp) == 0){// if an element in map is zero it means to form anagram we dont need that element. so decrement the counter 
                    counter--;
                }
            }
            
            while(counter == 0){
                
                if(end - begin < min){
                    
                    min = end - begin;
                    ans = s.substring(begin , end);// for substring(start ,end) , start inclusive and end is exclusive, since already end is 1 postion more than actual end due to end++ we can do it
                    
                    
                }
                
                
                char temp2 = s.charAt(begin++);
                
                if(map.containsKey(temp2)){
                    
                    map.put(temp2 , map.get(temp2) + 1);// since while coming from begining we are reducing the window size by moving to the right ,  so we remove the element from the window and and nullify its contribution to the map by doing +1
                
                
                if(map.get(temp2) > 0 ){ // by moving begin to the right and excluding temp2 from window if the temp2 count > 0 i.e the count is more than 0 it means that character is needed now to form an angram
                    
                    counter++;// so we need one more element to reach the anagram 
                    
                }
                
                }
                
            }
            
            
        }
        
        
        
        
       return ans; 
    }
}