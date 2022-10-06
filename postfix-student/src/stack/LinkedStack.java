package stack;

import stack.StackInterface;
import stack.StackUnderflowException;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	int size = 0;
	LLNode<T> head = null;
	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new StackUnderflowException("The stack is empty");
		}
		else{
			LLNode<T> temp = head;
			head = head.getNext();
			size--;
			return temp.getData();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new StackUnderflowException("The stack is empty");
		}
		else{
			return head.getData();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		size++;
		LLNode<T> node = new LLNode<T>(elem);
		node.setNext(head);
		head = node;
	}

}
