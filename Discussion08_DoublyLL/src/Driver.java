
public class Driver {

	public static void test_remove(){
		DList<Integer> dLL= new DList<Integer>();
		dLL.addAfter(1, null);				
		dLL.addAfter(2, dLL.head);
		dLL.addAfter(3, dLL.head.getNext());
		dLL.printList();

		//WRITE YOUR CODE HERE TO TEST REMOVENODE METHOD
		//call removenode for different cases, print out the list and see if that's what you expect

		
		
		
		
		
		
		
		
	}
	
	public static void test_moveInto(){
		DList<Integer> dLL= new DList<Integer>();
		dLL.addAfter(1, null);				
		dLL.addAfter(2, dLL.head);
		dLL.addAfter(3, dLL.head.getNext());
		dLL.printList();

		//WRITE YOUR CODE HERE TO TEST MOVEINTO METHOD
		//call removenode for different cases, print out the list and see if that's what you expect
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args){
		test_remove();
		test_moveInto();
	}
}
