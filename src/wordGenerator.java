/*-------------------------------------------------------------------------
// AUTHOR: Group 16
// FILENAME: wordGenerator.java
// SPECIFICATION: Acts as the class that handles the word and definition, along with their placeholders.
// FOR: CSE 110
//----------------------------------------------------------------------*/


public class wordGenerator {
	// declaring required variables
	private String word;
	private String hint;
	private String[] wordArray;
	int correctLetters = 0;
	
	/*
	 * Constructor that pulls an array of a random word and definition from the Dictionary class
	 * and initializes variables word and hint to the two array values
	 * 
	 * @throws exception any file errors 
	 */
	public wordGenerator() throws Exception {
		Dictionary wordle1 = new Dictionary();
		wordArray = Dictionary.getRandom();
		word = wordArray[0];
		hint = wordArray[1];
	}
	
	/*
	 * @return String variable word containing the first value of the pulled array, the word itself
	 */
	public String getWord() {
		return word;
	}
	
	/*
	 * @return String variable hint containing the second value of the pulled array, the definition of the word
	 */
	public String getHint() {
		return hint;
	}
	
	/*
	 * cross-checks the letters of the user-input word with the actual word, and outputs the letters with
	 * different background colors as needed
	 * @return StringBuilder containing the input letters but with colored backgrounds as needed
	 * 		   (matching = green, in word = yellow, not in word = red)
	 * @param the user input word during a round
	 */
	public StringBuilder getPlaceholders(String inputWord) {
		// creating new StringBuilder object
		StringBuilder output = new StringBuilder();
		correctLetters = 0;
		
		// for loop that iterates through the length of the word
		for (int x = 0; x < word.length(); x++) {
			boolean inWord = false;
			
			// checks if the current letter matches with the correct letter, if so, appends the letter with a GREEN background
			if (inputWord.charAt(x) == word.charAt(x)) {
				output.append(" \u001B[42m" + inputWord.charAt(x) + "\u001B[0m");
				correctLetters++;
				continue;
			}
			
			// for loop that checks if the current letter exists in the word, if so, appends the letter with a YELLOW background
			for (int y = 0; y < word.length(); y++) {
				if (inputWord.charAt(x) == word.charAt(y)) {
					output.append(" \u001b[43m" + inputWord.charAt(x) + "\u001B[0m");
					inWord = true;
					break;
				}
			}
			
			// checks if the current letter does not exist in the word, if so, appends the letter with a RED background
			if (inputWord.charAt(x) != word.charAt(x) && !inWord) {
			output.append(" \u001b[41m" + inputWord.charAt(x) + "\u001B[0m");
			}
			
		}
		
		return output;
		
	}
}