
public class Summing {
	
	int bgsum(int[] arr) {
		int rslt=0;
		for(int num: arr) {
			rslt+=num;
		}
		return rslt;
	}
	public static void main(String[] args) {
		int[] arr0 = {3, 4, 332, 4, 3, 222, 402, 8392, 83, 2, 1, 244, 5, 4, 33, 842, 0, 0, 0, 2, 3, 4, 0, 8871, 3, 1, 7, 9, 900, 1, 19, 23, 98, 89, 733, 437, 87, 98};
		int[] arr1 = {};
		int[] arr2 = {3,2,3};
		int[] arr3 = {1};
		Summing plchldr = new Summing();
		
		System.out.println(plchldr.bgsum(arr0));
		System.out.println(plchldr.bgsum(arr1));
		System.out.println(plchldr.bgsum(arr2));
		System.out.println(plchldr.bgsum(arr3));
	}
}
