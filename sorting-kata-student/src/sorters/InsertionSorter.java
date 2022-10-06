package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		
		for(int i=1; i<list.size(); i++){
			for(int j=i;  j>0; j--){
				if(list.compare(j, j-1, comparator)<0)
					list.swap(j, j-1);
				else
					break;
			}
		}
		return list;
	}
}
