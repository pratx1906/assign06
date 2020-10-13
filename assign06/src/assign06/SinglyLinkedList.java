package assign06;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Dixit && Krummenacher
 * @param <E>
 *
 */
public class SinglyLinkedList<E> implements List<E>{

	/**
	 * Private Helper class to create nodes which are used to store data in Linked List and reference to the next node
	 * 
	 *
	 */
	private class Node 
	{
		public E data;
		public Node next;
		public Node(E data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
	//Instances Variables
	private Node head;
	private int elementCount;
	
	/**
	 * Constructor to generate SinglyLinkList . intiallzes the intsnace variables .
	 */
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
	public void addFirst(E element) 
	{
		head = new Node(element, head); 
		elementCount++;
	}
	
	/**
	 * Helper method to retrieve the node occurring in the list before the
	 * node at the given position.
	 * 
	 * NOTE: It is a precondition that pos > 0.
	 * 
	 * @param targetIndex 0-indexed position of the node
	 * @return node at position pos-1
	 */
	private Node getPrev(int targetIndex) {
		Node temp = head;
		for(int i = 0; i < targetIndex-1; i++)
			temp = temp.next;
		return temp;
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
	public void add(int index, E element) throws IndexOutOfBoundsException //TA note, best way to iterate through this.
	{
		if(index<0 || index>this.elementCount)
			throw new IndexOutOfBoundsException();
		if(index==0)
		{
			addFirst(element);	
		}
		else
		{
		
		Node lastNode = getPrev(index);
		lastNode.next= new Node(element,lastNode.next);
		elementCount++;
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
	public E getFirst() throws NoSuchElementException 
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
	public E get(int index) throws IndexOutOfBoundsException 
	{

		Node res = head;
		if(index<0 || index>this.size())
			throw new IndexOutOfBoundsException();
		
		if(index==0)
		{
			res.data=getFirst();
		}
		else
		{
			res = getPrev(index);
			res = res.next;
			
		}
		return res.data;
		
	}

	/**
	 * Removes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public E removeFirst() throws NoSuchElementException
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		else
		{
		Node temp = this.head;
		this.head = head.next;
		return temp.data;
		}
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
	public E remove(int index) throws IndexOutOfBoundsException //TA note, best way to interate through this.
	{
		if(index<0 || index>this.elementCount)
			throw new IndexOutOfBoundsException();
		if(index==0)
			removeFirst();
		
		Node prev = getPrev(index);
		Node temp = prev;
		Node curr = temp.next;
		prev.next = curr.next;
		elementCount--;
		return curr.data;
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
		
		Node temp = head;
		for(int i = 0; i < elementCount; i++)
		{
			result[i] = temp.data;
			temp = temp.next;
		}
		
		return result;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence 
	 * (from first element to last element)
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return new SinglyLinkedListIte(head);
	}

	private class SinglyLinkedListIte implements Iterator<E>
	{
		private Node curr;
		private Node prev;
	
		public SinglyLinkedListIte(Node current)
		{
			this.curr = current;
		}
		
		/**
		 * 
		 */
		@Override
		public boolean hasNext() 
		{			
			return curr != null;
		}

		/**
		 * 
		 */
		@Override
		public E next() 
		{
			E temp = curr.data;		
			prev = curr;
			if(!hasNext())
				throw new NoSuchElementException();
			else
			{
				curr = curr.next;
				return temp;
			}
			
		}
		
		@Override
		public void remove()	//TA note: Check the logic required to delete an object in memory.
		{			
			prev.next = curr.next;
			
			if(!hasNext())
				throw new NoSuchElementException();
			else
			{
				curr = curr.next;
			}
		}
		
		
		/** 
		 * Generates and returns a textual representation of the integers in this
		 * linked list, in order.
		 */
		public String toString() {
			
			StringBuilder result = new StringBuilder();
			Node temp = head;
			while(temp != null) {
				result.append(temp.data + " ");
				temp = temp.next;
			}
			return result.toString();
		}

	}
	public static void main(String[] args) {

		SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
		l.addFirst(2);
		l.add(1, 2);
		l.add(2, 3);
		l.add(3, 5);
		l.add(2, 35);
		System.out.println(Arrays.toString(l.toArray()));
		
}
}
