package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Iterable;

public class ListImplementation<T> implements ListInterface<T>{
	private int size;
	private Node<T> head;
	private Node<T> last;
	
	public ListImplementation(){
		size = 0;
		head = null;
		last = null;
	}
	
	public ListImplementation(Node<T> h){
		size = 0;
		head = h;
		last = h;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public T get(int n) throws NoSuchElementException{
		Node<T> curr = head;
		if(n>=size || n<0)
			throw new NoSuchElementException("There is no such element");
		for(int i=0; i<n; i++){
			curr = curr.getNext();
		}
		return curr.getData();
	}
	
	public ListInterface<T> append(T elem) throws NullPointerException{
		if(elem == null)
			throw new NullPointerException("Elem is null");
		Node<T> node = new Node<T>(elem, null);
		if(last == null){
			head = node;
			last = node;
			size++;
			return this;
		}
		else{
			last.setNext(node);
			last = last.getNext();
			size++;
			return this;
		}
		
	}
	
	public Iterator<T> iterator(){
		Iterator<T> iter = new ListIterator<T>(head);
		return iter;
	}
	
	public Node<T> end(){
		Iterator<T> iter = iterator();
		Node<T> curr = head;
		iter.next();
		while(iter.hasNext()){
			iter.next();
			curr = curr.getNext();
		}
		return curr;
	}
}
