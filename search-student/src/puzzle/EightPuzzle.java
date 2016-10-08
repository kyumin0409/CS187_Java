package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import search.SearchProblem;
import search.Solver;

/**
 * A class to represent an instance of the eight-puzzle.
 * 
 * The spaces in an 8-puzzle are indexed as follows:
 * 
 * 0 | 1 | 2
 * --+---+---
 * 3 | 4 | 5
 * --+---+---
 * 6 | 7 | 8
 * 
 * The puzzle contains the eight numbers 1-8, and an empty space.
 * If we represent the empty space as 0, then the puzzle is solved
 * when the values in the puzzle are as follows:
 * 
 * 1 | 2 | 3
 * --+---+---
 * 4 | 5 | 6
 * --+---+---
 * 7 | 8 | 0
 * 
 * That is, when the space at index 0 contains value 1, the space 
 * at index 1 contains value 2, and so on.
 * 
 * From any given state, you can swap the empty space with a space 
 * adjacent to it (that is, above, below, left, or right of it,
 * without wrapping around).
 * 
 * For example, if the empty space is at index 2, you may swap
 * it with the value at index 1 or 5, but not any other index.
 * 
 * Only half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle
 * for details.
 * 

 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {
	
	List<Integer> initial;
	
	/**
	 * Creates a new instance of the 8 puzzle with the given starting values.
	 * 
	 * The values are indexed as described above, and should contain exactly the
	 * nine integers from 0 to 8.
	 * 
	 * @param startingValues
	 *            the starting values, 0 -- 8
	 * @throws IllegalArgumentException
	 *             if startingValues is invalid
	 */
	public EightPuzzle(List<Integer> startingValues) throws IllegalArgumentException{
		// TODO
		if(startingValues.size()!=9){
			throw new IllegalArgumentException();
		}
		for(int i = 0; i<=8; i++){
			boolean exists = false;
			for(int j = 0; j<startingValues.size(); j++){
				if(i==startingValues.get(j)){
					exists = true;
					break;
				}
			}
			if(exists == false){
				throw new IllegalArgumentException();
			}
		}
		
		initial = startingValues;
	}

	@Override
	public List<Integer> getInitialState() {
		// TODO
		return initial;
	}

	@Override
	public List<List<Integer>> getSuccessors(List<Integer> currentState) {
		// TODO
		List<List<Integer>> successors = new ArrayList<List<Integer>>();
		int i = currentState.indexOf(0);
		if(i==0){
			successors.add(findSuccessors(0,1, currentState));
			successors.add(findSuccessors(0,3, currentState));
		}
		if(i==1){
			successors.add(findSuccessors(1,0, currentState));
			successors.add(findSuccessors(1,2, currentState));
			successors.add(findSuccessors(1,4, currentState));
			
		}
		if(i==2){
			successors.add(findSuccessors(2,1, currentState));
			successors.add(findSuccessors(2,5, currentState));
		}
		
		if(i==3){
			successors.add(findSuccessors(3,0, currentState));
			successors.add(findSuccessors(3,4, currentState));
			successors.add(findSuccessors(3,6, currentState));
		}
		if(i==4){
			successors.add(findSuccessors(4,1, currentState));
			successors.add(findSuccessors(4,3, currentState));
			successors.add(findSuccessors(4,5, currentState));
			successors.add(findSuccessors(4,7, currentState));

		}
		if(i==5){
			successors.add(findSuccessors(5,2, currentState));
			successors.add(findSuccessors(5,4, currentState));
			successors.add(findSuccessors(5,8, currentState));

		}
		if(i==6){
			successors.add(findSuccessors(6,3, currentState));
			successors.add(findSuccessors(6,7, currentState));

		}
		if(i==7){
			successors.add(findSuccessors(7,4, currentState));
			successors.add(findSuccessors(7,6, currentState));
			successors.add(findSuccessors(7,8, currentState));

		}
		if(i==8){
			successors.add(findSuccessors(8,7, currentState));
			successors.add(findSuccessors(8,5, currentState));

		}
		return successors;
	}

	private List<Integer> findSuccessors(int index1, int index2, List<Integer> curr){
		List<Integer> list = new ArrayList<Integer>();
		for(Integer a : curr){
			list.add(a);
		}
		Integer temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
		
		return list;
	}
	
	@Override
	public boolean isGoal(List<Integer> state) {
		// TODO
		for(int i=0; i<=7; i++){
			if(state.get(i)!=i+1)
				return false;
		}
		if(state.get(8)!=0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		EightPuzzle e = new EightPuzzle(Arrays.asList(new Integer[] { 1, 2, 3,
				4, 0, 6, 7, 5, 8 }));

		List<List<Integer>> r = new Solver<List<Integer>>(e).solveWithBFS();
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}
}
