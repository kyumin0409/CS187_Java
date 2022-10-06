package structures;

public class ScapegoatTree<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	private int upperBound;
	
	/**
	 * Adds an element to the tree.
	 * 
	 * The modified tree must still obey the BST rule, though it might not be
	 * balanced.
	 * 
	 * In addition to obeying the BST rule, the resulting tree must also obey
	 * the scapegoat rule. 
	 * 
	 * This method must only perform rebalancing of subtrees when indicated
	 * by the scapegoat rule; do not unconditionally call balance() 
	 * after adding, or you will receive no credit. 
	 * See the project writeup for details.
	 * 
	 * @param element
	 * @throws NullPointerException if element is null
	 */
	@Override
	public void add(T element) throws NullPointerException{
		// TODO
		//System.out.println("*********");
		//System.out.println("beginning height: " + this.height());
		if(element == null){
			throw new NullPointerException();
		}
		upperBound++;
		//System.out.println("upperbound: " + upperBound);
		super.add(element);
		//System.out.println("after adding height: " + this.height());
		if(height()>(Math.log(upperBound))/Math.log(1.5)){
			//System.out.println("if statement");
			BSTNode<T> scapegoat = findScapegoat(findNode(root, element));
			System.out.println("scapegoat is: " + scapegoat.getData());
			//System.out.println("scapegoat parent is: " + scapegoat.getParent().getData());
			BSTInterface<T> tree = getSubtree(scapegoat);
			tree.balance();
			
			BSTNode<T> newnode = tree.getRoot();
			//System.out.println(BinarySearchTree.toDotFormat(newnode));
			//System.out.println("*");
			
			//System.out.println(BinarySearchTree.toDotFormat(scapegoat));
			//System.out.println("current height is: " + this.height());
			//scapegoat.setData(newnode.getData());
			//System.out.println("current height is: " + this.height());
			//scapegoat.setLeft(newnode.getLeft());
			//System.out.println("current height is: " + this.height());
			//scapegoat.setRight(newnode.getRight());
			//System.out.println("current height is: " + this.height());
			//scapegoat.setParent(newnode.getParent());
			//System.out.println("HEIGHT: " + this.height());*/
			
			//scapegoat = newnode;
			
			/*System.out.println("scapegoat parent: " + scapegoat.getParent().getData());
			newnode.setParent(scapegoat.getParent());
			System.out.println("newnode parent: " + newnode.getParent().getData());
			
			scapegoat.getParent().setData(newnode.getParent().getData());
			scapegoat.getParent().setLeft2(newnode.getParent().getLeft());
			scapegoat.getParent().setRight2(newnode.getParent().getRight());
			
			BSTNode<T> node = scapegoat;
			while(node.getParent() != null){
				node = node.getParent();
			}
			root = node;*/
			
			BSTNode<T> aboveSG = scapegoat.getParent();
			if(aboveSG == null){
				root = scapegoat;
			}else{
				scapegoat = newnode;
				//System.out.println(BinarySearchTree.toDotFormat(scapegoat));
				T dataSG = scapegoat.getData();
				T dataA = aboveSG.getData();
				if(dataA.compareTo(dataSG)>=0){
					aboveSG.setLeft2(scapegoat);
				}else{
					aboveSG.setRight2(scapegoat);
				}
			}
			
			//System.out.println(BinarySearchTree.toDotFormat(root));
		}
	}
	
	
	
	private BSTNode<T> findScapegoat(BSTNode<T> node){
		//System.out.println("+++++++++++++ node: " + node.getData());
		if(node == null){
			return null;
		}
		if((double)subtreeSize(node)/subtreeSize(node.getParent())>2.0/3){
			return node.getParent();
		}
		//System.out.println("*%*%*%*%** " + node.getParent().getData());
		return findScapegoat(node.getParent());
	}
	
	private BSTNode<T> findNode(BSTNode<T> node, T element){
		//System.out.println("----------- elem: " + element);
		//System.out.println("node: " + node.getData());
		if(node.getData().equals(element)){
			return node;
		}
		else if(element.compareTo(node.getData())>0){
			return findNode(node.getRight(), element);
		}
		else{
			return findNode(node.getLeft(), element);
		}
	}
	
	private BSTInterface<T> getSubtree(BSTNode<T> node){
		return new BinarySearchTree<T>(node);
	}
	
	/**
	 * Attempts to remove one copy of an element from the tree, returning true
	 * if and only if such a copy was found and removed.
	 * 
	 * The modified tree must still obey the BST rule, though it might not be
	 * balanced.
	 * 
	 * In addition to obeying the BST rule, the resulting tree must also obey
	 * the scapegoat rule.
	 * 
	 * This method must only perform rebalancing of subtrees when indicated
	 * by the scapegoat rule; do not unconditionally call balance() 
	 * after removing, or you will receive no credit. 
	 * See the project writeup for details.

	 * @param element
	 * @return true if and only if an element removed
	 * @throws NullPointerException if element is null
	 */
	@Override
	public boolean remove(T element) throws NullPointerException{
		// TODO
		if(element == null){
			throw new NullPointerException();
		}
		boolean exists = super.remove(element);
		if(upperBound>2*size()){
			balance();
			return exists;
		}else{
			return exists;
		}
	}

}
