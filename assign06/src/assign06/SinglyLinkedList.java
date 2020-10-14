package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a singly linked list of generic data type. implements
 * List interface and has a nested node class for nodes creation and storing
 * data.
 * 
 * @author Dixit && Krummenacher
 * @param <E>
 *
 */
public class SinglyLinkedList<E> implements List<E> {

	/**
	 * Private Helper class to create nodes which are used to store data in Linked
	 * List and reference to the next node
	 * 
	 *
	 */
	private class Node {
		public E data;
		public Node next;

		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// Instances Variables
	private Node head;
	private int elementCount;

	/**
	 * Constructor to generate SinglyLinkList . intiallzes the intsnace variables .
	 */
	public SinglyLinkedList() {
		this.head = null;
		this.elementCount = 0;
	}

	/**
	 * Inserts an element at the beginning of the list. O(1) for a singly-linked
	 * list.
	 * 
	 * @param element - the element to add
	 */
	@Override
	public void addFirst(E element) {
		head = new Node(element, head); // Assigns the first value at head
		elementCount++;
	}

	/**
	 * Helper method to retrieve the node occurring in the list before the node at
	 * the given position.
	 * 
	 * NOTE: It is a precondition that targetIndex > 0.
	 * 
	 * @param targetIndex 0-indexed position of the node
	 * @return node at position targetIndex-1
	 */
	private Node getPrev(int targetIndex) {
		Node indexNode = head;
		for (int indexVal = 0; indexVal < targetIndex - 1; indexVal++)
			indexNode = indexNode.next;
		return indexNode;
	}

	/**
	 * Inserts an element at a specific position in the list. O(N) for a
	 * singly-linked list.
	 * 
	 * @param index   - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index > size())
	 */
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.elementCount) // Checks for valid parameters.
			throw new IndexOutOfBoundsException();
		if (index == 0) // Calls addfirst() if index is 0.
			addFirst(element);
		else {
			Node lastNode = getPrev(index); // Adds the reference to the new node.
			lastNode.next = new Node(element, lastNode.next);
			elementCount++; // Increase Size
		}

	}

	/**
	 * Gets the first element in the list. O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if (!this.isEmpty()) // Checks whether the ADT is empty or not
		{
			return this.head.data;
		} else // Catching Exception
		{
			throw new NoSuchElementException();
		}
	}

	/**
	 * Gets the element at a specific position in the list. O(N) for a singly-linked
	 * list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		Node resultNode = head; // A reference node which is used to provide result
		if (index < 0 || index > this.size()) // Conditions for proper parameters
			throw new IndexOutOfBoundsException();

		if (index == 0) // First Index
		{
			resultNode.data = getFirst();
		} else {
			resultNode = getPrev(index); // Acquiring value of the previous node
			resultNode = resultNode.next; // Updating it to the current value

		}
		return resultNode.data; // Value

	}

	/**
	 * Removes and returns the first element from the list. O(1) for a singly-linked
	 * list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public E removeFirst() throws NoSuchElementException {
		if (this.isEmpty()) // Checks for Exception
		{
			throw new NoSuchElementException();
		} else {
			Node tempRef = this.head;
			this.head = head.next; // Update the reference
			elementCount--;        // Decreasing Size
			return tempRef.data;
		}

	}

	/**
	 * Removes and returns the element at a specific position in the list. O(N) for
	 * a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		Node result = head; // A reference node which is used to provide result
		if (index < 0 || index > this.elementCount) // Condition Check
			throw new IndexOutOfBoundsException();
		if (index == 0) // First Index
			removeFirst();
		else {
			Node prev = getPrev(index);
			Node temp = prev; // Temporary node for the previous value
			Node curr = temp.next; // Updating References
			prev.next = curr.next;
			elementCount--; // Decreasing Size
			result = curr; // Making a copy to global Node for result.
		}
		return result.data;

	}

	/**
	 * Determines the index of the first occurrence of the specified element in the
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@Override
	public int indexOf(Object element) {
		int indexCheck = 0; // Initial Value starts from 0
		Node tempRef = head; // Reference Node
		while (tempRef != null) {
			if (tempRef.data.equals(element)) // Checks matching element type
				return indexCheck;
			else
				indexCheck++;
			tempRef = tempRef.next;
		}
		return -1; // If no such elemet is found
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return elementCount;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() {
		return elementCount == 0;
	}

	/**
	 * Removes all of the elements from this list. O(1) for a singly-linked list.
	 */
	@Override
	public void clear() {
		head = null;
		elementCount = 0;
	}

	/**
	 * Generates an array containing all of the elements in this list in proper
	 * sequence (from first element to last element). O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	@Override
	public Object[] toArray() {
		Object[] result = new Object[elementCount]; // Array Creation
		Node tempRef = head; // Pointer Node
		for (int i = 0; i < elementCount; i++) // Iterating through array
		{
			result[i] = tempRef.data; // Inputting Values
			tempRef = tempRef.next;
		}
		return result;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence (from
	 *         first element to last element)
	 */
	@Override
	public Iterator<E> iterator() {
		return new SinglyLinkedListIte(head);
	}

	private class SinglyLinkedListIte implements Iterator<E> {
		private Node curr;
		private Node prev;

		public SinglyLinkedListIte(Node current) {
			this.curr = current;
		}

		/**
		 * 
		 */
		@Override
		public boolean hasNext() {
			return curr != null;
		}

		/**
		 * 
		 */
		@Override
		public E next() {
			E temp = curr.data;
			prev = curr;
			if (!hasNext())
				throw new NoSuchElementException();
			else {
				curr = curr.next;
				return temp;
			}

		}

		@Override
		public void remove() {
			prev.next = curr.next;

			if (!hasNext())
				throw new NoSuchElementException();
			else {
				curr = curr.next;
			}
		}
	}

}
