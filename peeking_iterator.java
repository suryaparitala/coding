// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> iter;
    Integer next = null;
	
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    
        iter = iterator;
        
      if( iter.hasNext() ){// move one stop in the iterator in the constructor call itself
         
         next = iter.next();// store the prev element value in the next variable
          
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        
       return next;// Since we already one step ahead the iterator is already poinitng to next element 
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ans = null;// for the normal next just give the previous element 
        ans = next;
        
        next = iter.hasNext() ? iter.next():null;// compute the next element and stoer it in next
        
        
        return ans;
        
	}

	@Override
	public boolean hasNext() {
	    
        
        return next != null;
	}
}
