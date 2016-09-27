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
 * Filename : MuQueue.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class MyQueue<T> {

	// defining list
	SimpleList<T> list;

	// default constructor
	public MyQueue(){
		list = new SimpleList<T>();	
	}
	
	// checking if queue is empty
	public boolean isEmpty(){
		if(list.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	// push an element to queue
	public void push(T value){
		
		// if list is empty pushFront
		if(list.size() == 0){
			list.pushFront(value);	
		}
		else{
			list.pushBack(value);
		}
	}
	
	// poping the front of queue
	public void pop(){
		if (list.size() == 0) {
            throw new QueueUnderflowException(this);
        }
        list.removeAt(0);
	}
	
	// return the front element in queue
	public T front(){
		try {
			return list.getAt(0);
		} catch (Exception e) {
			
		}
		return null;
	}
	
	// return the size of queue
	int size() {
        return list.size();
    }
	
}
