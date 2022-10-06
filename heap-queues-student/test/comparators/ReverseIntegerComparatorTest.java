package comparators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerComparatorTest {

  ReverseIntegerComparator comparator;
	
  @Before
  public void setup() {
    comparator = new ReverseIntegerComparator();
  }

  @Test (timeout = 100)
  public void testOne() {
	  assertEquals(-1, comparator.compare(2, 1));
	  assertEquals(1, comparator.compare(1, 2));
	  assertEquals(0, comparator.compare(4, 4));
  }

}
