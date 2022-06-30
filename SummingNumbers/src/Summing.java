
public class Summing {
	//adds numbers in an array regardless of length.
	int bgsum(int[] arr) {
		int rslt=0;
		for(int num: arr) {
			rslt+=num;
		}
		return rslt;
	}
	public static void main(String[] args) {
		//Example arrays to apply method.
		int[] arr0 = {3, 4, 332, 4, 3, 222, 402, 8392, 83, 2, 1, 244, 5, 4, 33, 842, 0, 0, 0, 2, 3, 4, 0, 8871, 3, 1, 7, 9, 900, 1, 19, 23, 98, 89, 733, 437, 87, 98};
		int[] arr1 = {};
		int[] arr2 = {3,2,3};
		int[] arr3 = {1};
		//There doesn't seem to be a way to apply a method
		//directly to an array so I created an empty instance
		//to apply my method to in order to apply my method
		//to my array as an argument in my method.
		//Feels inelegant and that there should be a better
		//method. 
		//Also this comment should have used the alternate
		//formatting.
		Summing plchldr = new Summing();
		
		System.out.println(plchldr.bgsum(arr0));
		System.out.println(plchldr.bgsum(arr1));
		System.out.println(plchldr.bgsum(arr2));
		System.out.println(plchldr.bgsum(arr3));
	}
}
