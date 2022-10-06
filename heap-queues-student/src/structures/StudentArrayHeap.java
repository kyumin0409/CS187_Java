package structures;

import java.util.Comparator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

	public StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getLeftChildOf(int index) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		if(index<0)
			throw new IndexOutOfBoundsException();
		return (index*2)+1;
	}

	@Override
	protected int getRightChildOf(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index<0)
			throw new IndexOutOfBoundsException();
		return (index*2)+2;
	}

	@Override
	protected int getParentOf(int index) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		if(index<1)
			throw new IndexOutOfBoundsException();
		return (index-1)/2;
	}

	@Override
	protected void bubbleUp(int index) {
		// TODO Auto-generated method stub
		Comparator<P> comp = getComparator();
		Entry<P,V> entry = heap.get(index);
		P priority = entry.getPriority();
		if(index<1){
			return;
		}
		int i = getParentOf(index);
		while(i >=0){
			Entry<P,V> c = heap.get(i);
			P tempP = c.getPriority();
			if(comp.compare(priority, tempP)>0){
				swap(index, i);
				index = i;
				if(index<1){
					break;
				}
				i = getParentOf(index);
			}
			else{
				break;
			}
		}
	}

	@Override
	protected void bubbleDown(int index) {
		// TODO Auto-generated method stub
		Comparator<P> comp = getComparator();
		Entry<P,V> entry = heap.get(index);
		P priority = entry.getPriority();
		int left = getLeftChildOf(index);
		int right = getRightChildOf(index);
		while(left<heap.size()-1){
			Entry<P,V> leftE = heap.get(left);
			Entry<P,V> rightE = heap.get(right);
			P leftP = leftE.getPriority();
			P rightP = rightE.getPriority();
			if(comp.compare(priority, leftP)>0 && comp.compare(priority, rightP)>0){
				break;
			}else if(comp.compare(priority, leftP)<0 && comp.compare(priority, rightP)<0){
				if(comp.compare(leftP, rightP)>0){
					swap(index, left);
					index = left;
					left = getLeftChildOf(index);
					right = getRightChildOf(index);
				}else{
					swap(index, right);
					index = right;
					left = getLeftChildOf(index);
					right = getRightChildOf(index);
				}
			}else if(comp.compare(priority, leftP)<0){
				swap(index, left);
				index = left;
				left = getLeftChildOf(index);
				right = getRightChildOf(index);
			}else{
				swap(index, right);
				index = right;
				left = getLeftChildOf(index);
				right = getRightChildOf(index);
			}
		}
	}
}
