public class Fibonacci {
	public static int fib(int n) {
		// computes fibonacci function for any non-negative integer n
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	/**
	 * Computes the Fibonacci function iteratively for any non-negative integer
	 * <code>n</code>
	 */
	public static int fastFib(int n) {
		//TODO: write your code here: 
		int f_before = 0;
		int f_after = 1;
		int f=0;
		for(int i=1; i<n; i++){
			f=f_before+f_after;
			f_before = f_after;
			f_after=f;
			
		}
		return f; 
	}

	/**
	 * Computes the Fibonacci function for any non-negative integer
	 * <code>n</code>
	 */
	public static long longFastFib(int n) {
		//TODO: write your code here.
		long f_before = 0;
		long f_after = 1;
		long f=0;
		for(int i=1; i<n; i++){
			f=f_before+f_after;
			f_before = f_after;
			f_after=f;
			
		}
		return f; 
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Needs an integer parameter");
			System.exit(1);
		}

		int n = Integer.parseInt(args[0]);
		//System.out.println(fib(n));
		System.out.println(longFastFib(n));
	}
}
