import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HeapSorterTest {
	HeapSorter<Integer> sorter;
	
	@Before
	public void before() {
		sorter = new HeapSorter<Integer>();
	}
	
	@Test
	public void testSimpleSort() {
		List<Integer> list = new ArrayList<Integer>();
		for(int num : new int[] {5, 2, 8, 3, 4, 7, 6, 9, 1})
			list.add(num);
		assertEquals("[5, 2, 8, 3, 4, 7, 6, 9, 1]", list.toString());
		sorter.sort(list);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
	}
	
	@Test
	public void testEmptySort() {
		List<Integer> list = new ArrayList<Integer>();
		sorter.sort(list);
		assertEquals("[]", list.toString());
	}

	@Test
	public void testOneElementSort() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		sorter.sort(list);
		assertEquals("[0]", list.toString());
	}

	@Test
	public void testTwoElementSort() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(0);
		sorter.sort(list);
		assertEquals("[0, 1]", list.toString());
	}

	@Test
	public void testBigSort() {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i = 10000; i >= 0; i--)
		{
			list1.add(i);
			list2.add(i);
		}
		sorter.sort(list1);
		Collections.sort(list2);
		assertEquals(list2, list1);
	}

	@Test(timeout = 500, expected = NullPointerException.class)
	public void testException() {
		sorter.sort(null);
	}
}
