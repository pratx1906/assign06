package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class SinglyLinkedListTester {
	
	private SinglyLinkedList<Integer> intList;
	private SinglyLinkedList<String> strList;
	@BeforeEach
	public void setUp() {
		intList = new SinglyLinkedList<>();
		strList = new SinglyLinkedList<>();
		
		intList.add(0, 1);
		intList.add(1, 2);
		intList.add(2, 4);
		intList.add(3, 6);
		intList.add(4, 8);
		
		strList.add(0, "a");
		strList.add(1, "c");
		strList.add(2, "e");
		strList.add(3, "g");
	}

	/**
	 * Checks addFirst() method. Gets proper working
	 */
	@Test
	void addFirstTestInt() {
		int testVal=10;
		intList.addFirst(testVal);
		assertEquals(intList.get(0),testVal);	
	}
	/**
	 * Checks addFirst Method. Also generic implementation.
	 */
	@Test
	void addFirstTestString() {
		String strTest = "hello";
		strList.addFirst(strTest);
		assertEquals(strList.get(0),strTest);
	}
	/**
	 * Checks get method working in normal case
	 */
	@Test
	void getTest()
	{
		int testVal = 6;
		assertEquals(intList.get(3),testVal);
	}
	
	/**
	 * Checks get() method for empty Singly Linked List.
	 */
	@Test
	void getTestFail()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> {(new SinglyLinkedList<Integer>()).get(2);});
	}
	
	/**
	 * Checks for getFirstMethod() working case
	 */
	@Test
	void getFirstTest()
	{
		String test = "a";
		assertEquals(strList.getFirst(),test);
	}
	
	/**
	 * Checks getFirst Method on empty Singly Linked List.
	 */
	@Test
	void getFirstException()
	{
		assertThrows(NoSuchElementException.class, () -> {(new SinglyLinkedList<Integer>()).getFirst();});
	}
	
	/**
	 * Checks the Size Method
	 */
	@Test
	void sizeTest()
	{
		int expectedSize = 5;
		assertEquals(intList.size(),expectedSize);
	}
	/**
	 * Checks the Size Method on empty Linked List.
	 */
	@Test
	void sizeTestEmpty()
	{
		int expectedSize = 0;
		assertEquals((new SinglyLinkedList<Integer>()).size(),expectedSize);
	}
	
	/**
	 * Checks for isEmpty method.
	 */
	@Test
	void isEmpty()
	{
		assertEquals(strList.isEmpty(),false);
	}
	
	/**
	 * Checks the clear() method working
	 */
	@Test
	void clearTest() 
	{
		intList.clear();
		assertEquals(intList.isEmpty(),true);
	}
	/**
	 * Checks the clear() method working with size
	 */
	@Test
	void clearTestSize() 
	{
		intList.clear();
		assertEquals(intList.size(),0);
	}
	
	/**
	 * add method test at random index
	 */
	@Test
	void addTest()
	{
		int test = 7;
		intList.add(4, test);
		assertEquals(intList.get(4),test);
	}
	/**
	 * Test for add method at first index.
	 */
	@Test
	void addTestLastVal()
	{
		Integer [] result = new Integer[] {0,1,2,4,6,8};
		intList.add(0, 0);
		assertArrayEquals(intList.toArray(),result);
	}
	/**
	 * Adding at non existent index 
	 */
	@Test
	void addTestFail()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> {intList.add(8, 28);;});
	}
	
	/**
	 * Test for removeFirst method
	 * 
	 */
	@Test
	void removeFirst()
	{
		String [] result = new String[] {"c","e","g"};
		String exp = strList.removeFirst();
		assertArrayEquals(strList.toArray(),result);
	}
	
	@Test
	void removeFirstEmpty()
	{
		assertThrows(NoSuchElementException.class, () -> {(new SinglyLinkedList<Integer>()).removeFirst();});
	}
	
	
	
	
	
	
	
	
}
