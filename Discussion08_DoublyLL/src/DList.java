
public class DList<T> implements DoublyLL_interface<T>{

	
	DLNode<T> head, tail;
	int size;

	@Override
	public void addAfter(T element, DLNode<T> insertAfter) {
		DLNode<T> insertBefore;
		
		//insert at the front
		if(insertAfter==null){
			insertBefore= head;
		}
		else{
			insertBefore= insertAfter.getNext();
		}
		
		DLNode<T> newNode= new DLNode<T>(element, insertBefore, insertAfter);
		
		//Setting next
		
		//if newNode is at the end of list
		if(newNode.getNext() ==null){
			tail= newNode;
		}
		else{
			newNode.getNext().setPrev(newNode);
		}

		//Setting prev
		
		//if newNode is at the start of list
		if(newNode.getPrev() ==null){
			head= newNode;
		}
		else{
			newNode.getPrev().setNext(newNode);
		}
		
		size++;
		
	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public void removeNode(DLNode<T> nodeToRemove) {
		// TODO Auto-generated method stub
		
		//WRITE YOUR CODE HERE
		DLNode<T> before = nodeToRemove.getPrev();
		DLNode<T> after = nodeToRemove.getNext();
		if(before == null){
			head = after;
		}else{
			
		}
		
		
		
		
		
		
	}


	@Override
	public void moveInto(DList<T> other, DLNode<T> insertAfter) {
		// TODO Auto-generated method stub
		
		//WRITE YOUR CODE HERE
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public void printList(){
		DLNode<T> curr=head;
		
		System.out.println("Your list is:");
		
		
		if(curr==null){
			System.out.println("empty");
		}
		else{
			while(curr!=null){
				System.out.println(curr.getData());
				curr=curr.getNext();
			}
		}
	}
	
}
