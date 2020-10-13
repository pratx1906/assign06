package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTester {

	@Test
	void addFirstTest() {
		SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
		test.addFirst(1);
		assertEquals(test.getFirst(),1);
		
	}
//	@Test
//	void addFirstTest1() {
//		SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
//		
//		test.add(0, 1);
//		test.add(1, 3);
//		test.add(2, 4);
//		test.add(3, 7);
//		assertEquals(test.get(0),4);
//	}
	
	@Test
	void add() {
		SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
		test.add(0,0);
		test.add(1,2);
		test.add(2,3);
		assertEquals(test.get(0),0);
		
	}

}
