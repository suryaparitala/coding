class Solution {
    public String frequencySort(String s) { // use bucket sort , same as top k elements
        
        
        
        if(s.length() == 0){
            
            return "";
            
        }
        
        HashMap<Character ,Integer> map = new HashMap<>();
        List<Character> list[] = new ArrayList[s.length() + 1];// create a list of size 1 more than s.length() because length is 4 then the list will have indexes 0,1,2,3 but what if we want to store a word with frequency 4 i.e if all are same. ex - aaaa in this case we have to store 'a' at 4 th index 
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                
                map.put(ch , map.get(ch) + 1);
                
            }
            else{
                   map.put(ch,1);
            }
            
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            
            char key = entry.getKey();
            int value = entry.getValue();
            
            if(list[value] == null){// if nothing has been store there then do nothing
                list[value] = new ArrayList<Character>();
            }
            list[value].add(key);
            
        }
        
        //System.out.println(map);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = s.length() ; i >= 0 ; i--){ // construct the word that is to be returned
            
            List<Character> temp = list[i];
            
            if(temp != null){
                
                for(char x : temp){
                    int times = i;
                    
                    while(times > 0){
                        sb.append(x);
                        times--;
                    }
                    
                }
                
            }
            
        }
        
        
        
        
        return sb.toString();
        
        
        
    }
}