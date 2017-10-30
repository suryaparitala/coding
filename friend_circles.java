class Solution {
    public int findCircleNum(int[][] M) {
        
        
        if(M.length == 0){
            return 0;
            
        }
        
        int count = 0;
        
        
        HashSet<Integer> visited = new HashSet<Integer>();
        for(int i=0;i<M.length;i++){
            
            
            HashSet<Integer> flist = new HashSet<Integer>();// to hold friends list of a particular i
            find(M,i ,flist , visited );
           // System.out.println(flist);
            if(flist.size() == M.length){// if the friend list of a particulat i has all the nodes then everyone in the same group
                return 1;
            }else if(flist.size()>0){
                count++;
            }
            
            
            
        }
        
        
        return count;
    }
    
    public void find(int[][] M , int f , HashSet<Integer> flist  , HashSet<Integer> visited){
        
        if(visited.contains(f)){
            return;
        }
        visited.add(f);// add the currently visiting node
        
        for(int i=0;i<M.length;i++){
            
            if(M[f][i] == 1){// if i is a friend of f
                
                flist.add(i);// add it to friend list
                if(flist.size() == M.length){
                    return;
                }
                if(!visited.contains(i)){// and if i was never visited go and visit it
                    find(M , i , flist , visited);
                }
                visited.add(i);// after visiting done mark i as visited, note dont mark i as visited before doing a recursive call as this will lead to visited list already having i and returning directly
                
            }
            
        }
        
        
        
    }
}