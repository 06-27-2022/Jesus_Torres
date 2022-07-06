
public class gradingCalc {
	public static void main(String[] args) {
		int[] grades = {95, 85, 62, 40, 79};
		char[] ranks = {'A', 'A', 'A', 'A', 'A'};
		String[] subj = {"Math", "English", "Science", "History", "Art"};
		//Figured out how to make arrays from strings with this:
		//https://www.w3schools.com/java/java_arrays.asp
		for (int plc = 0; plc < 5; plc++) {
			if(grades[plc] <= 100 && grades[plc]>= 90 ) {
				ranks[plc] = 'A';
			}
			else if(grades[plc] < 90 && grades[plc] >= 80) {
				ranks[plc] = 'B';
			}
			else if(grades[plc]<80 && grades[plc] >= 70) {
				ranks[plc] = 'C';
			}
			else if(grades[plc] < 70 && grades[plc] >= 60) {
				ranks[plc] = 'D';
			}
			else if (grades[plc] <60) {
				ranks[plc] = 'F';
			}
			else {
				ranks[plc] = '-';
			}
			System.out.println(subj[plc] + ": " + ranks[plc]);
			//Figured out how to make data based outputs and editing 
			//array elements using this:
			//https://www.codegrepper.com/code-examples/java/how+to+replace+an+element+in+array+in+java
		}
	}
}
