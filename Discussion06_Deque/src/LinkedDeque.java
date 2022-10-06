
public class LinkedDeque<T> implements Deque<T> {

	private DLNode<T> head;
	private DLNode<T> tail;
	
	@Override
	public void addToFront(T element) {
		head = new DLNode<T>(element, head, null);
		if(head.getNext() == null) // this is the only element
			tail = head;
		else
			head.getNext().setPrev(head);
	}

	@Override
	public T removeFront() throws DequeUnderflowException {
		if(isEmpty()) throw new DequeUnderflowException();
		T data = head.getData();
		if(head.getNext() != null)
			head.getNext().setPrev(null);
		head = head.getNext();
		return data;
	}

	@Override
	public T first() throws DequeUnderflowException {
		if(isEmpty()) throw new DequeUnderflowException();
		return head.getData();
	}

	@Override
	public void addToRear(T element) {
		// TODO(1)
		tail = new DLNode<T>(element, null, tail);
		if(head == null)
			head = tail;
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public T removeRear() throws DequeUnderflowException {
		// TODO(2)
		if(isEmpty())
			throw new DequeUnderflowException();
		else{
			T data = tail.getData();
			if(tail==head){
				head = null;
				tail = null;
			}
			else{
				tail = tail.getPrev();
				tail.setNext(null);
			}
			return data;
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public T last() throws DequeUnderflowException {
		// TODO(3)
		if(isEmpty()){
			throw new DequeUnderflowException();
		}
		else{
			return tail.getData();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
