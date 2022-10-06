package structures;

import java.util.Comparator;
import java.util.Iterator;

import comparators.ReverseIntegerComparator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {

	private StudentArrayHeap<Integer,V> heap;
	private Comparator<Integer> comp;
	
	public MinQueue(){
		comp = new ReverseIntegerComparator();
		heap = new StudentArrayHeap<Integer,V>(comp);
	}
	
	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) throws NullPointerException{
		// TODO Auto-generated method stub
		if(priority==null || value==null)
			throw new NullPointerException();
		heap.add(priority, value);
		return this;
	}

	@Override
	public V dequeue() throws IllegalStateException{
		// TODO Auto-generated method stub
		if(heap.isEmpty())
			throw new IllegalStateException();
		V value = heap.remove();
		return value;
	}

	@Override
	public V peek() throws IllegalStateException{
		// TODO Auto-generated method stub
		if(heap.isEmpty())
			throw new IllegalStateException();
		V value = heap.peek();
		return value;
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		// TODO Auto-generated method stub
		return heap.asList().iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		// TODO Auto-generated method stub
		return comp;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heap.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (heap.isEmpty());
	}
}

