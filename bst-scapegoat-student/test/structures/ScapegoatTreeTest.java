package structures;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.Timeout;

public class ScapegoatTreeTest {

	private BSTInterface<Integer> tree;

	@Rule
    public Timeout timeout = new Timeout(1L, TimeUnit.SECONDS);
	
	@Before
	public void before() {
		tree = new ScapegoatTree<Integer>();
	}
	
	@Test
	public void testAdd() {
		tree.add(0);
		tree.add(1);
		tree.add(2);
		tree.add(3);
		assertEquals(3, tree.height());
		//System.out.println(BinarySearchTree.toDotFormat(tree.getRoot()));
		tree.add(4);
		//System.out.println(BinarySearchTree.toDotFormat(tree.getRoot()));
		assertEquals(3, tree.height());
	}
	
	
	@Test
	public void testAdd2(){
		tree.add(3);
		tree.add(2);
		tree.add(1);
		tree.add(0);
		assertEquals(3, tree.height());
		tree.add(-1);
		System.out.println(BinarySearchTree.toDotFormat(tree.getRoot()));
		assertEquals(3, tree.height());
	}
	
	@Test 
	public void testRemove() {
		for (int i: new int[] {3, 1, 5, 0, 4, 2, 6} ) {
			tree.add(i);
		}

		for (int i: new int[] {1, 2, 0, 4}) {
			tree.remove(i);
		}
		
		BSTInterface<Integer> smallTree = new BinarySearchTree<Integer>();
		smallTree.add(5);
		smallTree.add(3);
		smallTree.add(6);
		
		assertTrue(tree.equals(smallTree));
	}
}
