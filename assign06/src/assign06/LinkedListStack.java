package assign06;

import java.util.NoSuchElementException;

/**
 * 
 * @author Krummenacher && Dixit
 *
 * @param <T>
 */
public class LinkedListStack<T> implements Stack<T> {

	private SinglyLinkedList<T> theStack;
	
	/**
	 * 
	 */
	public LinkedListStack()
	{
		this.theStack = new SinglyLinkedList<T>();
	}
	
	/**
	 * Removes all of the elements from the stack.
	 */
	public void clear()
	{
		this.theStack.clear();
	}

	/**
	 * @return true if the stack contains no elements; false, otherwise.
	 */
	public boolean isEmpty()
	{
		return this.theStack.isEmpty();
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	public T peek() throws NoSuchElementException
	{
		if(isEmpty())
			throw new NoSuchElementException();
		else
			return (T) this.theStack.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	public T pop() throws NoSuchElementException
	{
		if(isEmpty())
			throw new NoSuchElementException();
		return (T) this.theStack.removeFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(T element)
	{
		this.theStack.addFirst(element);
	}
	
	/**
	 * @return the number of elements in the stack
	 */
	public int size()
	{
		return this.theStack.size();
	}


	

}
