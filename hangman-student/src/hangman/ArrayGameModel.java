package hangman;

/**
 * The Array implementation of the GameModel interface.
 */
public class ArrayGameModel implements GameModel {
	/** The number of characters (lower/upper). */
	private static final int ALPHABET_COUNT = 26*2;
	
	
	/** hung state */
	private int		state;
	
	private char[] guessArr = new char[ALPHABET_COUNT];
	
	private char[] wordArr;
	
	private boolean[] correctArr;
	
	private String theWord;
	
	/**
	 * Creates a new ArrayGameModel object.
	 * 
	 *  guessWord the word to guess
	 */
	public ArrayGameModel(String guessWord) {
		// TODO (1)
		
		theWord = guessWord;
		
		state    = STARTING_STATE;//0
		for(int i=0; i<guessArr.length; i++){
			guessArr[i] = '-';
		}
		
		wordArr = new char[guessWord.length()];
	
		for(int i=0; i<wordArr.length; i++){
			wordArr[i]= guessWord.charAt(i);
		}
		
		correctArr = new boolean[guessWord.length()];
		
		for(int i=0; i<correctArr.length; i++){
			correctArr[i] = false;
		}
		
	}
		
	public boolean isPriorGuess(char guess) {
		// TODO (2)
		for(int i=0; i<guessArr.length; i++){
			if(guessArr[i] == guess){
				return true;
			}
			else if(guessArr[i] == '-'){
				return false;
			}
			else{
				continue;
			}
		}
		return false;
	}
	
	public int numberOfGuesses() {
		// TODO (3)
		int guessNum = 0;
		for(int i=0; i<guessArr.length; i++){
			if(guessArr[i] != '-'){
				guessNum++;
			}
		}
		return guessNum;
	}
	
	public boolean isCorrectGuess(char guess) {
		// TODO (4)
		for(int i=0; i<wordArr.length; i++){
			if(!isPriorGuess(guess) && wordArr[i] == guess){
				correctArr[i] = true;
				return true;
			}
		}
		return false;
	}
	
	public boolean doMove(char guess) {
		// TODO (5)
		if(!isPriorGuess(guess)){
			
			//System.out.println(previousGuessString());
			for(int i=0; i<guessArr.length; i++){
				if(guessArr[i] == '-'){
					guessArr[i] = guess;
					break;
				}
			}
			for(int j=0; j<wordArr.length; j++){
				if(wordArr[j]==guess){
					return true;
				}
			}
			state++;
		}
		return false;
	}

	public boolean inWinningState() {
		// TODO (6)
		boolean exists = false;
		for(int i=0; i<wordArr.length; i++){
			for(int j=0; j<guessArr.length; j++){
				if(wordArr[i] == guessArr[j]){
					exists = true;
					break;
				}
			}
			if(exists == false){
				return false;
			}
			exists = false;
			
		}
		
		return true;
		/*for(int i=0; i<correctArr.length; i++){
			if(correctArr[i] == false){
				return false;
			}
		}
		return true;*/
	}

	public boolean inLosingState() {
		// TODO(7)
		if(state >=10 && !inWinningState()){
			return true;
		}
		return false;
	}
	
	public String toString() {
		// TODO (8) ********
		
		boolean exists = false;
		
		String s = "";
		for(int i=0; i<wordArr.length-1; i++){
			for(int j=0; j<guessArr.length; j++){
				if(wordArr[i] == guessArr[j]){
					exists = true;
					s += wordArr[i];
					s += " ";
					break;
				}
			}
			if(exists == false){
				s += "_ ";
			}
			exists = false;
			
		}
		
		char check = wordArr[wordArr.length-1];
		for(int i=0; i<guessArr.length; i++){
			if(check == guessArr[i]){
				s += check;
				return s;
			}
		}
		s += "_";
		return s;
	}

	public String previousGuessString() {
		String s = "";
		s += "[";
		int index =0;
		
		int total = 0;
		for(int i=0; i<guessArr.length; i++){
			if(guessArr[i] != '-'){
				total++;
			}
			else{
				break;
			}
		}

		while(guessArr[index] != '-' && index<total-1){
			s += guessArr[index];
			s += ", ";
			index++;
		}
		
		s += guessArr[index];
		s += "]";
		
		
		 
		// TODO (9)
		
		return s;
	}
	
	public int getState() {
		return state;
	}

	public String getWord() {

		// TODO (10)

		return theWord;
	}
  
}
