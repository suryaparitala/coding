/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stk = new Stack();

    public NestedIterator( List<NestedInteger> nestedList ) {// use a stack to flatten the list
        
        
        
        for(int i= nestedList.size() -1 ; i>=0 ; i--){// add stack from last because we want first element when we flatted and return 
            
            stk.push(nestedList.get(i));
        }
        
    }

    @Override
    public Integer next() {
        
        
        return stk.pop().getInteger();
    }

    @Override
    public boolean hasNext() {// ppl usually do hasNext and if its true then they do next to get the element, so while ppl do hasnext then we find the integer and return true
        
        while(!stk.isEmpty()){// while the stack is not empty keep iterating
            
            if(stk.peek().isInteger()){// if the top most element on the stack is a integer then return true
                
                return true;
            }
            else{// flatten the top most element , since top of array is not integer its of type nestedintegr
                
               List<NestedInteger> temp = stk.pop().getList(); // pop the nested integer and get the list from it, since the list is of the type List and type is NestedInteger save it in temp
                for(int i = temp.size() -1 ; i >= 0 ; i-- ){// again in a reverse way iterate over the list and add it to the stack
                    stk.push(temp.get(i));
                }
                
                
            }
            
        }
        
        return false;// just a dummy false it will never come here, becuase the while loop will run till a true is returned, also keep false here fo cases when the list is empty and there is nothing else to traverse
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */