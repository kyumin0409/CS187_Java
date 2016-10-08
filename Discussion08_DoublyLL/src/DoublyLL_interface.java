



public interface DoublyLL_interface<T> {

	
	/**
     * Adds an element to the end of the linked list.
     * @param element The element to add to the end.
     */
    public void addAfter(T element, DLNode<T> insertAfter);
    
    /**
     * Remove the node in the list that is referenced in the argument
     * @param element The element to add to the end.
     */
	public void removeNode(DLNode<T> nodeToRemove);
	
	
    /**
     * Moves all the elements from "other" into the current list, after
     * the element insertAfter. If insertAfter is null, insert at the start
     * of the list.
     * Note: other list should be empty at the end of the process
     * @param element The element to add to the end.
     */
	public void moveInto(DList<T> other, DLNode<T> insertAfter);
	
	
	/**
     * Returns size of LL
     * @return size of LL
     */
    public int size();
	
//    /**
//     * Returns iterator
//     * @return iterator
//     */
//    public Iterator<T> iterator();
}

