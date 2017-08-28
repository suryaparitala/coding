public class Solution {
    int v;
    int[][] prerequisites;
    LinkedList<Integer>[] adj= new LinkedList[v];
    
    public boolean canFinish(int numCourses, int[][] prerequisites1) {
        v = numCourses;
        prerequisites =  prerequisites1;
        
        
        try{
         int i;   
        for(i=0;i<v ; ++i){
            adj[i] = new LinkedList<Integer>();
        }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println();
        }
        
        for(int i=0; i< prerequisites.length ;i++) // creating an adjacency matrix
            adj[prerequisites[i][0]].add(prerequisites[v][1]);
            
        Stack ansstk = new Stack<Integer>();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        
        for(int i=0; i< v; i++){
            
            if(!visited.contains(v)){
                if(!canfinish1(i,visited,ansstk)) // if the util dfs returns false then loops are there so not possible
                    return false;
            }
        }
        
        return true;
    }
    public boolean canfinish1(int i, ArrayList<Integer> visited ,Stack ansstk){
        if(visited.contains(i)){ // when canfinish1 is called for first time on each item we check and send it here if it is visted or not , if again after multiple recursion if we visit the same node again then it means loops exist 
            return false;
        }
        visited.add(i);
        
        Iterator<Integer> itr = adj[i].iterator();
        while(itr.hasNext()){
            int temp2 = itr.next();
            if(!visited.contains(temp2)){
                if(!canfinish1(temp2,visited ,ansstk)) // recur call for all its children
                    return false;
            }
        }
        ansstk.push(v); // when all the childeren nodes are done then push it onto the stack
        return true;
    }
}