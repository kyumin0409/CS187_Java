package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements
		BSTInterface<T> {
	
	protected BSTNode<T> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public BinarySearchTree(BSTNode<T> node){
		root = node;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return subtreeSize(root);
	}

	protected int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + subtreeSize(node.getLeft())
					+ subtreeSize(node.getRight());
		}
	}

	public boolean contains(T t) throws NullPointerException{
		// TODO
		if(t==null){
			throw new NullPointerException();
		}
		Iterator<T> iter = inorderIterator();
		while(iter.hasNext()){
			if(iter.next().equals(t))
				return true;
		}
		return false;
	}

	public boolean remove(T t) throws NullPointerException{
		if(t==null){
			throw new NullPointerException();
		}
		boolean result = contains(t);
		if (result) {
			root = removeFromSubtree(root, t);
		}
		return result;
	}

	private BSTNode<T> removeFromSubtree(BSTNode<T> node, T t) {
		// node must not be null
		int result = t.compareTo(node.getData());
		if (result < 0) {
			node.setLeft2(removeFromSubtree(node.getLeft(), t));
			return node;
		} else if (result > 0) {
			node.setRight2(removeFromSubtree(node.getRight(), t));
			return node;
		} else { // result == 0
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else { // neither child is null
				T predecessorValue = getHighestValue(node.getLeft());
				node.setLeft2(removeRightmost(node.getLeft()));
				node.setData(predecessorValue);
				return node;
			}
		}
	}

	private T getHighestValue(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getHighestValue(node.getRight());
		}
	}

	private BSTNode<T> removeRightmost(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getLeft();
		} else {
			node.setRight(removeRightmost(node.getRight()));
			return node;
		}
	}

	public T get(T t) throws NullPointerException{
		// TODO
		if(t == null)
			throw new NullPointerException();
		else{
			Iterator<T> iter = inorderIterator();
			while(iter.hasNext()){
				T data = iter.next();
				if(data.equals(t)){
					return data;
				}
			}
			return null;
		}
	}

	public void add(T t) throws NullPointerException{
		if(t==null){
			throw new NullPointerException();
		}
		root = addToSubtree(t, root);
	}

	private BSTNode<T> addToSubtree(T t, BSTNode<T> node) {
		if (node == null) {
			return new BSTNode<T>(t, null, null);
		}
		if (t.compareTo(node.getData()) <= 0) {
			node.setLeft(addToSubtree(t, node.getLeft()));
		} else {
			node.setRight(addToSubtree(t, node.getRight()));
		}
		return node;
	}

	@Override
	public T getMinimum() {
		// TODO
		if(size() == 0)
			return null;
		BSTNode<T> node = root; 
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node.getData();
	}

	@Override
	public T getMaximum() {
		// TODO
		if(size() == 0)
			return null;
		BSTNode<T> node = root;
		while(node.getRight() != null){
			node = node.getRight();
		}
		return node.getData();
	}


	@Override
	public int height() {
		// TODO
		if(size() == 0)
			return -1;
		else if(size()==1){
			return 0;
		}
		else{
			return recursiveHeight(root);
		}
	}
	
	private int recursiveHeight(BSTNode<T> node){
		if(node.getLeft()==null && node.getRight()==null){
			return 0;
		}
		else if(node.getLeft()==null){
			return 1+recursiveHeight(node.getRight());
		}
		else if(node.getRight() == null){
			return 1+recursiveHeight(node.getLeft());
		}
		else{
			return 1+recursiveHeight(node.getLeft())+recursiveHeight(node.getRight());
		}
	}

	@Override
	public Iterator<T> preorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		preorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void preorderTraverse(Queue<T> queue, BSTNode<T> node){
		if(node != null){
			queue.add(node.getData());
			preorderTraverse(queue, node.getLeft());
			preorderTraverse(queue, node.getRight());
		}
	}

	@Override
	public Iterator<T> inorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		inorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			inorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			inorderTraverse(queue, node.getRight());
		}
	}

	@Override
	public Iterator<T> postorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		postorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void postorderTraverse(Queue<T> queue, BSTNode<T> node){
		if(node != null){
			postorderTraverse(queue, node.getLeft());
			postorderTraverse(queue, node.getRight());
			queue.add(node.getData());
		}
	}

	@Override
	public boolean equals(BSTInterface<T> other) throws NullPointerException{
		// TODO
		if(other==null){
			throw new NullPointerException();
		}
		Iterator<T> iter1 = inorderIterator();
		Iterator<T> iter2 = other.inorderIterator();
		while(iter1.hasNext() && iter2.hasNext()){
			if(!(iter1.next().equals(iter2.next()))){
				return false;
			}
		}
		if(iter1.hasNext() || iter2.hasNext()){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean sameValues(BSTInterface<T> other) throws NullPointerException{
		// TODO
		if(other == null){
			throw new NullPointerException();
		}
		if(this.size() != other.size()){
			return false;
		}
		//BSTInterface<T> copyThis = this;
		//BSTInterface<T> copyOther = other;
		this.balance();
		other.balance();
		if (this.equals(other)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isBalanced() {
		// TODO
		if(size()==0)
			return true;
		if(Math.pow(2, height())<=size() && size()<Math.pow(2, (height()+1))){
			return true;
		}
		return false;
	}

	@Override
	public void balance() {
		// TODO
		Iterator<T> iter = inorderIterator();
		T[] arr = (T[]) new Comparable[size()];
		for(int i=0; i<arr.length; i++){
			arr[i]=iter.next();
		}
		BinarySearchTree<T> bst = new BinarySearchTree<T>();
		recursiveBalance(bst, arr, 0, arr.length-1);
		root = bst.getRoot();
		
	}
	
	private void recursiveBalance(BinarySearchTree<T> bst, T[] arr, int start, int end){
		if(start<=end){
			int mid = (start+end)/2;
			bst.add(arr[mid]);
			recursiveBalance(bst, arr, start, mid-1);
			recursiveBalance(bst, arr, mid+1, end);
		}
	}
	

	@Override
	public BSTNode<T> getRoot() {
		// DO NOT MODIFY
		return root;
	}

	public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
		// DO NOT MODIFY
		// see project description for explanation

		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.getLeft() != null) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getLeft().getData().toString() + ";\n";
				queue.add(cursor.getLeft());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}
			if (cursor.getRight() != null) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getRight().getData().toString() + ";\n";
				queue.add(cursor.getRight());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}
}