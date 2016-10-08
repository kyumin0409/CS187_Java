package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListInterfaceTest {

	private ListInterface<String> list;
	//private ListInterface<String> list2;
	
	@Before
	public void setup(){
          list = new RecursiveList<String>();
         // list2 = new RecursiveList<String>();
	}
	
	@Test (timeout = 500)
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
		list.insertFirst("world");
		assertEquals(2, list.size());
		list.insertFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
	}
	
	@Test (timeout = 500)
	public void testInsertLastAndGetLast(){
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertEquals(list, list.insertLast("hello"));
		assertEquals("hello", list.getLast());
		list.insertLast("bye");
		assertEquals("bye", list.getLast());
		assertEquals("hello", list.getFirst());
		assertEquals(2, list.size());
	}
	
	@Test (timeout = 500)
	public void testInsertAtAndGet(){
		assertTrue(list.isEmpty());
		assertEquals(list, list.insertAt(0, "hello"));
		assertEquals(list, list.insertAt(0, "hi"));
		assertEquals(list.size(), 2);
		assertEquals("hi", list.getFirst());
		list.insertAt(2, "bye");
		assertEquals("bye", list.getLast());
		assertEquals("hello", list.get(1));
		assertEquals("hi", list.get(0));
		assertEquals("bye", list.get(2));
		list.insertAt(1, "p");
		
	}
	
	@Test (timeout = 500)
	public void testIndexOf(){
		assertTrue(list.isEmpty());
		list.insertLast("hi");
		list.insertLast("hello");
		list.insertLast("bye");
		assertEquals(0, list.indexOf("hi"));
		assertEquals(1, list.indexOf("hello"));
		assertEquals(2, list.indexOf("bye"));
		assertEquals(-1, list.indexOf("A"));
		
	}
	
	@Test (timeout = 500)
	public void testRemovesFirstAndLast(){
		assertTrue(list.isEmpty());
		list.insertLast("hi");
		list.insertLast("hello");
		list.insertLast("bye");
		assertEquals("hi", list.removeFirst());
		assertEquals(2, list.size());
		assertEquals("bye", list.removeLast());
		assertEquals(1, list.size());
		//list.insertLast("bye");
		//list.insertFirst("hi");
		//assertEquals("hello", list.removeAt(1));
		//assertEquals(2, list.size());
		//list.insertAt(1, "hello");
		//assertEquals("hi", list.removeAt(0));
		//assertEquals(2, list.size());
		//assertEquals("bye", list.removeAt(1));
		//assertEquals(1, list.size());
		
	}
	
	@Test (timeout=500)
	public void testRemovesAt(){
		list.insertLast("A");
		list.insertLast("B");
		list.insertLast("C");
		list.insertLast("D");
		list.insertLast("E");
		assertEquals("C", list.removeAt(2));
		assertEquals("D", list.get(2));
		assertEquals("B", list.get(1));
		
	}
	
	@Test (timeout = 500)
	public void testRemove(){
		list.insertLast("A");
		list.insertLast("B");
		list.insertLast("C");
		list.insertLast("D");
		list.insertLast("E");
		assertFalse(list.remove("F"));
		assertTrue(list.remove("C"));
		assertEquals(4, list.size());
		assertEquals("D", list.get(2));
		
	}
	
	@Test (timeout = 500)
	public void testRemoveLast(){
		list.insertLast("A");
		list.insertLast("B");
		list.insertLast("C");
		list.insertLast("D");
		list.insertLast("E");
		assertEquals("E", list.removeLast());
		assertEquals("D", list.getLast());
		
	}
	
	@Test (timeout = 500)
	public void testInsertAt(){
		list.insertLast("A");
		list.insertLast("B");
		list.insertLast("C");
		list.insertLast("D");
		list.insertLast("E");
		list.insertAt(0, "FIRST");
		assertEquals("FIRST", list.getFirst());
		
		list.insertAt(1, "second");
		assertEquals("second", list.get(1));
		assertEquals("A", list.get(2));
		assertEquals(7, list.size());
		
		
	}
	
	@Test (timeout = 500, expected = NullPointerException.class)
	public void exception1(){
		list.insertFirst(null);
	}
	
	@Test (timeout = 500, expected = NullPointerException.class)
	public void exception2(){
		list.insertLast(null);
	}
	
	@Test (timeout = 500, expected = NullPointerException.class)
	public void exception3(){
		list.insertAt(0,null);
	}
	
	@Test (timeout = 500, expected = IndexOutOfBoundsException.class)
	public void exception4(){
		list.insertAt(-1, "hi");
	}
	
	@Test (timeout = 500, expected = IndexOutOfBoundsException.class)
	public void exception5(){
		list.insertAt(1, "hi");
	}
	
	@Test (timeout = 500, expected = IllegalStateException.class)
	public void exception6(){
		list.removeFirst();
	}
	
	@Test (timeout = 500, expected = IllegalStateException.class)
	public void exception7(){
		list.removeLast();
	}
	
	@Test (timeout = 500, expected = IndexOutOfBoundsException.class)
	public void exception8(){
		list.removeAt(2);
	}
	
	@Test (timeout = 500)
	public void testGet(){
		list.insertLast("A");
		list.insertLast("B");
		list.insertLast("C");
		list.insertLast("D");
		list.insertLast("E");
		assertEquals("A", list.getFirst());
		assertEquals("E", list.getLast());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
	}
	
	@Test (timeout = 500)
	public void testIndexOf2(){
		list.insertLast("A");
		list.insertLast("A");
		list.insertLast("B");
		list.insertLast("C");
		assertEquals(0, list.indexOf("A"));
		assertEquals(-1, list.indexOf("D"));
	}
	
	@Test (timeout = 500)
	public void testremove(){
		list.insertLast("A");
		list.insertLast("B");
		list.insertLast("C");
		list.insertLast("D");
		list.insertLast("E");
		assertTrue(list.remove("C"));
		//((RecursiveList<String>) list).print();
		assertFalse(list.remove("F"));
		//((RecursiveList<String>) list).print();
	}
	
	@Test (timeout = 500)
	public void testRemoveLast2(){
		list.insertLast("A");
		assertEquals("A", list.removeLast());
	}
	
	@Test (timeout = 500)
	public void testOneElem(){
		list.insertLast("A");
		assertEquals("A", list.getLast());
		assertEquals(0, list.indexOf("A"));
	}
	
}
