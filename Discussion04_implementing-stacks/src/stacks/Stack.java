package stacks;

/**
 * A Stack represents a last-in-first-out (LIFO) stack of objects.
 *
 * @param <T> the type of elements in the stack
 */
public interface Stack<T> {

    /**
     * Removes and returns the top element on this stack.
     * @return the top element
     * @throws StackUnderflowException if the stack is empty
     */
    public T pop() throws StackUnderflowException;


    /**
     * @return the top element of this stack
     * @throws StackUnderflowException if the stack is empty
     */
    public T peek() throws StackUnderflowException;

    /**
     * Pushes element to the top of this stack.
     */
    public void push(T element);

    /**
     * @return true if and only if the stack contains no elements
     */
    public boolean isEmpty();
}
