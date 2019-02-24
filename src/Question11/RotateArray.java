package Question11;
/*
 * ����ת�����е���Сֵ
 * ע�⣺
 * 1.��Ϊ˳�����飬ֱ�ӷ��ص�һ��ֵ��
 * 2.����һ�����ֺ����һ�����־�Ϊ��Сֵ��˳������飻
 * 3.��������ֲ��ҡ�
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
