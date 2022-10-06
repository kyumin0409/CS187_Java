import java.util.List;

public class HeapSorter<T extends Comparable<T>> {

	/**
	 * Uses heapsort to in-place sort the list (changing the original list). 
	 * @param list The list to sort.
	 * @throws NullPointerException If the list is null.
	 */
	public void sort(List<T> list) {
		heapify(list);
		extract(list);
	}
	
	/**
	 * Swaps the elements at i1 and i2.
	 * @param list The list containing the elements to swap.
	 */
	private void swap(List<T> list, int i1, int i2) {
		T temp = list.get(i2);
		list.set(i2, list.get(i1));
		list.set(i1, temp);
	}
	
	/**
	 * Sifts an element down the heap to its correct position.
	 * Assuming the elements below it obey the heap rule,
	 * this will result in a valid heap from the start to the end index.
	 * @param list The list storing the heap that we are sifting down in.
	 * @param start The index of the element to sift down.
	 * @param end The last index of the heap (the end of the list may not be part of the heap).
	 */
	private void siftDown(List<T> list, int start, int end) {
		//TODO(1)
		T curr = list.get(start);
		int k = start;
		int i = (start*2)+1;
		int j = i+1;
		while(i<=end){
			T left = list.get(i);
			T right = list.get(j);
			if(left.compareTo(curr)>0){
				if(right.compareTo(left)>0){
					swap(list, k, j);
					k = j;
					i = (k*2)+1;
					j = i+1;
					curr = list.get(k);
				}else{
					swap(list, k, i);
					k = i;
					i= (k*2)+1;
					j = i+1;
					curr = list.get(k);
				}
			}else if(right.compareTo(curr)>0){
				swap(list, k, j);
				k=j;
				i=(k*2)+1;
				j=i+1;
				curr = list.get(k);
			}
			else{
				break;
			}
		}
		
	}

	/**
	 * Converts the provided list into a heap.
	 * @param list The list to heapify.
	 */
	private void heapify(List<T> list) {
		//TODO(2)
		int curr = list.size()-1;
		while(curr>=0){
			siftDown(list, curr, list.size()-1);
			curr--;
		}
		
	}
	
	/**
	 * Given a heap, it extracts from it a sorted list.
	 * @param list The list containing the heap; after finishing, it will be sorted.
	 */
	private void extract(List<T> list) {
		//TODO(3)
		
	}
}
