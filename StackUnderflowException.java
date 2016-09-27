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
 * Filename : StackUnderflowException.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

@SuppressWarnings("serial")
public class StackUnderflowException extends RuntimeException {

    @SuppressWarnings("rawtypes")
	public StackUnderflowException(MyStack stack) {
        super("pop() on MyStack of size == " + stack.size());
    }
}

