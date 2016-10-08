package graphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CollectionBasedGraphTest {

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
}
