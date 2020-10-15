package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * This Tester JUnit class is made to test BalancedSymbolChecker, but specifically the method checkFile()
 * @author Krummenacher && Dixit
 *
 */
class ClassX
{
	/**
	 * this tests when the checkFile() method is not given a correct file.
	 */
	@Test
	void checkFile_fileNotFound()
	{
		assertThrows(FileNotFoundException.class, () -> {BalancedSymbolChecker.checkFile("ClassX.java");});
	}

	/**
	 * This tests the method checkFile() using Class1.java has input and should output a unmatchedSymbol() message.
	 */
	@Test
	void checkFile_Class1()
	{
		String result = "", answer = "ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.";
		try
		{
			result = BalancedSymbolChecker.checkFile("src\\assign06\\Class1.txt");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class2.java has input and should output a unmatchedSymbol() message.
	 */
	@Test
	void checkFile_Class2()
	{
		String result = "", answer = "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.";
		try
		{
			result = BalancedSymbolChecker.checkFile("Class2.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class3 .java has input and should output a allSymbolsMatch() message.
	 */
	@Test
	void checkFile_Class3()
	{
		String result = "", answer = "No errors found. All symbols match.";
		try
		{
			result = BalancedSymbolChecker.checkFile("Class3.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class4.java has input and should output a unfinishedComment() message.
	 */
	@Test
	void checkFile_Class4()
	{
		String result = "", answer = "ERROR: File ended before closing comment.";
		try
		{
			result = BalancedSymbolChecker.checkFile("Class4.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class5.java has input and should output a unmatchedSymbol() message.
	 */
	@Test
	void checkFile_Class5()
	{
		String result = "", answer = "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.";
		try
		{
			result = BalancedSymbolChecker.checkFile("Class5.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class6.java has input and should output a allSymbolsMatch() message.
	 */
	@Test
	void checkFile_Class6()
	{
		String result = "", answer = "No errors found. All symbols match.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class6.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class7.java has input and should output a unmatchedSymbol() message.
	 */
	@Test
	void checkFile_Class7()
	{
		String result = "", answer = "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class7.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class8.java has input and should output a umatchedSymbol() message.
	 */
	@Test
	void checkFile_Class8()
	{
		String result = "", answer = "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class8.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class9.java has input and should output a unmatchedSymbol() message.
	 */
	@Test
	void checkFile_Class9()
	{
		String result = "", answer = "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class9.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class10.java has input and should output a unmatchedSymbol() message.
	 */
	@Test
	void checkFile_Class10()
	{
		String result = "", answer = "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class10.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class11.java has input and should output a unmatchedSymbolAtEOF message.
	 */
	@Test
	void checkFile_Class11()
	{
		String result = "", answer = "ERROR: Unmatched symbol at the end of file. Expected }.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class11.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class12.java has input and should output a allSymbolsMatch() message.
	 */
	@Test
	void checkFile_Class12()
	{
		String result = "", answer = "No errors found. All symbols match.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class12.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class13.java has input and should output a allSymbolsMatch() message.
	 */
	@Test
	void checkFile_Class13()
	{
		String result = "", answer = "No errors found. All symbols match.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class13.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
	/**
	 * This tests the method checkFile() using Class14.java has input and should output a allSymbolsMatch() message.
	 */
	@Test
	void checkFile_Class14()
	{
		String result = "", answer = "No errors found. All symbols match.";
		try
		{
			result = BalancedSymbolChecker.checkFile("examples\\Class14.java");
		} catch (FileNotFoundException e)
		{
			System.out.println("file does not exist");
		}
		assertEquals(answer, result);
	}
	
}
