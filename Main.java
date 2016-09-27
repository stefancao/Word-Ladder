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
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
		if (args.length != 3) {
	        System.out.println("Please provide a file name, startWord and endWord...");
	        return;
    	}

		String startWord = args[1];
		String endWord = args[2];
	
		WordLadder newWordLadder = new WordLadder(args[0], startWord, endWord);
		
	}

}