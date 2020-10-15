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

	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println(checkFile("src/assign06/Class1.txt"));
	}
	
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
		Boolean commentedOut = false;		//intiate variables
		int lineNum = 0, colNum;
		String sentence;			
		Scanner fileIn;
		LinkedListStack<Character> theStack = new LinkedListStack<Character>();
		
		try									// pull in file and switch to a scanner.
		{
			fileIn = new Scanner(new File(filename));
			
		}
		catch(FileNotFoundException e)
		{
			throw new FileNotFoundException();
		}
		
		while(fileIn.hasNextLine())			// loop through the lines of the list.
		{
	
			sentence = fileIn.nextLine();	//loads in the full line
			
			colNum = 0;						//resets line indicators, and steps to the next line.
			lineNum++;
		
			sentence = sentence.substring(0, sentence.indexOf("//") == -1 ? sentence.length() : sentence.indexOf("//")); //edits out any single line comments
			sentence = sentence.replace("\\\"", "");				// removes any \"
			sentence = sentence.replace("\\\'", "");				// removes any \'
			
			for(int i = 0; i < sentence.length(); i++)				// searches through the sentence
			{
				switch(sentence.charAt(i))	// pops in and out
				{
					case '*':		//checks for comments
						if(i <= sentence.length() && sentence.charAt(i) == '/')
							commentedOut = false;
						break;
					case '/':
						if(i <= sentence.length() && sentence.charAt(i) == '*')
							commentedOut = true;
						break;
					case '\"':				//skip past " and '
						if(!commentedOut)
							i =+ sentence.substring(i).indexOf('\"') == -1 ? 0 : sentence.indexOf("\"");
						break;
					case '\'':
						if(!commentedOut)
							i =+ sentence.substring(i).indexOf('\'') == -1 ? 0 : sentence.indexOf("\'");
						break;
					case '{':		//Pushes in chars into the stack
						if(!commentedOut)	
							theStack.push('{');
						break;
					case '[':
						if(!commentedOut)	
							theStack.push('[');
						break;
					case '(':
						if(!commentedOut)	
							theStack.push('(');
						break;
					case '}':		//Pops out and compares chars
						if(!theStack.pop().equals('{') && !commentedOut) 
							return unmatchedSymbol(lineNum, i + 1, sentence.charAt(i), '}');
						break;
					case ']':
						if(!theStack.pop().equals('[') && !commentedOut)
							return unmatchedSymbol(lineNum, i + 1, sentence.charAt(i), ']');
						break;
					case ')':
						if(!theStack.pop().equals('(') && !commentedOut)
							return unmatchedSymbol(lineNum, i + 1, sentence.charAt(i), ')');
						break;
				}
			}
		}
		
		fileIn.close();
		if(commentedOut)				//checks if there are any unfinishedComment()
			return unfinishedComment();
		else if(!theStack.isEmpty())	//checks to see if the stack is full
			return unmatchedSymbolAtEOF(theStack.pop());
		
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