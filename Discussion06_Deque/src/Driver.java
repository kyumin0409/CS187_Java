import java.util.ArrayList;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		//Testing for the InsertionSorter debugging task
		List<Integer> unsorted = new ArrayList<Integer>();
		int[] nums = {5, 2, 8, 3, 4, 7, 6, 9, 1};
		for(int num : nums)
			unsorted.add(num);
		InsertionSorter<Integer> sorter = new InsertionSorter<Integer>();
		List<Integer> ascending = sorter.sort(unsorted, true);
		List<Integer> descending = sorter.sort(unsorted, false);
		System.out.println(unsorted);
		System.out.println(ascending);
		System.out.println(descending);
	}

}
