package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T>{

	private Node<T> node;
	
	public ListIterator(Node<T> node){
		this.node = node;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(node == null){
			return false;
		}
		return true;
	}

	@Override
	public T next() throws NoSuchElementException{
		// TODO Auto-generated method stub
		if(hasNext() == false){
			throw new NoSuchElementException();
		}
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
