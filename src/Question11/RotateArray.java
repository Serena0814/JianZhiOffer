package Question11;
/*
 * 求旋转数组中的最小值
 * 注意：
 * 1.当为顺序数组，直接返回第一个值；
 * 2.当第一个数字和最后一个数字均为最小值，顺序查数组；
 * 3.否则类二分查找。
 */
public class RotateArray {
	public static void main(String args[]) {
		int[] arr = {7,8,9,0,1,2,3,4,5};
		int[] arr2 = {1,0,1,1,1,1};
		int[] arr3 = {1,2,3,4,5,6};
		System.out.println(rotateArray(arr));
		System.out.println(rotateArray(arr2));
		System.out.println(rotateArray(arr3));
	}
	
	public static int rotateArray(int[] arr) {
		int length = arr.length;
		if(length == 0) {
			return Integer.MIN_VALUE;
		}
		if(length == 1) {
			return arr[0];
		}
		if (arr[0] < arr[length-1]) {
			return arr[0];
		}
		if(arr[0] == arr[length-1]) {
			int min = arr[0];
			for(int i = 1;i < length;i++) {
				if (arr[i] < min) {
					min = arr[i];
				}
			}
			return min;
		}
		return findnumber(arr);
	}
	public static int findnumber(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		while(start < end - 1 ) {
			int med = start + (end - start) / 2;
			if (arr[med] > arr[start]) {
				start = med;
			}
			if(arr[med] < arr[end]) {
				end = med;
			}
		}
		return arr[end];
	}
}
