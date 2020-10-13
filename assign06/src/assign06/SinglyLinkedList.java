package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Dixit && Krummenacher
 * @param <T>
 *
 */
public class SinglyLinkedList<T> implements List<T>{

	private Node head;
	private int elementCount;
	
	private class Node 
	{
		public T data;
		public Node next;
		public Node(T data, Node next)
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
	public void addFirst(T element) 
	{
		head = new Node(element, head); 
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
	public void add(int index, T element) throws IndexOutOfBoundsException //TA note, best way to iterate through this.
	{
		if(index<0 || index>this.elementCount)
			throw new IndexOutOfBoundsException();
		if(index==0)
			addFirst(element);
		
		Node temp = head;
		for(int i=1; i<=index ; i++)
		{
			temp = temp.next;
		}
		
	}

	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public T getFirst() throws NoSuchElementException 
	{
		if(!this.isEmpty())
		{
			return this.head.data;
		}
		else
		{
			throw new NoSuchElementException();
		}
		
		
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
	public T get(int index) throws IndexOutOfBoundsException //TA note, best way to iterate through this.
	{
		
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
	public T removeFirst() throws NoSuchElementException
	{
		Node temp = this.head;
		this.head = head.next;
		return temp.data;
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
	public T remove(int index) throws IndexOutOfBoundsException //TA note, best way to interate through this.
	{
		if(index<0 || index>this.elementCount)
			throw new IndexOutOfBoundsException();
		if(index==0)
			removeFirst();
		
		
		
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
	public int indexOf(Object element) 
	{
		int indexCheck =0 ;
		Node temp = head;
		while(temp!=null)
		{
			if(temp.data.equals(element))
				return indexCheck;
			else
				indexCheck++;
			temp=temp.next;
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
			//result[i] = 
		}
		
		return result;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence 
	 * (from first element to last element)
	 */
	@Override
	public Iterator<T> iterator() 
	{
		return new SinglyLinkedListIte();
	}

	private class SinglyLinkedListIte implements Iterator<T>
	{

		private Node curr;
		
		public SinglyLinkedListIte()
		{
			this.curr=head;
		}
		@Override
		public boolean hasNext() {			
			return curr!=null;
		}

		@Override
		public T next() {
			T temp = curr.data;		
			curr = curr.next;
			return temp;
		}
		
		
	}
}
