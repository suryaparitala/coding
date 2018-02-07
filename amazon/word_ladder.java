class Solution {
    public int ladderLength(String beginword, String endword, List<String> wordlist) {
        
        
        HashSet<String> beginset = new HashSet<String>();
        HashSet<String> endset = new HashSet<String>();
        
        
        if(!wordlist.contains(endword)){
            return 0;
        }
        
        beginset.add(beginword);
        endset.add(endword);
        
        int length = 1;
        
        HashSet<String> visited = new HashSet<>();
        
        while(!beginset.isEmpty() && !endset.isEmpty()){
            
            if(beginset.size() > endset.size()){ // if size of begin set is more than end set, we avoid doing searching on some string by starting from less sized set
                
                HashSet<String> swap = beginset;
                beginset = endset;
                endset = swap;
                
                
            }
            
            HashSet<String> temp = new HashSet<String>();
            for(String str : beginset){ // for all words try all 26 posibilies on all the index positions
                
                char[] ch = str.toCharArray();
                
                for(int i=0;i<ch.length ; i++){
                    
                    char old = ch[i];
                        for(char c = 'a' ; c <= 'z' ; c++ ){// for each index in each word try all possiblities
                            
                            ch[i] = c;
                            
                            String newstring = String.valueOf(ch);
                            
                            if(endset.contains(newstring) ){
                                
                               System.out.println(newstring + " main word " + str);
                                return length+1; 
                                
                            }
                            if(wordlist.contains(newstring) && !visited.contains(newstring)){
                                temp.add(newstring);
                                visited.add(newstring);
                                
                            }
                            ch[i] = old;// again change the modified character or else when the index moves to next postion the previous i will be stuck at last tried character i.e z


                        }
                }
                
                
                
                
            }
            
            length++;// incresae the depth because we have found out all possible words from beginset and now will use those words to move further
            System.out.println(beginset + " -------begin");
            System.out.println(temp);
            beginset = temp;//  what ever words we obtained from beginset we store in temp, now this temp forms the beginset for the next iteration
            
        }
        
        
        
        
        
        
        return 0;
        
    }
}






