package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
  // TODO (1) choose appropriate attributes
	private LinkedNode<E> node;

  // Constructors
  public LinkedNodeIterator(LinkedNode<E> ln) {
    // TODO (2) choose appropriate parameters and do the initialization
	  node = ln;
  }

  @Override
  public boolean hasNext() {
    // TODO (3)
	  if(node == null){
		  return false;
	  }
	 
	  return true;
	  
  }

  @Override
  public E next() {
    // TODO (4)
	  if(hasNext() == false){
		  throw new NoSuchElementException();
	  }
	  else{
		  E data = node.getData();
		  node = node.getNext();
		  return data;
	  }
	  
  }

  // Leave this one alone.
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
