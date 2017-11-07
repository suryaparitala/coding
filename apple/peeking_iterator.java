// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer curr;
    Integer next;
    
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
        
        if(iterator.hasNext()){
            next = iterator.next();
        }
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        
        return next;
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {// give more power to next, so when ever next  is caled assign next to curr and incremnt next
	     Integer curr = next;
        
        next = iterator.hasNext() ? iterator.next() : null;
        
        
        return curr;
	}

	@Override
	public boolean hasNext() {// has next tells if there is a next element or not, since next is already pointing to next element check if it is null or not 
	   return  next == null ? false:true;
	}
}