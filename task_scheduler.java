class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        
        int count = 0;
        if(tasks.length == 0){
            return count;
        }
        
        HashMap<Character , Integer> map = new HashMap<>();
        
        for(char x : tasks){
            
            map.put(x , (map.getOrDefault(x,0)+1));
            
        }
        
        
        

        
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>( //frequency sort
            (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

        q.addAll(map.entrySet());// ---------------------------------
        
        
        while(!q.isEmpty()){
            
            
            
            int k = n+1; // we are adding +1 beacuse, between two same things n is the distance, and including the element itself we add +1
            
            ArrayList<Map.Entry<Character,Integer>> templist = new ArrayList<>();
            
            while(k > 0 && !q.isEmpty()){
                
                Map.Entry<Character, Integer> temp = q.poll();
               
                count++;// this counts the the length, it also means a task is precessed so we reduce and add it to temp
                temp.setValue(temp.getValue() - 1);
                templist.add(temp);// we removed it from queue processed it, and store it in temp, we are not adding it back to the queue right away, we wait till we get the necessary gap and then add it back to the queue.We are not adding it back to queue right away beacuse if we add right way in the next poll it may get picked again
                k--;
                
                
            }
            
            
            
            for(Map.Entry<Character , Integer> x : templist ){ // now add the updated values to queue for the next iteration
                
                if(x.getValue() > 0){ // so that completely processed items can be ignored
                    q.add(x);
                }
                
            }
            
            
            
            
            if(q.isEmpty()){ // it mean all the elements are process hence break, also keep this check before adding spaces,beacuse if the q is empty(i.e all elemetns are processed) then no need to add spaces even though k > 0
                break;
            }
            
            if(k > 0){ // after polling different value, if the k count doesnt reach, we must add spaces in its place
                
                count = count + k;// adding the count for spaces
                
            }
            
            
            
            
            
        }
        
        return count;
        
        
        
        
        
        
    }
}