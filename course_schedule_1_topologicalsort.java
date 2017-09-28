class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        
        boolean ans = true;
        if(n == 0){
            return ans;
        }
        if(prereq.length == 0){
            return ans;
        }
        
        LinkedList<Integer>[] adj = new LinkedList[n];
        
        for(int i=0 ;i< n ; i++){
            adj[i] = new LinkedList<Integer>();
        }
        
        for(int i=0; i< prereq.length ;i++ ){// making a graph
            
            int x = prereq[i][0];
            int y = prereq[i][1];
            
            adj[y].add(x);// because in the graph to do x we first need to do y
            
        }
        
        for(int i=0 ; i< n ;i++){
            
            HashSet<Integer> visited = new HashSet<Integer>();
            System.out.println("trying with " + i);
            
            ans = find(adj , visited , i);
            if(ans == false){
                return false;
            }
        }
        
        return ans;
        
        
        
        
        
        
    }
    
    public boolean find(LinkedList<Integer>[] adj , HashSet<Integer> visited ,int i){
        
        boolean ans = true;
        if(visited.contains(i)){
            // System.out.println("it says false " + i + "visited " + visited);
            return false;
        }
        visited.add(i);
        
        LinkedList temp = adj[i];
        Iterator<Integer> itr = temp.iterator();
        
        while(itr.hasNext()){
            
            int vertex = itr.next();
            
            ans = find(adj,visited , vertex);
            
            if(ans == false){
                // System.out.println("ans is false " + vertex);
                return false;
            }
            
            
        }
        visited.remove(i);// it is important to remove the the vertex we have added because even though we are sending a new visited set everytime in the top most call , here inside the while loop it wont clear itself and obstrcut some other elements
        
        
        return ans;
    }
}