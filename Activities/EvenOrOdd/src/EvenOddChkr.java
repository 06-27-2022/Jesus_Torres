import java.util.Scanner;

public class EvenOddChkr {

	/*
	 * Method to determine even or oddness.
	 * Might have too many things in a single method.
	 */
	void evenOrOdd(int num) {
		String rslt;
		//finds remainder of method input
		int rmndr = num % 2;
		//remainder is run through a conditional to find even or oddness.
		if(rmndr == 1) {
			rslt = "Odd";
		}
		else if(rmndr == 0) {
			rslt = "Even";
		}
		else {
			rslt = "You inputed a non integer.";
		}
		//result is output into console
		System.out.println(rslt);
	}
	public static void main(String[] args) {
	
		//Creation of place holder object to apply our method.
		EvenOddChkr plcHldr = new EvenOddChkr();
		//User gives an integer to be checked.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an integer to check for even or odd:");
		int userInteger = scan.nextInt();
		
		//Application of our method.
		plcHldr.evenOrOdd(userInteger);
		scan.close();
		
		
	}
}
