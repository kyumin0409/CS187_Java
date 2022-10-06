package hanoi;

import structures.LinkedStack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	
	LinkedStack<HanoiRing> stack = new LinkedStack<HanoiRing>();
	int size = 0;
	
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if(size==0){
			stack.push(ring);
			size++;
			return;
		}
		if(getTopRing().getSize()<=ring.getSize())
			throw new IllegalHanoiMoveException("Ring is too big");
		else{
			stack.push(ring);
			size++;
		}
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if(size==0)
			throw new IllegalHanoiMoveException("Peg is empty");
		else{
			HanoiRing ring = stack.pop();
			size--;
			return ring;
		}
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if(size==0)
			throw new IllegalHanoiMoveException("Peg is empty");
		else{
			HanoiRing ring = stack.peek();
			return ring;
		}
	}

	@Override
	public boolean hasRings() {
		if(size>0)
			return true;
		else
			return false;
	}
	
	public int getSize(){
		return size;
	}
}
