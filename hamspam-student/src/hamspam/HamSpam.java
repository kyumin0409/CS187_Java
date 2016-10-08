package hamspam;

public class HamSpam {
	
	private int ham;
	private int spam;
	
	/**
	 * Construct an object that can compute hamspam values for a game of 
	 * Ham and Spam.
	 * 
	 * @param hamNumber the ham number; it must be greater than 1
	 * @param spamNumber the spam number; it must be greater 
	 * than 0 and not equal to the ham number 
	 */
	public HamSpam(int hamNumber, int spamNumber) {
		ham = hamNumber;
		spam = spamNumber;
	}

	/**
	 * Returns the nth hamspam value (a number, ham, spam, or hamspam) 
	 * for this game of Ham and Spam.
	 * 
	 * For example, getValue(1) returns "1".
	 * 
	 * @param n
	 *            the number to consider; n > 0
	 * @return the hamspam value, as a String
	 */
	public String getValue(int n) {
		
		if ((n%ham) == 0 && (n%spam) == 0){
			return "hamspam";
		}
		
		else if ((n%ham) == 0) {
			return "ham";
		}

		else if ((n%spam) == 0) {
			return "spam";
		}
		
		else {
			return Integer.toString(n);
		}
	}

	/**
	 * Returns an array of the hamspam values from start to end, inclusive, for
	 * this game of Ham and Spam.
	 * 
	 * For example, if the ham number is 3 and the spam number is 4,
	 * getValues(2,6) should return an array of Strings:
	 * 
	 * {"2", "ham", "spam", "5", "ham"}
	 * 
	 * @param start
	 *            the number to start from; start > 0
	 * @param end
	 *            the number to end at; end >= start
	 * @return the array of hamspam values
	 */
	public String[] getValues(int start, int end) {
		int numElem = end-start+1;
		int count = start;
		String[] result = new String[numElem];
		for(int i=0; i<numElem; i++){
			result[i] = getValue(count);
			count++;
		}
		return result;
	}
}
