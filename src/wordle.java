import java.util.Scanner;
import java.util.Random;

public class wordle {


	public static void main(String[] args) throws Exception {
		
	Scanner console = new Scanner(System.in);
	int inputDifficulty;
	int numTries;
	String playAgain = "n";
	int numLetters = 0;
	
	displayMenu();
	
	do {
		System.out.println("");
		do {
			System.out.print("Enter a difficulty (1-3): ");
			inputDifficulty = console.nextInt();
			if (inputDifficulty < 1 || inputDifficulty > 3) {
				System.out.println("Difficulty must be 1-3.\n");
			}
		} while (inputDifficulty < 1 || inputDifficulty > 3);
		
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
		
		wordGenerator word1 = new wordGenerator();
		String currentWord = word1.getWord();
		String totalPlaceholders = "";
		//System.out.println(currentWord);
		System.out.println("\nType \"h\" for hint.");
		System.out.println(" _ _ _ _ _");
		
		for (int y = 0; y < numTries; y++) {
	
			String inputWord = console.next();
			
			while (inputWord.length() < 5 && !(inputWord.toUpperCase().equals("H")) || inputWord.length() > 5) {
				System.out.println("\nThe word is 5 letters long.");
				System.out.println(" _ _ _ _ _");
				inputWord = console.next();
			}
			
			while (inputWord.toUpperCase().equals("H")) {
				System.out.println("\n\u001b[31;1m\u001b[1mDefinition: " + word1.getHint() + "\u001b[0m");
				System.out.println(" _ _ _ _ _");
				inputWord = console.next();
			}
			
			System.out.println("");
			totalPlaceholders = totalPlaceholders + word1.getPlaceholders(inputWord.toUpperCase()) + "\n";
			System.out.println(totalPlaceholders);
			
			if (word1.correctLetters == 5) {
				System.out.println("\u001b[32mWin!\u001b[0m");
				System.out.print("Play again? (\u001b[32my\u001b[0m/\u001b[31mn\u001b[0m): ");
				playAgain = console.next();
				numLetters = 5;
				break;
			}	
		}
		
		if (numLetters == 5) {
			if (!(playAgain.toUpperCase().equals("Y"))) {
				System.out.println("\nThank you for playing!");
				break;
			}
		} else {
			System.out.println("\n\u001b[31mGame Over!\u001b[0m");
			System.out.println("The word was \"\u001b[33;1m\u001b[1m" + currentWord + "\u001b[0m\".");
			System.out.print("Play again? (\u001b[32my\u001b[0m/\u001b[31mn\u001b[0m): ");
			playAgain = console.next();
			
			if (!(playAgain.toUpperCase().equals("Y"))) {
				System.out.println("\nThank you for playing!");
				break;
			}
		}
	} while (playAgain.toUpperCase().equals("Y"));
	console.close();
}

	
	
	private static void displayMenu() {
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
		//console2.close();
	}
}