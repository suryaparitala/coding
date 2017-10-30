class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(s.length() == 0 && p.length() == 0){
            
            return list;
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
                
                if(end - begin == p.length()){// if the window length same as serach word length then add it to list , because if we dont compare the length it will show all string which contian the serach string ex - xaycb where searching for abc for the ex string the counter == 0
                    
                    list.add(begin);
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
        
        
        
        
       return list; 
        
    }
}