package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

	private int size;
	private Node<T> head;
	
	public RecursiveList(){
		size = 0;
		head = null;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public ListInterface<T> insertFirst(T elem) throws NullPointerException{
		// TODO Auto-generated method stub
		if(elem == null){
			throw new NullPointerException();
		}
		else{
			Node<T> node = new Node<T>(elem, head);
			head = node;
			size++;
		}
		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) throws NullPointerException{
		// TODO Auto-generated method stub
		if(elem == null){
			throw new NullPointerException();
		}
		else{
			Node<T> node = new Node<T>(elem, null);
			if(isEmpty()){
				head = node;
			}else{
				Node<T> temp = head;
				Node<T> curr = getLastNode(temp);
				curr.setNext(node);
			}
			size++;
		}
		return this;
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) throws NullPointerException, IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		if(index<0 || index>size()){
			throw new IndexOutOfBoundsException();
		}
		if(elem == null){
			throw new NullPointerException();
		}
		else if(index == 0){
			Node<T> node = new Node<T>(elem, head);
			head = node;
		}
		else{
			Node<T> temp = head;
			Node<T> curr = nodeAt(index-1, 0, temp);
			Node<T> node = new Node<T>(elem, curr.getNext());
			curr.setNext(node);
		}
		size++;
		return this;
	}

	@Override
	public T removeFirst() throws IllegalStateException{
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalStateException();
		}
		else{
			T data = head.getData();
			head = head.getNext();
			size--;
			return data;
		}
	}

	@Override
	public T removeLast() throws IllegalStateException{
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalStateException();
		}
		else{
			if(size == 1){
				return removeFirst();
			}else{
				Node<T> temp = head;
				Node<T> beforeLast = nodeAt(size-2, 0, temp);
				T data = beforeLast.getNext().getData();
				beforeLast.setNext(null);
				size--;
				return data;
			}
		}
	}

	@Override
	public T removeAt(int i) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		if(i<0 || i>=size()){
			throw new IndexOutOfBoundsException();
		}
		else{
			if(i==0){
				T data = head.getData();
				removeFirst();
				return data;
			}
			else{
				Node<T> temp = head;
				Node<T> beforeIndex = nodeAt(i-1, 0, temp);
				Node<T> atIndex = beforeIndex.getNext();
				T data = atIndex.getData();
				beforeIndex.setNext(atIndex.getNext());
				size--;
				return data;
			}
		}
	}

	@Override
	public T getFirst() throws IllegalStateException{
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalStateException();
		}
		else{
			return head.getData();
		}
	}

	@Override
	public T getLast() throws IllegalStateException{
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalStateException();
		}
		else{
			Node<T> temp = head;
			Node<T> last = getLastNode(temp);
			return last.getData();
		}
	}

	@Override
	public T get(int i) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		if(i<0 || i>=size()){
			throw new IndexOutOfBoundsException();
		}
		else{
			Node<T> temp = head;
			Node<T> node = nodeAt(i, 0, temp);
			return node.getData();
		}
	}

	@Override
	public boolean remove(T elem) throws NullPointerException{
		// TODO Auto-generated method stub
		if(elem == null){
			throw new NullPointerException();
		}
		else{
			Node<T> temp = head;
			int index = indexOf(elem, temp, 0);
			if(index == -1){
				return false;
			}
			else if(index == 0){
				removeFirst();
				return true;
			}
			else{
				removeAt(index);
				return true;
			}
		}
	}

	@Override
	public int indexOf(T elem) throws NullPointerException{
		// TODO Auto-generated method stub
		if(elem == null){
			throw new NullPointerException();
		}
		else{
			Node<T> temp = head;
			return indexOf(elem, temp, 0);
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<T>(head);
	}

	private Node<T> getLastNode(Node<T> curr){
		if(curr.getNext()==null){
			return curr;
		}
		else{
			curr = curr.getNext();
			return getLastNode(curr);
		}
	}
	
	private Node<T> nodeAt(int i, int check, Node<T> list){
		if(i==check){
			return list;
		}else{
			list = list.getNext();
			return nodeAt(i, check+1, list);
		}
	}
	
	private int indexOf(T toFind, Node<T> toCheck, int currentIndex){
		if(currentIndex>=size()){
			return -1;
		}
		else{
			if(toFind.equals(toCheck.getData())){
				return currentIndex;
			}
			else{
				return indexOf(toFind, toCheck.getNext(), currentIndex+1);
			}
		}
	}
	
	/*public void print(){
		Iterator<T> iter = iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}*/
	
	
}
