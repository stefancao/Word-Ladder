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
 * Filename : StackOverflowException.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 


@SuppressWarnings("serial")
public class StackOverflowException extends RuntimeException {

    @SuppressWarnings("rawtypes")
	public StackOverflowException(MyStack stack, int capacity) {
        super("push() on MyStack with CAPACITY == " + capacity + ", size == " + stack.size());
    }
}
