
/**
 * A doubly-linked node for use in linked lists.
 * @param <T> The data type to store inside the node.
 */
public class DLNode<T> {
	/**
	 * The data to which this node refers.
	 */
	private T data;

	/**
	 * The link to the next node in the chain.
	 */
	private DLNode<T> next;

	/**
	 * The link to the previous node in the chain.
	 */
	private DLNode<T> prev;

	/**
	 * Creates a {@code Node} with the specified data and next/previous links.
	 * @param data The data to store in the node.
	 * @param next The next node.
	 * @param prev The previous node.
	 */
	public DLNode(T data, DLNode<T> next, DLNode<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * Returns the data from this node.
	 * @return the data from this node.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Returns the next link from this node.
	 * @return The next node in the chain, which may be null.
	 */
	public DLNode<T> getNext() {
		return next;
	}

	/**
	 * Returns the previous link from this node.
	 * @return The previous node in the chain, which may be null.
	 */
	public DLNode<T> getPrev() {
		return prev;
	}

	/**
	 * Changes the data to which this node points.
	 * @param data The data to set.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Changes the next node to which this node points.
	 * @param next The next to set.
	 */
	public void setNext(DLNode<T> next) {
		this.next = next;
	}
	
	/**
	 * Changes the previous node to which this node points.
	 * @param prev The previous node to set.
	 */
	public void setPrev(DLNode<T> prev) {
		this.prev = prev;
	}
}
