class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        LinkedList<Integer> adjlist[] = new LinkedList[n];
        
        for(int i=0; i< n ;i++){
            adjlist[i] = new LinkedList<Integer>();
        }
        for(int i=0;i<edges.length ; i++ ){
            
            int x = edges[i][0];
            int y = edges[i][1];
            adjlist[x].add(y);
            adjlist[y].add(x);
        }
        
        int pathlen = Integer.MAX_VALUE;
        TreeMap<Integer, ArrayList<Integer>> ansroot = new TreeMap<Integer, ArrayList<Integer>>();// treemap for ordering based on the pathlen that we got
        
        for(int i = 0; i < n ;i++){// for loop to find pathlen for each and every node 
            
            Boolean[] visited = new Boolean[n];//for every node create a new visited lisit 
            for(int z=0 ; z< n ; z++){//assign everything to false so that it doesnt cause any errors
                visited[z] = false;
            }
            visited[i] = true;// mark the vertex we have visited
            
            LinkedList temp = adjlist[i]; // get the corrsponiding adajacency list for the corrsponidng i vertex
            
            
             pathlen = findpath(adjlist , temp , visited , i);// start the pathlen finding function
            
            visited[i] = false;
            // System.out.println(pathlen + " pathlen ");
            
            if(!ansroot.containsKey(pathlen)){// sort according to pathlen and root in a treemap
                ArrayList<Integer> rand = new ArrayList<Integer>();
                rand.add(i);
                ansroot.put(pathlen , rand );
            }
            else{
                ArrayList<Integer> rand = ansroot.get(pathlen);
                rand.add(i);
                ansroot.put(pathlen , rand);
                
                
            }
            
            
            
            
            
        }
        return ansroot.firstEntry().getValue();
    }
    
    
    
    public int findpath(LinkedList<Integer>[] adjlist , LinkedList<Integer> temp , Boolean[] visited , int test){
        
        int ans = Integer.MIN_VALUE;// keep at min so that any value we get is more than it 
        // System.out.println("now at "  + test );
        Iterator<Integer> itr = temp.iterator();// get a iterator for the adjacency list
        
        while(itr.hasNext()){//for each elemenet in adjaceny list if its recursively travel , once we run out of nodes and path ends we exit the while loop
            int var = itr.next();
            // System.out.println("Trying to visit" + var);
            
            if(!visited[var]){
                
                visited[var] = true;
               int len =  findpath(adjlist , adjlist[var] , visited , var);
                
                
                ans = Math.max(len , ans);
                
                
            }
            
        }
        
        return ans == Integer.MIN_VALUE ? 1 : 1+ans;// we come here when the pathends . That is when we again go back in recursion adding 1 to what ever we got or if it the last element in recursion in that case ans is still  Integer.MIN_VALUE so just assign ans as 1
    }
}