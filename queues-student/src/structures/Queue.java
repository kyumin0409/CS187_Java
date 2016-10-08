package structures;

import java.util.NoSuchElementException;


public class Queue<T> implements UnboundedQueueInterface<T> {
	
	private Node<T> qHead;
	private Node<T> qLast;
	private int size;
	
	public Queue() {
		// TODO 1
		qHead = null;
		qLast = null;
		size = 0;
	}
	
	public Queue(Queue<T> other) {
		// TODO 2
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		if(other.isEmpty()){
			qHead = null;
			qLast = null;
			size = 0;
		}
		else{
			qHead = null;
			qLast = null;
			size = 0;
			Node<T> curr = other.qHead;
			for(int i=0; i<other.size(); i++){
				this.enqueue(curr.getData());
				curr = curr.getNext();
			}
		}
	}
	
	@Override
	public boolean isEmpty() {
		// TODO 3
		return (size==0);
	}

	@Override
	public int size() {
		// TODO 4
		return size;
	}

	@Override
	public void enqueue(T element) {
		// TODO 5;
		Node<T> node = new Node<T>(element, null);
		if(size == 0){
			qHead = node;
			qLast = qHead;
			size++;
		}else{
			qLast.setNext(node);
			qLast = qLast.getNext();
			size++;
		}
		
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO 6;
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		}else{
			T data = qHead.getData();
			qHead = qHead.getNext();
			size--;
			return data;
		}
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		}
		return qHead.getData();
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
		// TODO 8
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		Queue<T> q = new Queue<T>();
		LinkedStack<T> stack = new LinkedStack<T>();
		Node<T> curr = qHead;
		while(curr != null){
			stack.push(curr.getData());
			curr = curr.getNext();
		}
		while(!stack.isEmpty()){
			q.enqueue(stack.pop());
		}
		//q.print();
		return q;
	}
	
	/*public void print(){
		if(isEmpty()){
			System.out.print("Queue is empty");
		}
		else{
			Node<T> curr = qHead;
			while(curr != null){
				System.out.print(curr.getData() + " ");
				curr = curr.getNext();
			}
		}
	}*/
}
