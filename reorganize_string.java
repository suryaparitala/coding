class Solution {
    public String reorganizeString(String S) {
        
        HashMap<Character , Integer> map = new HashMap<>();
        
        for(char x : S.toCharArray()){
            
            map.put(x,map.getOrDefault(x , 0) + 1);
            
            
            if(map.get(x) > ((S.length()+1)/2 )){ // for the case when too many of same type
                return "";
            }
            
            
            
        }
        
        PriorityQueue< Map.Entry<Character , Integer> > q = new PriorityQueue<>( 
            (a,b) -> b.getValue() - a.getValue());
        
        q.addAll(map.entrySet());
        
       // System.out.println(q);
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            
                    Map.Entry<Character , Integer> first = q.poll();// pull out first from the queue
            
                   // System.out.println("first key" + " " + first.getKey());
                    sb.append(first.getKey());// append it to result
                    first.setValue(first.getValue() -1 ); // reduce its count but dont add it yet to the queue

                    if(!q.isEmpty()){ // if queue is still empty

                        Map.Entry<Character , Integer> second = q.poll(); // poll other one 
                        sb.append(second.getKey()); // append it and process
                        second.setValue(second.getValue() -1 );
                           if(first.getValue() > 0){ // if all the first values are processed then dont need to add it back to the queue
                                q.add(first);
                           }
                            if(second.getValue() > 0){
                                q.add(second);
                            }


                    }
            
            
            
            }
        
        
        return sb.toString();
    }
}
                           