class Solution {
    public boolean checkInclusion(String s1, String s2) { // same as find all anagrams since a anagram is a permutation
        
        boolean ans = false;
        if( s1.length() == 0 && s2.length() == 0 ){
            
            return ans;
            
        }
        HashMap<Character , Integer> map = new HashMap<Character , Integer>();
        
        for(int i=0;i< s1.length();i++){
            
            if(!map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i) , 0);
            }
            map.put(s1.charAt(i) , map.get(s1.charAt(i))+1);
            
        }
        
        
        int counter = map.size();
        //System.out.println(counter);
        
        int end =0;
        int begin = 0;
        
        while(end < s2.length()){
            
            if(ans == true){
                break;
            }
            char temp = s2.charAt(end++);
            
            if(map.containsKey(temp)){
                
                map.put(temp , map.get(temp) - 1 );
                
                if(map.get(temp) == 0){// temp reahced 0 means the sufficicnet character count is reached ,now we will be needing that temp character since count is more than 0
                    counter--;
                }
            }
            
            while(counter == 0){ // when counter is zero reduce the window from right 
                
                System.out.println(end + " and " + begin );
                if(end - begin == s1.length()){
                    
                    System.out.println( " begin and end " + begin + " and " + end);
                    ans = true;
                    break;
                    
                }
                char temp2 = s2.charAt(begin++);
                if(map.containsKey(temp2)){ // removing temp2 by moving the window will effect the anagram
                    
                    map.put(temp2 , map.get(temp2) +1); // add 1 becuase if its in the window we do -1 to reach the charcater count in map to 0 , since its no its no longer contributing add 1 to the maps charcter
                
                if(map.get(temp2) > 0){
                    counter++;
                }
                
                
                }
                
                
                
                
            }
            
            
            
        }
        
        return ans;
        
    }
}