/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null){
            return null;
        }
        
        HashMap<Integer,UndirectedGraphNode> visited = new HashMap<Integer,UndirectedGraphNode>();
        
        UndirectedGraphNode ans = makegraph(node , visited);
        
        return ans;
    }
    
    public UndirectedGraphNode makegraph(UndirectedGraphNode node , HashMap<Integer,UndirectedGraphNode> visited){
        
        
        if(node == null ){// dummy base case which will never get triggered
            return null;
        }
        if(visited.containsKey(node.label)){// if already there no need to make it again just add the exisitng one , also if already added graph is only half made , then as we make changes to it it will get reflected in the new one as well
            
            return visited.get(node.label);
            
        }
        
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        
        visited.put(node.label , newnode);
        
        for(UndirectedGraphNode x : node.neighbors){
            
            UndirectedGraphNode temp = makegraph(x , visited);
            
            newnode.neighbors.add(temp);
            
        }
        //visited.remove(newnode);// while going back we not remove the node as in case if in future again we encounter the same mode we can return it. Also if we have 1-0-2-0 and 1-0-6 so if we create 0 and add to visited list and when we visit again 0 from 2-0 we find 0 in visited list so we add it to 2's neighbors but 0 node is still not complelty cloned becuase it still didnt visit 6. But since in java everthing is references when ever we update the 0 it will get updated in 2's neigbors as well
        
        return newnode;
        
        
        
    }
}