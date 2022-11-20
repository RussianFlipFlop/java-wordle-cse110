import java.io.File;

import java.util.Scanner;

public class Dictionary 
{
	private static String[][] dictionary;
	private File words;
	private File definitions;
	public final static int NUM_OF_WORDS = 512;
	
	/**
	 * Creates Dictionary object
	 * 
	 * @throws Exception any file errors
	 */
	public Dictionary() throws Exception
	{
		//Create file objects that go into directory. Creates scanners that will process txt files.
		words = new File(System.getProperty("user.dir") + "/words.txt");
		definitions = new File(System.getProperty("user.dir") +"/definitions.txt");
		Scanner scanWord = new Scanner(words);
		Scanner scanDef1 = new Scanner(definitions);
	
		//Processes txt files into 2D Array
		dictionary = new String[NUM_OF_WORDS][2];
		int words = 0;
		int defs = 0;
		while(scanWord.hasNext())
		{
			dictionary[words][0] = scanWord.next();
			words++;
		}

		while(scanDef1.hasNextLine())
		{
			dictionary[defs][1] = scanDef1.nextLine();
			defs++;
		}
		
		//needed to create two separate files for the definitions because the whole file was too big for the scanner, not really sure why.
		definitions = new File(System.getProperty("user.dir") + "/definitions2.txt");
		Scanner scanDef2 = new Scanner(definitions);
		while(scanDef2.hasNextLine())
		{
			dictionary[defs][1] = scanDef2.nextLine();
			defs++;
		}
		
		//Close scanners.
		scanWord.close();
		scanDef1.close();
		scanDef2.close();
		
	}
	
	/**
	 * Finds a random word in the dictionary and returns the word and its definition.
	 * 
	 * @return String[] containing the word at index 0 and its definition at index 1.
	 */
	public static String[] getRandom()
	{
		double randomNumber = Math.random() * (NUM_OF_WORDS);
		
		return dictionary[(int)randomNumber];
	}
	
	/**
	 * Prints String containing the dictionary showing each word and its corresponding definition on each line.
	 * 
	 * @return String containing the entire dictionary
	 */
	public String toString()
	{
		String result= "";
		
		for (int i = 0; i < NUM_OF_WORDS; i++)
		{
			result += "Word: " + dictionary[i][0] + " Defn: " + dictionary[i][1] + "\n";
		}
		
		
		return result;
	}

}
