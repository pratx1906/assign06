package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTester
{

	LinkedListStack<Integer> theStack;
	
	@BeforeEach
	void setup()
	{
		theStack = new LinkedListStack<Integer>();
		
		theStack.push(1);
		theStack.push(2);
		theStack.push(3);
		theStack.push(4);
	}
	@Test
	void clear()
	{
		clear();
		assertEquals(theStack.size(), 0);
	}
	
	@Test
	void isEmpty()
	{
		fail("Not yet implemented");
	}

	@Test
	void peek()
	{
		fail("Not yet implemented");
	}
	
	@Test
	void pop()
	{
		fail("Not yet implemented");
	}
	
	
	@Test
	void push()
	{
		fail("Not yet implemented");
	}
	
	@Test
	void size()
	{
		fail("Not yet implemented");
	}
}
