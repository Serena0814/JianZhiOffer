package Question21;

public class Arr {
	public static void main(String args[]) {
		int arr1[] = {2,3,4,5,6,7,8};
		int arr2[] = {1,3,5};
		arrRe(arr1);
		arrRe(arr2);
		for(int number : arr1) {
			System.out.print(number+" ");
		}
		System.out.println();
		for(int number : arr2) {
			System.out.print(number+" ");
		}
		System.out.println();
	}
	
	public static void arrRe(int[] arr) {
		int length = arr.length;
		if(length == 0 || length == 1) {
			return;
		}
		int low = 0;
		int high = length-1;
		while(low < high) {
			while(low < high && arr[low] % 2 == 1 ) {
				low ++;
			}
			while(low < high && arr[high] % 2 == 0) {
				high --;
			}
			if (low < high) {
				int t = arr[low];
				arr[low] = arr[high];
				arr[high] = t;
				low ++;
				high --;
			}
		}
		return;
	}
}
