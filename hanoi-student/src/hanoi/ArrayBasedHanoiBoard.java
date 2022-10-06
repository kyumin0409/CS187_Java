package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	
	StackBasedHanoiPeg[] arr = new StackBasedHanoiPeg[3];
	int numRing;
	
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	public ArrayBasedHanoiBoard(int n) {
		numRing=n;
		
		if(n<0)
			throw new IllegalArgumentException("Cannot insert negative number of rings");
		
		for(int i=0; i<arr.length; i++){
			arr[i] = new StackBasedHanoiPeg();
		}
		
		
		for(int i = n; i>0; i--){
			HanoiRing ring = new HanoiRing(i);
			arr[0].addRing(ring);
		}
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException("Could not perform illegal move.");
		}
		else{
			StackBasedHanoiPeg fromPeg = arr[move.getFromPeg()];
			StackBasedHanoiPeg toPeg = arr[move.getToPeg()];
			HanoiRing ring = fromPeg.remove();
			toPeg.addRing(ring);
		}
	}

	@Override
	public boolean isSolved() {
		int peg1 = arr[0].getSize();
		int peg2 = arr[1].getSize();
		int peg3 = arr[2].getSize();
		
		if(peg2==numRing || peg3==numRing)
			return true;
		else
			return false;
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		int toPegNum = move.getToPeg();
		int fromPegNum = move.getFromPeg();
		StackBasedHanoiPeg toPeg = arr[toPegNum];
		StackBasedHanoiPeg fromPeg = arr[fromPegNum];
		if(fromPeg.getSize()!=0){
			if(toPeg.getSize()==0){
				return true;
			}
			if(toPeg.getTopRing().getSize()>fromPeg.getTopRing().getSize()){
				return true;
			}
		}
		return false;
	}
}
