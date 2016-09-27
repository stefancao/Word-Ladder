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
 * Filename : MyStack.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class MyStack<T> {
	
	// private fields for GenericStack 
	private T[] data;
	private int t;
	
	final private int CAPACITY = 1000; 		
	
	// default constructor
	@SuppressWarnings("unchecked")
	MyStack(){
		data = (T[]) new Object [CAPACITY];
		t = 0;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	// Make a deep copy
    MyStack(MyStack rhs) {
        data = (T[]) new Object[CAPACITY];
        t = 0;

        for (int i = 0; i < rhs.size(); i++) {
            push((T) rhs.data[i]);
        }
    }
	
	// checking if stack is empty
	public boolean isEmpty(){
		if(t == 0){		// t == -1 indicates the stack is empty
			return true;
		}
		else{
			return false;
		}
	}
	
	// returning the size of stack
	public int size(){
		return t;
	}
	
	// pushing value to stack
	public void push(T value){
		
		// if Stack is full throw exception
		if(t >= CAPACITY){
			throw new StackOverflowException(this, CAPACITY);
		}

		data[t] = value;		// put the value into the array
		t++;	// increment the top of stack
		
	}
	
	public void pop(){
		
		// make sure that the stack is not empty, otherwise throw exception
		if(isEmpty()){
			throw new StackUnderflowException(this);
		}
		
		t--;	// decrement the value top of stack
	
	}
	
	 // Get the top element
    T top() {
        if (!isEmpty()) {
            return (T) data[t-1];
        }

        return null;
    }
	
}
