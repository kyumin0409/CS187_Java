import java.util.ArrayList;
import java.util.List;

public class InsertionSorter<T extends Comparable<T>> {

	public DLNode<T> head;
	public DLNode<T> tail;

	public List<T> sort(List<T> input, boolean ascending) {
		//reset the list
		head = null;
		tail = null;

		//insert
		for(int i = 0; i < input.size(); i++)
			insert(input.get(i));

		//insert(null);
		
		ArrayList<T> output = new ArrayList<T>();
		if(ascending){
			while(head != null)
			{
				output.add(head.getData());
				head = head.getNext();
			}
		}else{
			while(tail != null)
			{
				output.add(tail.getData());
				//System.out.println("tail: " + tail.getData() + "got added");
				tail = tail.getPrev();
				
			}
		}
		return output;
	}

	public void insert(T element) {
		if(head == null) // insert the first element (no others exist yet)
		{
			DLNode<T> node = new DLNode<T>(element, null, null);
			head = node;
			tail = node;
		}
		else if(element.compareTo(tail.getData()) > 0) //insert after the last element
		{
			tail = new DLNode<T>(element, null, tail);
			tail.getPrev().setNext(tail);
		}
		else if(element.compareTo(head.getData()) < 0) //insert before the first element
		{
			head = new DLNode<T>(element, head, null);
			head.getNext().setPrev(head);
		}
		else // insert into the middle of the list
		{
			DLNode<T> prev = null, current = head;
			while(element.compareTo(current.getData()) > 0)
			{
				prev = current;
				current = current.getNext();
			}
			DLNode<T> insert = new DLNode<T>(element, current, prev);
			prev.setNext(insert);
			
		}
	}
}
