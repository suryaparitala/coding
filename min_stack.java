class MinStack {
    
    Stack<Integer> minstk = new Stack<Integer>();
       Stack<Integer> stk = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
        
       
        
    }
    
    public void push(int x) {
        
        if(minstk.isEmpty()){
            minstk.push(x);
        }
        else{
            if(minstk.peek() >= x){// keep >= not just > because if both minstk top and new element are same then also we msut add new element ex - push(0,1,0) , minstk - push (0) again push(0) for new zero that has come
                minstk.push(x);
            }
        }
        
        stk.push(x);
    }
    
    public void pop() {
        
        int temp =0;
        if(!stk.isEmpty()){
         temp = stk.pop();
        }
        
        if( !minstk.isEmpty()  && temp == minstk.peek() ){
            minstk.pop();
        }
        
        // return temp;
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        
         return minstk.peek();
    
        
}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */