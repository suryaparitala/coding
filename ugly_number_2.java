class Solution {
    public int nthUglyNumber(int n) {
        
        if(n == 1){
            
            return 1;
        }
        PriorityQueue<Long> que = new PriorityQueue<Long>( new Comparator<Long>(){
        
            public int compare(Long a , Long b){
            
            return a - b > 0 ? 1 : -1;
            }
        
        });
        
        que.add(1l);
    
        
        long ans = 0;
        while(n > 0){
            if(!que.isEmpty())
                ans = que.poll();
            while( !que.isEmpty() && que.peek() == ans){ // to deal with cases when two adjacent numbers are repeating
                que.poll();
            }
            
            n--;
            que.add((long)ans*2);
            que.add((long)ans*3);
            que.add((long)ans*5);
            
        }
        
        return (int)ans;
    }
}




// public int nthUglyNumber(int n) {
//     if(n==1) return 1;
//     PriorityQueue<Long> q = new PriorityQueue();
//     q.add(1l);
    
//     for(long i=1; i<n; i++) {
//         long tmp = q.poll();
//         while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();
        
//         q.add(tmp*2);
//         q.add(tmp*3);
//         q.add(tmp*5);
//     }
//     return q.poll().intValue();
// }