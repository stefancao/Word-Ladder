/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: assignment2
 * Filename : SimpleList.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class SimpleList <T> {

	@SuppressWarnings("hiding")
	public class Node<T>{
		
		// private fields for Node class
		private T value;
		private Node<T> next;
		
		// default constructor for Node class
		public Node(){
			this.next = null;
		}
		
		public Node(T value) {
			this.value = value;
		}
		
		// Accessor method
		public T getElement(){
			return value;
		}
		
		public Node<T> getNext(){
			return next;
		}
		
		// Modifier methods
		public void setElement(T v){
			value = v;
		}
		public void setNext(Node<T> n){
			next = n;
		}
		
	}	// end line Node class
	
	
	// private field for SimpleList class
	private Node<T> head;
		
	
	// default constructors for SimpleList
	SimpleList(){
		head = null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	SimpleList(SimpleList rhs){
		// setting the first element to the head
		head = new Node<T>();
		head.setElement((T) rhs.getAt(0));
				
		// copying the rest of the elements to the new list
		for(int i = 1; i < rhs.size(); i++){

			// calling pushBack method which pushes all the new elements at the end of list
			pushBack((T) rhs.getAt(i));
		}	
	}
	
	// getting the previous node
	Node<T> previous(Node<T> curr){
		Node<T> temp_curr = head;
		while(true){
			
			// break and return if finding that the next node is curr
			if(temp_curr.getNext() == curr){
				break;
			}
			
			// else continue to traverse across the list
			else{
				temp_curr = temp_curr.getNext();
			}
		}
		return temp_curr;	
	}
	
	// getting the next node
	Node<T> next(Node<T> curr){
		Node<T> temp_curr = head;
		while(true){
			
			// if find the current node, then return the next node
			if(temp_curr == curr){
				break;
			}
			
			// else continue to traverse across the list
			else{
				temp_curr = temp_curr.getNext();
			}
		}
		
		// return the next node
		return temp_curr.getNext();
	}
	
	// get the value given an index
	T getAt(int index){
		
		// check if index is out of bound
		if((index < 0) || (index > size()-1)){
			return null;	
		}
			
		// else find the element
		else{
					
			// Instantiating a 'current' node to use to traverse across the list
			Node<T> curr = head;
					
			// going through the list
			for(int i = 0; i < index; i++){
				curr = curr.getNext();
			}
					
			// getting the current element and return it	
			return curr.getElement();
		}
	}
	
	// setting the value at a specific index
	void setAt(int index, T value){
		// check if index is out of bound
		if((index < 0) || (index > size()-1)){
			System.out.println("Index is out of bound!");
		}
				
		else{
			// Instantiating a 'current' node to use to traverse across the list
			Node<T> curr = head;
							
			for(int i = 0; i < index; i++){
				curr = curr.getNext();
			}
					
			curr.setElement(value);
		}
	}
	
	// Insert a new value given an index
    void insertAtPos(int index, T value) {
        Node<T> previous = null;
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        Node<T> node = new Node<T>(value);

        if (previous == null) {
            node.next = head;
            head = node;
        } else {
            previous.next = node;
            node.next = current;
        }
    }
	
    //removing at a specific index
	boolean removeAt(int index){
		// if user inputs an index that is out of bound, return false
		if((index < 0) || (index > size()-1)){
			System.out.println("Index is out of bound!");
			return false;
		}
		
		// case where index is 0, first element in list
		else if(index == 0){
				
			// if there is only one element left
			if(size() == 1){
				head = null;
				return true;	
			}
			
			else{
				
				// Instantiating a 'current' node to use to traverse across the list
				Node<T> curr = head;
					
				head = curr.getNext();
					
				// putting to null to de-access the node to let garbage collector take it
				curr.setNext(null);

				return true;
			}
		}
			
		// case where user wants to remove node at the end of the list
		else if (index+2 > size()){
				
			// Instantiating a 'current' node to use to traverse across the list
			Node<T> curr = head;
			
			// traverse across the list
			for(int i = 0; i < (index-1); i++){
				curr = curr.getNext();
			}
			
			// putting to null to de-access the node to let garbage collector take it
			curr.setNext(null);
			
			return true;	
		}
			
		// case removing anywhere between two existing nodes
		else{
				
			// Instantiating a 'current' node to use to traverse across the list
			Node<T> curr = head;
							
			// traverse across the list
			for(int i = 0; i < (index-1); i++){
				curr = curr.getNext();
			}
				
				
			// creating a tempNode
			Node<T> tempNode = new Node<T>();
			tempNode.setNext(curr.getNext().getNext());
			
			// putting to null to de-access the node to let garbage collector take it
			curr.getNext().setNext(null);
		
			// connecting the two nodes where the removed nodes were between together
			curr.setNext(tempNode.getNext());
				
			return true;
		}
	}
	
	// return the size of list
	int size(){
		int sizeCounter = 0;
		if(head == null){
			return 0;
		}
		Node<T> curr = head;
		
		// going through the list and see how many times have to do so, which indicates in a counter
		while(curr != null){
			sizeCounter++;
			curr = curr.getNext();
		}
		return sizeCounter;
	}
	
	// return a string
	public String toString(){
		// creating a temp array
		char[] tempArray = new char[size()];
		tempArray = toArray();
		
		// convert the char array to string
		String temp = new String(tempArray);
		
		return temp;
	}
	
	// convert the list to array
	char[] toArray(){
		
		// creating a temp array
		char[] tempArray = new char[size()];
		Node<T> curr = head;
		 
		 int lcIndex = 0;
		 
		 // going through the list
		 while(curr != null){
			 
			 // putting the elements in the array
			 tempArray[lcIndex] = (Character) curr.getElement();
			 curr = curr.getNext();
			 lcIndex++;
		 }
		 
		 return tempArray;	
	}
	
	// pushing node (element) at the beginning of the list
	public void pushFront(T value){

		if(size() == 0){

			Node<T> newNode = new Node<T>();
			head = newNode;
			head.setElement(value);
	
		}
		else{
			Node<T> newNode = new Node<T>();
	
			Node<T> curr = head;
						
			// adding the new node in the beginning of the list	
			newNode.setNext(curr);
			newNode.setElement(value);
				
			// setting the new node as the head
			head = newNode;
		}
	}
		
	// pushing node (element) at the end of the list
	public void pushBack(T value){
		
		Node<T> newNode = new Node<T>();

		Node<T> curr = head;
		
		// traverse across the list
		for(int i = 0; i < (size()-1); i++){
			curr = curr.getNext();
		}
		
		// adding the new node at the end of list
		curr.setNext(newNode);
		newNode.setElement(value);
		
		// setting the next node to null to indicate end of list
		newNode.setNext(null);
	}
	
	// Check if value is already here
    public boolean contains(T value) {
        Node<T> current = head;
        
        while(current != null) {
            if(current.value.equals(value)) {
                return true;
            }
            
            current = current.next;
        }
        
        return false;
    }

}

