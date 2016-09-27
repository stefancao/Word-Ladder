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
 * Filename : QueueUnderflowException.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

@SuppressWarnings("serial")
public class QueueUnderflowException extends RuntimeException {
    
    @SuppressWarnings("rawtypes")
	public QueueUnderflowException(MyQueue queue) {
        super("pop() on MyQueue of size == " + queue.size());
    }
}