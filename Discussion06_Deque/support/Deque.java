
public interface Deque<T> {
	/**
	 * Adds an element to the front of the queue.
	 * @param element The element to add to the front.
	 */
    public void addToFront (T element);
    
    /**
     * Removes an element from the front of the queue and returns it.
     * @return The front element of the queue (now removed).
     * @throws DequeUnderflowException if there was no element to remove.
     */
    public T removeFront() throws DequeUnderflowException;
    
    /**
     * Returns the first (front) element in the queue.
     * @return The first (front) element in the queue.
     * @throws DequeUnderflowException if there was no element to remove.
     */
    public T first() throws DequeUnderflowException;
    
    /**
     * Adds an element to the rear of the queue.
     * @param element The element to add to the rear.
     */
    public void addToRear(T element);
    
    /**
     * Removes an element from the rear of the queue and returns it.
     * @return The rear element of the queue (now removed).
     * @throws DequeUnderflowException if there was no element to remove.
     */
    public T removeRear() throws DequeUnderflowException;
    
    /**
     * Returns the last (back) element in the queue.
     * @return The first (back) element in the queue.
     * @throws DequeUnderflowException if there was no element to remove.
     */
    public T last()  throws DequeUnderflowException;
    
    /**
     * Returns whether the deque is empty.
     * @return Whether the deque is empty.
     */
    public boolean isEmpty();
    
    /**
     * Returns whether the deque is full. For unbounded implementations this will always return false.
     * @return Whether the deque is full.
     */
    public boolean isFull();
}
