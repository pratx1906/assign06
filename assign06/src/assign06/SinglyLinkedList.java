package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Dixit && Krummenacher
 * @param <T>
 *
 */
public class SinglyLinkedList<T> implements List {

	private Node head;
	private int elementCount;
	
	private class Node 
	{
		public Object data;
		public Node next;
		public Node(Object data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	public SinglyLinkedList()
	{
		this.head = null;
		this.elementCount = 0;
	}
	
	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	@Override
	public void addFirst(Object element) 
	{
		head = new Node(element, head); //TA note, will this cause an error?
		elementCount++;
	}

	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range 
	 * (index < 0 || index > size())
	 */
	@Override
	public void add(int index, Object element) throws IndexOutOfBoundsException //TA note, best way to iterate through this.
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public Object getFirst() throws NoSuchElementException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range 
	 * (index < 0 || index >= size())
	 */
	@Override
	public Object get(int index) throws IndexOutOfBoundsException //TA note, best way to iterate through this.
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Removes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public Object removeFirst() throws NoSuchElementException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Removes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range 
	 * (index < 0 || index >= size())
	 */
	@Override
	public Object remove(int index) throws IndexOutOfBoundsException //TA note, best way to interate through this.
	{
		
		
		
		return null;
	}

	/**
	 * Determines the index of the first occurrence of the specified 
	 * element in the list, or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@Override
	public int indexOf(Object element) //TA note, best way to interate through this.
	{
		for(int i = 0; i < elementCount; i++)
		{
			result[i] = 
		}
		return -1;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() 
	{
		return elementCount;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() 
	{
		return elementCount == 0;
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	@Override
	public void clear() 
	{
		head = null;
		elementCount = 0;
	}

	/**
	 * Generates an array containing all of the elements in this list in proper 
	 * sequence (from first element to last element).
	 * O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	@Override
	public Object[] toArray() //TA note, best way to interate through this.
	{
		Object[] result = new Object[elementCount];
		
		for(int i = 0; i < elementCount; i++)
		{
			result[i] = 
		}
		
		return result;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence 
	 * (from first element to last element)
	 */
	@Override
	public Iterator iterator() 
	{
		Iterator result = (Iterator) head;
		
		return null;
	}

}
