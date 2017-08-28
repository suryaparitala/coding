public class stackWithMin2 extends Stack<Integer>{

Stack<Integer> s2; // creating a reference s2 of parent class type

public StackWithMin2(){
s2 = new Stack<Integer>();// instantiate the reference 
}

public void push(int value){
if(value <= min()){
s2.push(value);// using built in push function of Stack<Integer> 
}
super.push(value);// this for the implementation of class push function
}

public Integer pop(){

	int del = super.pop()
	if(del == min()){ // can also write if(del == s2.peek())
		s2.pop();
	}
	return value;
}

public int min(){
	if(this.isEmpty()){
		return Integer.MAX_VALUE; // if the object that was created to use StackWithMin2 has no elements then return the max value
		else{
			return s2.peek();//The most recent min element
		}
	}
}

}