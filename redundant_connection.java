class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] ans = new int[2];
        if(edges.length == 0){
            
            return ans;
            
        }
        
        int[] parent = new int[2001];
        
        for(int i = 0 ; i < parent.length ; i++){ // each node is its own parent
             
            parent[i] = i;
        }
        
        for(int[] edge : edges ){
            
            int from = edge[0];
            int to = edge[1];
            
            
           int  parent_of_to = find(parent , to);// find and store parent of to node
           int  parent_of_from = find(parent , from); // find and store parent of from node
           
            
            
            if(parent_of_to == parent_of_from){ // found the extra redundant edge
                
               
                ans[0] = from;
                ans[1] = to;
                
                //return ans;
                
            }
            if(parent_of_to != parent_of_from){ // if both parents are different, then make from's parent, to's parent also
                
                 parent[parent_of_to] = parent_of_from;
                
                
                
            // parent[parent of from] = parent of to
                
                
            }
              //System.out.println(parent_of_from + " and " + parent_of_to+ " nodes are " + from + " and " + to);
            
            
        }
        
        return ans;
        
    }
    
    public int find(int[] parent , int node){ // function which finds the parent of the node
        
//         if(parent[node] == node){ // we have the most parent node,since it is parent of itself
            
//             return parent[node]; // return either parent[node] or node it doesnt matter as both are same
            
//         }
        
        if(node != parent[node]){ // if the node is not its parent then we have further to go
            
            parent[node] = find(parent , parent[node]); // go further down and find parent of parent[node]
            
        }
        
        return parent[node];
        
        
        
    }
}





// class Solution {
//     public int[] findRedundantConnection(int[][] edges) {
//         int[] parent = new int[2001];
//         for (int i = 0; i < parent.length; i++) parent[i] = i;
        
//         for (int[] edge: edges){
//             int f = edge[0], t = edge[1];
//             if (find(parent, f) == find(parent, t)) return edge;
//             else parent[find(parent, f)] = find(parent, t);

//         }
        
//         return new int[2];
//     }
    
//     private int find(int[] parent, int f) {
//         if (f != parent[f]) {
//           parent[f] = find(parent, parent[f]);  
//         }
//         return parent[f];
//     }
// }