class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0){
            return 0;
            
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            
            for(int j=0;j< grid[0].length;j++){
                
                if(grid[i][j] == '0'){
                    continue;
                }
                else{
                    find(i,j,grid);
                    count++;
                }
                
                
            }
            
        }
        
        return count;
        
    }
    
    
    public void find(int i ,int j , char[][] grid){
        
        if(i>= 0 && i < grid.length && j >=0 && j < grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
        
            
            find(i,j-1,grid);
            find(i,j+1,grid);
            find(i+1,j,grid);
            find(i-1,j,grid);
        
        }else{
            return;
        }
        
        
        
        
        
    }
}