public class Solution {
    int grid[][];
    int isup;
    int isdown;
    int isleft;
    int isright;
    int perimeter =0;
    
    public int islandPerimeter(int[][] grid) {
        
    
       
    	this.grid = grid;
    	
       
        for(int i=0;i< grid.length;i++)
        for(int j=0 ;j<grid[0].length;j++)
        {
        	isup = 0;
            isdown = 0;
            isleft = 0;
            isright = 0;
            
            if(grid[i][j] == 1){
            int sum = isup(i,j) + isdown(i,j) + isright(i,j) + isleft(i,j);
           // System.out.print(i+"and"+j+"  " );
            //System.out.print(isup(i,j)+"  "  );
            //System.out.print(isdown(i,j)+"  "  );
            //System.out.print(isright(i,j)+"  "  );
            //System.out.println(isleft(i,j) );
           
            if(sum == 4)
               perimeter  = perimeter + 0; 
              
            if(sum == 3)
               perimeter  = perimeter + 1;   
               
            if(sum == 2)
               perimeter  = perimeter + 2; 
               
            if(sum == 1)
               perimeter  = perimeter + 3;    
               
            if(sum == 0)
                perimeter  = perimeter + 4; 
            }
            
        }
       
        return perimeter;
        
    }
    
    public int isup(int i,int j)
    {
    	if(i-1>= 0 && j>=0)
        if(grid[i-1][j]==1){
           isup = 1;
           
        }
		return isup;
		
        
    } 
    
    public int isdown(int i,int j)
    {
    	if(i+1 < grid.length && j>=0)
        if(grid[i+1][j]==1 ){
         isdown = 1;}
        return isdown;
        
        
    }
    
     public int isright(int i,int j)
    {
    	 if( j+1 < grid[0].length)
    	 if(i>= 0 )
        if(grid[i][j+1]==1)
           isright = 1;
        return isright;
        
    }
   public int isleft(int i,int j)
    {
	   if(i>= 0 && j-1>=0)
        if(grid[i][j-1]==1 )
           isleft = 1;
        return isleft;
        
    } 
}
        
        
        
    
