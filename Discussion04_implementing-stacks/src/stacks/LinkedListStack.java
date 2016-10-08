package stacks;

public class LinkedListStack<T> implements Stack<T> {
    LLNode<T> head;

    public LinkedListStack() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
    	if(head == null){
    		return true;
    	}
    	else{
    		return false;
    	}






	


	
	
    }
    
    @Override
    public T pop() throws StackUnderflowException {
        if(isEmpty()){
        	throw new StackUnderflowException("Stack is empty");
        }
        else{
        	LLNode<T> temp = head;
        	LLNode<T> rest = head.getLink();
        	head = rest;
        	return temp.getInfo();
        }






	


	

	
    }

    @Override
    public T peek() throws StackUnderflowException {
        if(isEmpty()){
        	throw new StackUnderflowException("Stack is empty");
        }
        else{
        	return head.getInfo();
        }





	



	


	
    }

    @Override
    public void push(T element) {
    	LLNode<T> node = new LLNode<T>(element);
    	node.setLink(head);
    	head = node;




	






	
    }


}
