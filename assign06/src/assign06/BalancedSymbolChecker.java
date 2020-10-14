package assign06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Erin Parker && Krummenacher && Dixit
 * @version 1.1
 */
public class BalancedSymbolChecker {

	/**
	 * Generates a message indicating whether the input file has unmatched
	 * symbols. (Use the helper methods below for constructing messages.)
	 * 
	 * @param filename - name of the input file to check
	 * @return a message indicating whether the input file has unmatched symbols
	 * @throws FileNotFoundException if the file does not exist
	 */
	public static String checkFile(String filename) throws FileNotFoundException 
	{
		String sentence;
		int line = 0, colNum;
		Scanner fileIn;
		LinkedListStack<T> theStack = new LinkedListStack<T>();
		
		try
		{
			fileIn = new Scanner(new File(filename));
			
		}
		catch(FileNotFoundException e)
		{
			throw new FileNotFoundException();
		}
		
		while(fileIn.hasNext())
		{
			sentence = fileIn.next();
			colNum = 1;
			line++;
			for(int i = 0; i < sentence.length(); i++)
			{
				if(sentence.charAt(i) == '{' || sentence.charAt(i) == '[' || sentence.charAt(i) == '(')
				{
					theStack.push(sentence.charAt(i));
				}
				else if(sentence.charAt(i) == '}' || sentence.charAt(i) == ']' || sentence.charAt(i) == ')')
				{
					if()
				}
			}
		}
		
		fileIn.close();
		
		return allSymbolsMatch();
	}

	/**
	 * Use this error message in the case of an unmatched symbol.
	 * 
	 * @param lineNumber - the line number of the input file where the matching symbol was expected
	 * @param colNumber - the column number of the input file where the matching symbol was expected
	 * @param symbolRead - the symbol read that did not match
	 * @param symbolExpected - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
				+ ", but read " + symbolRead + " instead.";
	}

	/**
	 * Use this error message in the case of an unmatched symbol at the end of the file.
	 * 
	 * @param symbolExpected - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Use this error message in the case of an unfinished comment
	 * (i.e., a file that ends with an open /* comment).
	 * 
	 * @return the error message
	 */
	private static String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Use this message when no unmatched symbol errors are found in the entire file.
	 * 
	 * @return the success message
	 */
	private static String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}