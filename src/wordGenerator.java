public class wordGenerator {
	private String word;
	private String hint;
	private String[] wordArray;
	int correctLetters = 0;
	
	public wordGenerator() throws Exception {
		
		Dictionary wordle1 = new Dictionary();
		wordArray = Dictionary.getRandom();
		word = wordArray[0];
		hint = wordArray[1];
	}
	
	public String getWord() {
		return word;
	}
	
	public String getHint() {
		return hint;
	}
	
	
	public StringBuilder getPlaceholders(String inputWord) {
		StringBuilder output = new StringBuilder();
		correctLetters = 0;
		
		for (int x = 0; x < word.length(); x++) {
			boolean inWord = false;
			
			if (inputWord.charAt(x) == word.charAt(x)) {
				output.append(" \u001B[42m" + inputWord.charAt(x) + "\u001B[0m");
				correctLetters++;
				continue;
			}
			
			for (int y = 0; y < word.length(); y++) {
				if (inputWord.charAt(x) == word.charAt(y)) {
					output.append(" \u001b[43m" + inputWord.charAt(x) + "\u001B[0m");
					inWord = true;
					break;
				}
			}
			
			if (inputWord.charAt(x) != word.charAt(x) && !inWord) {
			output.append(" \u001b[41m" + inputWord.charAt(x) + "\u001B[0m");
			}
			
		}
		
		return output;
		
	}
}