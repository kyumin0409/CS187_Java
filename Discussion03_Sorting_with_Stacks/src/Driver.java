public class Driver {
	
	public static void main(String[] args) {					
		System.out.println(">>>Mary had a little lamb:");
		Words words  = new Words("data/maryLamb.dat");
		
		LeftRightSorter s = new LeftRightSorter();
		
		s.loadStacks(words.all_words);
		System.out.println("\nSorted stacks:\n");
		s.printStacks();
		
		System.out.println();
		
		int n = s.left.size() + s.right.size();
		for (int idx = 0; idx < n; idx++) {
			System.out.println("Word " + idx + ": " + s.wordAt(idx));
		}

		System.out.println("\n>>>Knuth's five-letter words:\n");
		Words knuths  = new Words("data/knuthWords.dat");
		
		LeftRightSorter k = new LeftRightSorter();
		
		k.loadStacks(knuths.all_words);
		
		for (int idx = 1000-1; idx < 5000; idx += 1000) {
			System.out.println("Word " + idx + ": " + k.wordAt(idx));
		}
	}
	
}
