class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0){
            return 0;
        }
        
        int ans =0;
        
        HashMap<Character , Integer> map = new HashMap<Character , Integer>();
        
        int counter =0;
        int begin =0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        
        while(end < s.length()){
            
            char temp = s.charAt(end++);
            
            if(!map.containsKey(temp)){
                map.put(temp , 0);
            }
            
            map.put(temp, map.get(temp)+1);
            if(map.get(temp) > 1){// we have a duplicate value
                counter++;
            }
            
            while(counter > 0){// there exist some duplicate value , for duplicates more than 2 just do counter >2
                
                char temp2 = s.charAt(begin++);
                
                if(map.get(temp2) > 1){// the duplicate culprit is found
                    counter--;
                }
                map.put(temp2,map.get(temp2)-1);
                
                
            }
            // by the the time the code reaches here the culprit is found and removed so here counter = 0
            
            
            if(end - begin > max){
                
                max = end - begin;
                
            }
            
            
            
        }
        
        
        return max == Integer.MAX_VALUE? 0 : max;
        
        
    }
}