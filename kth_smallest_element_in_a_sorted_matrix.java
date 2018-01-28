class Solution {
    
    
   private class Val{
        
        
        int val;
        int x;
        int y;
        
        public Val(int val , int x , int y){
            
            this.val = val;
            this.x = x;
            this.y = y;
            
        }
        
        
        
        
    }
    public int kthSmallest(int[][] matrix, int k) {
        
        
        if(k == 0 || matrix[0].length == 0){
            
            return 0;
            
        }
        
        PriorityQueue<Val> que = new PriorityQueue<Val>(new Comparator<Val>(){ // comparator to sort by in descending order
            
            public int compare(Val v1 , Val v2){
                
                return v1.val - v2.val;
                
            }
            
        });
        
        
        for(int i = 0 ; i < matrix[0].length ; i++){ // add the first row 
            
            que.add(new Val(matrix[0][i] , 0 , i));
            
        }
        
        Val temp = null;
        for(int i =0 ;i < k ;i++){ // whenever we pop add a new element which is beneath the popped one as it may be the next smallest
            
            temp = que.poll();
            int x = temp.x;
            int y = temp.y;
            
            if(x+1 < matrix.length){ // for last row there is nothing further down to add
                que.offer(new Val(matrix[x+1][y] , x+1 , y));
            }
            
            
        }
        
        return temp.val;
        
        
        
        
        
        
        
        
    }
}