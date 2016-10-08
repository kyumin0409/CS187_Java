package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		
		/*
		 * Note: When choosing a pivot, choose the element in the middle of
		 * the sub-array. That is,
		 * 
		 * pivotIndex = (firstIndex + lastIndex) / 2;
		 */
		
		return separation(0, list.size()-1);
	}
	
	private SwapList<T> separation(int first, int last){
		if(first<last){
			int pivot = divide(first, last);
			separation(first, pivot-1);
			separation(pivot+1, last);
		}
		return list;
	}
	
	private int divide(int first, int last){
		int pivot = (first+last)/2;
		list.swap(pivot, last);
		int current = first;
		for(int i = first; i<last; i++){
			if(list.compare(i, last, comparator)<=0){
				list.swap(i, current);
				current++;
			}
		}
		list.swap(last, current);
		return current;
	}
}