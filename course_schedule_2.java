class Solution {
    public int[] findOrder(int n, int[][] prereq) {
        
        
        int[] ans1 = new int[n];
        if(n == 0){
            return  ans1;
        }
        
        LinkedList<Integer>[] adj = new LinkedList[n];
        
        for(int i=0 ; i < n ; i++ ){
            adj[i] = new LinkedList<Integer>();
        }
        
        for(int i=0 ; i< prereq.length ; i++){
            
            adj[prereq[i][1]].add(prereq[i][0]);
        }
        
        ArrayList<Integer> visited = new ArrayList<Integer>();
        
        for(int i=0; i< n; i++){// for all the vertices run the find algorithm
            
            ArrayList<Integer> tempvisited = new ArrayList<Integer>();// send a new tempvisited every time
           boolean ans =  find(adj , visited , tempvisited , i);// visited keeps track of subjects that are completly added i.e last subjects down the path , tempvsited keep track of the path looking for loops
            if(ans == false){
                
                return new int[0];
            }
            
        }
        
        
        int v =visited.size()-1;
        System.out.println(visited);
        for(int i = 0; i < visited.size() ; i++ ){
            
            ans1[i] = visited.get(v-i);// since we are adding in a arraylist the last subject to be taken gets added first so invert the outpuy 
            
        }
        
        return ans1;
        
    }
    
    public boolean find(LinkedList<Integer>[] adj , ArrayList<Integer> visited , ArrayList<Integer> tempvisited ,int i){
        
        if(tempvisited.contains(i)){// if temvisited again contains i it means a loop is there
            
            return false;
        }
        
        
        if(visited.contains(i)){// if visited constins i it means that node was already visited so dont go there. It not an indication of loop because for path 1,2,3,4 and path 6,5,4 even though the end of path is 4 for both it doesnt indcate any loop. Also visited makes sure that if once visited 4 through one path we dont visit it again. So that why we need not return false , jsut retrun true since it wont do any harm
           
            return true;
        }
        
        
        tempvisited.add(i);// add the current node to the visited lsit
       
        
        LinkedList temp = adj[i];
        for(Object x : temp){// itetrate over its childern
            
            // System.out.println((int) x);
            boolean ans = find(adj , visited , tempvisited ,(int) x);// if it return false the error as a loop found
            if(ans == false){// if at any point a false is retruned it means a loop exists so return false , if a true comes then it means a already visited node is visited again(its not a loop ) so do nothing
                return false;
            }
            
        }
        visited.add(i);
        // System.out.println(tempvisited);
        tempvisited.remove(tempvisited.size()-1);// remove the node from tempvisited to uncover your tracks 
        
        return true;
        
        
        
    }
}