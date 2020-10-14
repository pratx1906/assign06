package assign06;

import static org.junit.jupiter.api.Assertions.*;

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
		strList.add(0, "c");
		strList.add(0, "e");
		strList.add(0, "a");
	}

	@Test
	void addFirstTest() {
		SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
		test.addFirst(1);
		assertEquals(test.getFirst(),1);
		
	}
	@Test
	void addFirstTest1() {
		SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
		
		test.add(0, 1);
		test.add(1, 3);
		test.add(2, 4);
		test.add(3, 7);
		assertEquals(test.get(0),1);
	}
	
	@Test
	void add() {
		SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
		test.add(0,0);
		test.add(1,2);
		test.add(2,3);
		
		assertEquals(test.get(0),0);
		
	}

}
