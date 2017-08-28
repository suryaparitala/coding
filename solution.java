class node{

int data;
node next;
node(int n){
data = n;
}
}

class LinkedList{
	
	node first;
	LinkedList(){
		first = null;
	}
	
	public void insert(int v){
		
		
		node link = new node(v);
		link.next = first;
		first = link;
	}
	
	public void insertlast(int v){
	node current = first;
	while(current.next != null){
	current = current.next;
	}
	current.next = new node(v);
	current.next.next = null;
	}
	
	public void delete(int v){
	node current = first;
	node previous = first;
	if(first.data == v){
		first = first.next;
	}
	while(current.data != v){
		previous = current;
		current = current.next;
		if(current == null){
			System.out.println("No such element and returning");
			return;
		}
	}
	previous.next = current.next;
	current = null;
}
public void display(){
	node current = first;
	while(current != null){
		System.out.print(" " + current.data + " -> ");
		current = current.next;
	} 
	
}
}

class Solution{
public static void main(String[] args){
LinkedList ll = new LinkedList();
ll.insert(10);
ll.insert(20);
ll.insert(30);
ll.insert(40);
ll.insert(50);
ll.insertlast(80);
ll.insertlast(90);
ll.delete(80);
ll.delete(125);// wirte a case what to do when a value is not found
ll.delete(50);// deleting firts elemtent
ll.display();
}
 }