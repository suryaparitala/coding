class Solution {
    
    
    public int numDistinctIslands(int[][] grid) {// form a pattern and add it to set
        
        if(grid.length  == 0){
            return 0;
            
        }
        
        HashSet<String> set = new HashSet<>();
        
        for(int i =0 ; i< grid.length ; i++){
            for(int j =0 ; j< grid[0].length ; j++){
                
                if(grid[i][j] == 1){
                    
                    StringBuilder sb = new StringBuilder();
                    dfs(i , j , i , j , sb , grid);
                    
                    //System.out.println(sb);
                    set.add(sb.toString());// if two paths have the same pattern then set will ignore it
                    
                    
                }
                
                
                
                
            }
            
            
        }
        return set.size();
        
    }
    
    public void dfs(int i , int j , int i0 , int j0 ,  StringBuilder sb , int[][] grid){
        
        if(i < 0 || i > grid.length -1 || j < 0 || j >  grid[0].length - 1 || grid[i][j] != 1){
            return;
            
        }
        
        grid[i][j] = -1;
        String s = (i - i0) + "," + (j - j0);// append the absolute path starting from the entry point of the island,  also for same type of islands the patterns will be same because the traversal function is same for both the islands, ie it goes down , right , up , left
        sb.append(s);
        sb.append("!");
        
        dfs(i+1,j,i0,j0,sb,grid);
        dfs(i,j+1,i0,j0,sb,grid);
        dfs(i-1,j,i0,j0,sb,grid);
        dfs(i,j-1,i0,j0,sb,grid);
        
        
    }
}