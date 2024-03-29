package comparators;

import java.util.Comparator;

/**
 * An {@link IntegerComparator} compares integers in the natural way.
 *
 */
public class IntegerComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer arg0, Integer arg1) {
	  if(arg0<arg1) return -1;
	  if(arg1<arg0) return 1;
	  else return 0;
  }
}
