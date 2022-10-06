package structures;

/**
 * A node in a BST.
 * 
 * Note that BSTNode MUST implement BSTNodeInterface; removing this will result
 * in your program failing to compile for the autograder.
 * 
 * You may need to modify this file when implementing ScapegoatTree.
 * 
 * @author liberato
 *
 * @param <T>
 */
public class BSTNode<T extends Comparable<T>> implements BSTNodeInterface<T> {
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;
	private BSTNode<T> parent;


	public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		parent = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
		left.setParent(this);
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
		right.setParent(this);
	}
	
	public BSTNode<T> getParent(){
		return parent;
	}
	
	public void setParent(BSTNode<T> parent){
		this.parent = parent;
	}

	public void setLeft2(BSTNode<T> left){
		this.left = left;
	}
	
	public void setRight2(BSTNode<T> right){
		this.right = right;
	}
	
	
}