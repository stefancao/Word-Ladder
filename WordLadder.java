import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
 * Filename : WordLadder.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class WordLadder {

	public WordLadder(String fileName, String startWord, String endWord) {
        
        // create a stack of strings
        MyStack<String> newstackOfStrings = new MyStack<String>();

        // push the start word on this stack
        newstackOfStrings.push(startWord);

        // create a queue of stacks
        MyQueue<MyStack<String>> newqueueOfStacks = new MyQueue<MyStack<String>>();

        // enqueue this stack
        newqueueOfStacks.push(newstackOfStrings);

        // creating a SimpleList for tempWords to store the them
        SimpleList<String> tempWordsList = new SimpleList<String>();
        
        // boolean for while loop to stop when done
        boolean whileLoopStop = false;
        
        // while the queue is not empty 
        while ((!newqueueOfStacks.isEmpty()) && (!whileLoopStop)) {
            
        	// for each word in the dictionary
            Scanner wordsFile = null;
			try {
				wordsFile = new Scanner(new File(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

            while (wordsFile.hasNextLine() && (!whileLoopStop)) {
                
            	// getting the next word
            	String word = wordsFile.nextLine();

            	// see if the word already contains in tempWords then can skip
                if (tempWordsList.contains(word)) {
                    continue;
                }

                // setting the newStacksOfStrings to the front of queue
                newstackOfStrings = newqueueOfStacks.front();
                
                // getting the topWord on stack
                String topWord = newstackOfStrings.top();

                
                // isTrue is for if statement for 'if a word is 1-letter different in any pos than top string of the front stack'
				boolean isTrue = false;
                
                // allow one wordDifference only, can change this number if want more
                int wordDifference = 1;
                
                // checking if they have the same length
                if(word.length() == topWord.length()){
                	
                	// for every single letter check if they are the same
					for(int j = 0; j < word.length(); j++){
						if(word.charAt(j) != topWord.charAt(j)){
							wordDifference--;
							
							// if there was only 1 difference (1-- = 0)
							if(wordDifference == 0){
								isTrue = true;
							}
							if(wordDifference < 0){
								isTrue = false;
							}	
						}
					}	// end for loop	
				}
                
                // if a word is 1-letter different in any pos than top string of the front stack
                if (isTrue) {
                	
                	// insert the word found into tempWords List
                    tempWordsList.insertAtPos(tempWordsList.size(), word);

                    // if this word is the end word
                    if (word.equals(endWord)) {
                    	
                        // Done! The front stack plus this word is your word ladder.
                      
                    	// making a tempArray to print out the words in reverse (since stack pops from top)
                        String[] tempArray = new String[newstackOfStrings.size()];
                        
                        int index = 0;
                        while (!newstackOfStrings.isEmpty()) {
                        	
                        	// save the top
                        	tempArray[index] = newstackOfStrings.top();
                            newstackOfStrings.pop();
                            index++;
                        }
                        
                        // printing the saved words
                        for(int i = tempArray.length-1; i >= 0; i--){
                        	System.out.println(tempArray[i]);
                        }
                        
                        // printing the last word
                        System.out.println(word);

                        // setting whileLoopStop to true to terminate the loop 
                        whileLoopStop = true;
                    } 
                    else {
                    	
                        // Make a copy of the front stack
                        MyStack<String> stackOfStringsCopy = new MyStack<String>(newstackOfStrings);

                        // push the found word onto the copy
                        stackOfStringsCopy.push(word);

                        // enqueue the copy.
                        newqueueOfStacks.push(stackOfStringsCopy);
                    }
                }
            }

            // dequeue front stack
            newqueueOfStacks.pop();
            
            // close the file
            wordsFile.close();
        }
        
        // if can't find any word ladder, print out start and end words
        if(!whileLoopStop) {
        	System.out.println(startWord);
            System.out.println(endWord);
        }
    }
}