package sets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdditionalLinkedSetTest {
	  Set<String> set5;
	  Set<String> set6;
	  Set<String> set7;
	  Set<Integer> set8;
	  Set<Integer> set9;
  @Before
  public void before() {
    set5 = new LinkedSet<String>();
    set6 = new LinkedSet<String>();
    for (String e : new String[]{"c", "a", "d", "b", "e"}) {
      set6 = set6.adjoin(e);
    }
    set7 = new LinkedSet<String>();
    for (String e : new String[]{"b", "d", "a", "e", "c"}) {
      set7 = set7.adjoin(e);
    }
    set8 = new LinkedSet<Integer>();
    for (int i : new int[]{2, 3, 5, 7, 11, 13, 17, 19}) {
      set8 = set8.adjoin(i);
    }
    set9 = new LinkedSet<Integer>();
    for (int i : new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}) {
      set9 = set9.adjoin(i);
    }
  }

  @Test
  public void testAdjoinImmutability() {
    assertEquals(set6, set7);
    set7.adjoin("q");
    assertEquals("adjoin should not modify the set", set6, set7);
  }

  @Test
  public void testIsSubsetImmutability() {
    set6.isSubset(set7);
    assertEquals("isSubset should not modify either set", set6, set6);
    assertEquals("isSubset should not modify either set", set7, set7);
  }

  @Test
  public void testIsSupersetImmutability() {
    set6.isSuperset(set7);
    assertEquals("isSuperset should not modify either set", set6, set6);
    assertEquals("isSuperset should not modify either set", set7, set7);
  }

  @Test
  public void testUnionImmutability() {
    set6.union(set7);
    assertEquals("union should not modify either set", set6, set6);
    assertEquals("union should not modify either set", set7, set7);
  }

  @Test
  public void testIntersectImmutability() {
    set8.intersect(set9);
    assertEquals("intersect should not modify either set", set8, set8);
    assertEquals("intersect should not modify either set", set9, set9);
  }

  @Test
  public void testSubtractImmutabiilty() {
    set7.subtract(set6);
    assertEquals("subtract should not modify either set", set6, set6);
    assertEquals("subtract should not modify either set", set7, set7);
  }

  @Test
  public void testRemoveImmutability() {
    set8.remove(3);
    assertEquals("remove should not modify the set", set8, set8);
  }
}
