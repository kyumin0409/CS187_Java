package graphs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArrayBasedGraphTest {

	private SimpleGraph<Integer> graph;

	@Before
	public void before() {
		graph = new CollectionBasedGraph<Integer>();
	}

	@Test
	public void testAddToNewGraph() {
		assertFalse(graph.hasVertex(100));
		graph.addVertex(100);
		assertTrue(graph.hasVertex(100));
	}
	
	

	@Test
	public void testVertexListSize() {
		for (int i = 0; i < 5; i++) {
			graph.addVertex(i);
		}
		assertEquals(5, graph.listVertices().size());
	}
	
	@Test
	public void testEdgeThatExists(){
		graph.addVertex(100);
		graph.addVertex(230);
		graph.addEdge(100, 230);
		assertTrue(graph.hasEdge(100, 230));
		
	}
	
	@Test
	public void testEdgeThatDoesntExist(){
		graph.addVertex(100);
		graph.addVertex(230);
		graph.addEdge(100, 230);
		assertFalse(graph.hasEdge(230, 100));
	}
	
	@Test
	public void testListVertices(){
		graph.addVertex(100);
		graph.addVertex(200);
		graph.addVertex(300);
		int[] arr = new int[3];
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		assertEquals(graph.listVertices(), Arrays.asList(arr));
	}
	
	@Test
	public void testListNeighbors(){
		graph.addVertex(100);
		graph.addVertex(200);
		graph.addVertex(300);
		graph.addEdge(200, 100);
		graph.addEdge(200, 300);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(300);
		assertEquals(graph.listNeighbors(200), list);
	}
	
}
