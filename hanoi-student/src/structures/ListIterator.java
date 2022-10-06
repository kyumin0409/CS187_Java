package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T>{
	private Node<T> node;
	
	public ListIterator(Node<T> n){
		node = n;
	}
	
	public boolean hasNext(){
		if(node == null)
			return false;
		else
			return true;
	}
	
	public T next() throws NoSuchElementException{
		if(hasNext() == false)
			throw new NoSuchElementException("There is no such element");
		else{
			T data = node.getData();
			node = node.getNext();
			return data;
		}
	}
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
}
