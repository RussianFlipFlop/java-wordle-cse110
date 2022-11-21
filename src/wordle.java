/*-------------------------------------------------------------------------
// AUTHOR: Group 16
// FILENAME: wordle.java
// SPECIFICATION: Acts as the main file and user interface for the Wordle program.
// FOR: CSE 110
//----------------------------------------------------------------------*/

import java.util.Scanner;
import java.util.Random;

public class wordle {

	public static void main(String[] args) throws Exception {
		
	// declaring and initializing required variables
	Scanner console = new Scanner(System.in);
	int inputDifficulty;
	int numTries;
	String playAgain = "n";
	int numLetters = 0;
	
	// displays the title screen menu
	displayMenu();
	
	// main while loop that runs until user decides to quit (by typing "n" after the end of a round)
	do {
		System.out.println("");
		// while loop that ensures the input difficulty ranges between 1 and 3
		do {
			System.out.print("Enter a difficulty (1-3): ");
			inputDifficulty = console.nextInt();
			// checks that input difficulty is between 1 and 3
			if (inputDifficulty < 1 || inputDifficulty > 3) {
				System.out.println("Difficulty must be 1-3.\n");
			}
		} while (inputDifficulty < 1 || inputDifficulty > 3);
		
		// switch-case statement that sets the number of tries based on the input difficulty
		switch(inputDifficulty) {
			case 1:
				numTries = 6;
				break;
			case 2:
				numTries = 4;
				break;
			case 3:
				numTries = 2;
				break;
			default:
				numTries = 0;
		}
		
		// creates new object of class wordGenerator
		wordGenerator word1 = new wordGenerator();
		String currentWord = word1.getWord();
		String totalPlaceholders = "";
		//System.out.println(currentWord);
		
		// prints initial placeholders
		System.out.println("\nType \"h\" for hint.");
		System.out.println(" _ _ _ _ _");
		
		// for loop that iterates through the number of tries
		for (int y = 0; y < numTries; y++) {
	
			// asks user for their word input
			String inputWord = console.next();
			boolean val = false;
			// check if the inputWord is valid
            while(!val) {
            	// check if word is more or less than 5 or if the user is asking for the hint
                while (inputWord.length() < 5 && !(inputWord.toUpperCase().equals("H")) || inputWord.length() > 5) {
                    System.out.println("\nThe word is 5 letters long.");
                    System.out.println(" _ _ _ _ _");
                    inputWord = console.next();
                }
                
                // check if user is asking for a hint
                while (inputWord.toUpperCase().equals("H")) {
                    System.out.println("\n\u001b[31;1m\u001b[1mDefinition: " + word1.getHint() + "\u001b[0m");
                    System.out.println(" _ _ _ _ _");
                    inputWord = console.next();
                }
                
                if(!(inputWord.toUpperCase().equals("H") || inputWord.length() < 5 && !(inputWord.toUpperCase().equals("H")) || inputWord.length() > 5)) { // check if word is vaild.
                    val = true;
                }
            }
			
			System.out.println("");
			// adds up the output words from each round
			totalPlaceholders = totalPlaceholders + word1.getPlaceholders(inputWord.toUpperCase()) + "\n";
			System.out.println(totalPlaceholders);
			
			// checks if all letters are correct, if so, displays win message and asks if user wants to play again
			if (word1.correctLetters == 5) {
				System.out.println("\u001b[32m _    _ _       _ ");
				System.out.println("| |  | (_)     | |");
				System.out.println("| |  | |_ _ __ | |");
				System.out.println("| |/\\| | | '_ \\| |");
				System.out.println("\\  /\\  / | | | |_|");
				System.out.println(" \\/  \\/|_|_| |_(_)\u001b[0m");
				System.out.print("\nPlay again? (\u001b[32my\u001b[0m/\u001b[31mn\u001b[0m): ");
				playAgain = console.next();
				numLetters = 5;
				break;
			}	
		}
		
		// if the user does not want to play again, displays goodbye message and breaks loop
		if (numLetters == 5) {
			if (!(playAgain.toUpperCase().equals("Y"))) {
				System.out.println("\nThank you for playing!");
				break;
			}
		// if user does not win, displays game over message and the correct word, asks if user wants to play again
		} else {
			System.out.println("\n\u001b[31mGame Over!\u001b[0m");
			System.out.println("The word was \"\u001b[33;1m\u001b[1m" + currentWord + "\u001b[0m\".");
			System.out.print("Play again? (\u001b[32my\u001b[0m/\u001b[31mn\u001b[0m): ");
			playAgain = console.next();
			
			// if the user does not want to play again, displays goodbye message and breaks loop
			if (!(playAgain.toUpperCase().equals("Y"))) {
				System.out.println("\nThank you for playing!");
				break;
			}
		}
	} while (playAgain.toUpperCase().equals("Y"));
	console.close();
}

	
	/*
	 * prints title screen
	 */
	private static void displayMenu() {
		// prints the title screen message in a random color each time, just for fun
		Random rand = new Random();
		final String RAND_COLOR = "\u001b[3" + (rand.nextInt(7) + 1) + ";1m";
		Scanner console2 = new Scanner(System.in);
		System.out.println(RAND_COLOR + " _    _               _ _      ");
		System.out.println("| |  | |             | | |     ");
		System.out.println("| |  | | ___  _ __ __| | | ___ ");
		System.out.println("| |/\\| |/ _ \\| '__/ _` | |/ _ \\");
		System.out.println("\\  /\\  / (_) | | | (_| | |  __/");
		System.out.println(" \\/  \\/ \\___/|_|  \\__,_|_|\\___|\u001b[0m");
		
		System.out.println("\n\nType anything to play.\n");
		console2.next();
	}
}