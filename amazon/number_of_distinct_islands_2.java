class Solution {
    
    private class points implements Comparable<Point>{
        
        int x ;
        int y;
        public points(int x , int y){
            
            this.x = x;
            this.y = y;
            
            
        }
        
        public int compareTo(Point b){
            
            return this.x == b.x ? b.y - this.y : b.y - this.y;  
            
        }
        
        
        public String toString() {
            return String.format("(%d,%d)", this.x, this.y);
        }
        
    }
    public int numDistinctIslands2(int[][] grid) {
        
        if(grid.length == 0){
            return 0;
        }
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0 ;i< grid.length;i++){
            
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1){
                    List<Point> points = new ArrayList<Point>();
                    dfs(i, j , i, j , points , grid);
                    
                    findall(points);
                    
                    if(points.size() > 0 ){
                        
                       String f =  findall(points);
                        
                        set.add(f);
                        points.clear();
                    }
                    
                }
                
            }
            
        }
        
    }
    
    public void dfs(int i , int j , int i0 , int j0 , List<Point> points ,int[][] grid ){
        
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid.length - 1  && grid[i][j] != 1){
            
            return;
            
        }
        
        grid[i][j] = -1;
        
        points.add(new Point(i - i0 , j - j0));
        
        dfs(i + 1 , j , i0 , j0 , points , grid);
        dfs(i , j + 1 , i0 , j0 , points , grid);
        dfs(i - 1 , j , i0 , j0 , points , grid);
        dfs(i , j - 1 , i0 , j0 , points , grid);
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    public String findall(List<Point> points){
        
        int[][] dihedrals = {{1,1},{1,-1},{-1,1},{-1,-1}};
        
        List<Point>[] comb = new List[8];// generate all mirror images and rotations
        
        for(int i = 0 ; i< 4 ; i++ ){
            comb[i] = new ArrayList<Point>();
            comb[i+4] = new ArrayList<Point>();
            for(Point p  : points){
                
                
                comb[i].add(new Point(p.x * dihedrals[i][0] , p.y * dihedrals[i][1] ) );// for mirror images
                comb[i+4].add(new Point(p.x * dihedrals[i][1] , p.y * dihedrals[i][0] ));// for rotations
                
                
                
            }
            
                
        }
        
        for(int i = 0; i < 8 ; i++ ){ // sort all the possible patterns
            
            
            Collections.sort(comb[i]);
            
        }
        
        String s = new String[8];
        
        for(int i = 0; i < 8 ; i++){// convert all the eight possibilities in the form of a string
            
            StringBuilder sb = new StringBuidler();
            
            int x0 = comb[i].get(0).x;
            int y0 = comb[i].get(0).y;
            
            for(Point p : comb[i]){
                
                sb.append((p.x - x0) + "," + (p.y - y0));
                sb.append("!");
                
            }
            s[i] = sb.toString();
            
            
        }
        Arrays.sort(s);//sort everything
        
        return s[0];
        
        
        
        
    }
}