package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO

		/*for(int i=list.size()-1; i>0; i--){
			reheap(i);
			list.swap(i, 0);
		}*/
		for(int i = list.size()/2-1; i>=0; i--){
			reheap(i, list.size()-1);
		}
		for(int i = list.size()-1; i>=1; i--){
			list.swap(0, i);
			reheap(0, i-1);
		}
		
		
		
		return list;
	}
	
	private SwapList<T> reheap(int top, int index){
		int temp = top;
		int left = temp*2+1;
		int right = temp*2+2;
		while(left<index){
			if(list.compare(temp, left, comparator)>0 && list.compare(temp, right, comparator)>0){
				break;
			}
			else if(list.compare(temp, right, comparator)<0 && list.compare(temp, left, comparator)<0){
				if(list.compare(left, right, comparator)>0){
					list.swap(temp, left);
					temp = left;
				}
				else{
					list.swap(temp, right);
					temp = right;
				}
			}
			else{
				if(list.compare(temp, left, comparator)>0){
					list.swap(temp, right);
					temp = right;
				}
				else{
					list.swap(temp, left);
					temp = left;
				}
			}
			
			left = temp*2+1;
			right = temp*2+2;
		}
		
		if(left==index && list.compare(temp, left, comparator)<0){
			list.swap(temp, left);
		}
		return list;
	}
	
	/*private SwapList<T> reheap (int index){
		int parent = (index-1)/2;
		int current = index;
		if(parent<0){
			return list;
		}
		else if(list.compare(index, parent, comparator)>0){
			while(list.compare(current, parent, comparator)>0){
				list.swap(current, parent);
				current = parent;
				parent = (current-1)/2;
			}
			reheap(index);
		}
		else{
			reheap(index-1);
		}
		return list;
	}*/
}
