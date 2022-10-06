package hanoi;

import structures.ListImplementation;
import structures.ListInterface;

/**
 * A {@link RecursiveHanoiSolver} implements the {@link HanoiSolver} taking
 * advantage of recursion. See Chapter 3.3 of DJW and 
 * {@link http://en.wikipedia.org/wiki/Tower_of_Hanoi}.
 * 
 */
public class RecursiveHanoiSolver {
	private ListInterface<HanoiMove> moves;

	/**
	 * Moves {@code n} rings from {@code fromPeg} to the {@code toPeg}.
	 * 
	 * @param n
	 *            the number of rings to move
	 * @param fromPeg
	 *            the peg to move them from
	 * @param toPeg
	 *            the peg to move them to
	 * @param auxPeg
	 *            a peg that we may utilize when needed to accomplish the task
	 */
	private void solverHelper(int n, int fromPeg, int toPeg, int auxPeg) throws IllegalHanoiMoveException {
		
		if(n>0){
			solverHelper(n-1, fromPeg, auxPeg, toPeg);
			moves.append(new HanoiMove(fromPeg, toPeg));
			solverHelper(n-1, auxPeg, toPeg, fromPeg);
		}
		
	}

	/**
	 * Solves the Tower of Hanoi puzzle for {@code n} rings.
	 * 
	 * @param n
	 *            the number of rings
	 * @return a {@link HanoiSolution} representing the moves to be played
	 * @throws IllegalArgumentException
	 *             if {@code n} is less than 0.
	 */
	public HanoiSolution solve(int n) throws IllegalHanoiMoveException {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		// Initialize moves to a new list to get rid of any previous
		// solution stored there
		moves = new ListImplementation<HanoiMove>();
		// We want to move n rings from peg 0 to peg 2.
		solverHelper(n, 0, 2, 1);
		// Return a new solution with n as the number of rings
		// and moves as the solution
		return new HanoiSolution(n, moves);
	}
}
