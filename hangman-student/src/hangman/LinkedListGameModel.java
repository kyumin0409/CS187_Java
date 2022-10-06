package hangman;

public class LinkedListGameModel implements GameModel {
	
	private int state;
	private String theWord;
	private LLCharacterNode guessList;
	private LLCharacterNode wordList;
	
	
	public LinkedListGameModel (String guessWord){
		theWord = guessWord;
		state = STARTING_STATE;
		
		wordList = new LLCharacterNode(guessWord.charAt(0));
		LLCharacterNode pointer = wordList;
		for(int i = 1; i<guessWord.length()-1; i++){
			LLCharacterNode newNode = new LLCharacterNode(guessWord.charAt(i));
			pointer.setLink(newNode);
			pointer = pointer.getLink();
		}
		LLCharacterNode lastNode = new LLCharacterNode(guessWord.charAt(guessWord.length()-1));
		pointer.setLink(lastNode);
		
		guessList = new LLCharacterNode('-');
		
		
		/*LLCharacterNode gp = guessList;
		System.out.println("guessList:");
		while(gp != null){
			System.out.print(gp.getInfo());
			System.out.print(" ");
			gp = gp.getLink();
		}
		System.out.println();
		
		LLCharacterNode wp = wordList;
		System.out.println("wordList:");
		while(wp != null){
			System.out.print(wp.getInfo());
			System.out.print(" ");
			wp = wp.getLink();
		}
		System.out.println();*/
	}
	
	@Override
	public boolean isPriorGuess(char guess) {
		// TODO Auto-generated method stub
		LLCharacterNode pointer = guessList;
		if(pointer.getInfo() == '-'){
			return false;
		}
		else{
			while(pointer != null){
				if(pointer.getInfo() == guess){
					return true;
				}
				pointer = pointer.getLink();
			}
		}
		
		return false;
	}

	@Override
	public int numberOfGuesses() {
		// TODO Auto-generated method stub
		int count = 0;
		LLCharacterNode pointer = guessList;
		if(pointer.getInfo() == '-'){
			return count;
		}
		else{
			while(pointer != null){
				count++;
				pointer = pointer.getLink();
			}
		}
		return count;
	}

	@Override
	public boolean isCorrectGuess(char guess) {
		// TODO Auto-generated method stub
		LLCharacterNode pointer = guessList;
		while(pointer != null){
			if(pointer.getInfo() == guess){
				return false;
			}
			pointer = pointer.getLink();
		}
		LLCharacterNode pointer2 = wordList;
		while(pointer2 != null){
			if(pointer2.getInfo() == guess){
				return true;
			}
			pointer2 = pointer2.getLink();
		}
		return false;
	}

	@Override
	public boolean doMove(char guess) {
		// TODO Auto-generated method stub
		if(!isPriorGuess(guess)){
			LLCharacterNode pointer = guessList;
			if(pointer.getInfo() == '-'){
				pointer.setInfo(guess);
			}
			else{
				while(pointer.getLink() != null){
					pointer = pointer.getLink();
				}
				LLCharacterNode newGuess = new LLCharacterNode(guess);
				pointer.setLink(newGuess);
			}
			
			LLCharacterNode pointer2 = wordList;
			while(pointer2 != null){
				if(pointer2.getInfo() == guess){
					return true;
				}
				pointer2 = pointer2.getLink();
			}
			state++;
		}
		return false;
	}

	@Override
	public boolean inWinningState() {
		// TODO Auto-generated method stub
		boolean exists = false;
		LLCharacterNode wordPointer = wordList;
		LLCharacterNode guessPointer = guessList;
		
		while(wordPointer != null){
			while(guessPointer != null && guessPointer.getInfo() != '-'){
				//System.out.println("comparing " + wordPointer.getInfo() + " and " + guessPointer.getInfo());
				if(wordPointer.getInfo() == guessPointer.getInfo()){
					exists = true;
					break;
				}
				guessPointer = guessPointer.getLink();
			}
			guessPointer = guessList;//****
			//System.out.println("indexed to the first: " + guessPointer.getInfo());
			if(exists == false){
				return false;
			}
			exists = false;
			wordPointer = wordPointer.getLink();
		}
		return true;
	}

	@Override
	public boolean inLosingState() {
		// TODO Auto-generated method stub
		if(state >= 10 && !inWinningState()){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		boolean exists = false;
		
		LLCharacterNode wordPointer = wordList;
		LLCharacterNode guessPointer = guessList;
		
		String s = "";
		
		while(wordPointer.getLink() != null){
			while(guessPointer != null){
				//System.out.println("comparing " + wordPointer.getInfo() + " and " + guessPointer.getInfo());
				if(wordPointer.getInfo() == guessPointer.getInfo()){
					exists = true;
					s += wordPointer.getInfo();
					s += " ";
					break;
				}
				guessPointer = guessPointer.getLink();
			}
			guessPointer = guessList;//****
			if(exists == false){
				s += "_ ";
			}
			exists = false;
			wordPointer = wordPointer.getLink();
		}
		
		while(guessPointer != null){
			//System.out.println("comparing " + wordPointer.getInfo() + " and " + guessPointer.getInfo());
			if(wordPointer.getInfo() == guessPointer.getInfo()){
				s += wordPointer.getInfo();
				return s;
			}
			guessPointer = guessPointer.getLink();
		}
		
		s += "_";
				
		return s;
	}
	
	@Override
	public String previousGuessString() {
		// TODO Auto-generated method stub
		String s = "";
		s += "[";
		LLCharacterNode guessPointer = guessList;
		
		if(guessPointer.getInfo() == '-'){
			s +="]";
			return s;
		}
		
		while(guessPointer.getLink() != null){
			s += guessPointer.getInfo();
			s += ", ";
			guessPointer = guessPointer.getLink();
		}
		
		s += guessPointer.getInfo();
		s += "]";
		
		return s;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		return theWord;
	}

}
