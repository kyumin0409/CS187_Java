import java.util.Scanner;

public class Positions {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter string one: ");
		String inputStr1 = scan.nextLine();
		System.out.println("Enter string two: ");
		String inputStr2 = scan.nextLine();
		int stringOne = inputStr1.length();
		int stringTwo = inputStr2.length();
		int shorter = 0;
		if(stringOne<=stringTwo){
			shorter = stringOne;
		}else{
			shorter = stringTwo;
		}
		for(int i=0; i<shorter; i++){
			if(inputStr1.charAt(i) != inputStr2.charAt(i)){
				System.out.println(i + " " + inputStr1.charAt(i) + " " + inputStr2.charAt(i));
			}
		}
	}
}
