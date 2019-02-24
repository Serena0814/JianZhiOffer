package Question38;

import java.util.ArrayList;

/*
 * 8个数字的数组使其放到正方体8个顶点上
 * 注意：
 * 由于顶点随意放置，需要全排列
 */
public class Cube {
	public static void main(String args[]) {
		int[] arr = {1,1,1,1,1,1,1,1};
		System.out.println(cube(arr));
	}
	
	public static boolean cube(int[] arr) {
		if(arr.length != 8) {
			return false;
		}
		ArrayList<int[]> array = new ArrayList<int[]>();
		permutation(arr,array,0);
		int sum = 0;
		for(int i = 0;i < 8;i++) {
			sum += arr[i];
		}
		for(int[] num:array) {
			if(num[0]+num[1]+num[2]+num[3] == sum/2 && num[0]+num[2]+num[4]+num[6] == sum/2 && num[2]+num[3]+num[6]+num[7] == sum/2) {
				return true;
			}
		}
		return false;
	}
	
	public static void permutation(int[] arr,ArrayList<int[]> array,int index) {
		if(index == arr.length) {
			array.add(arr);
			return;
		}
		for(int i = index;i < arr.length;i++) {
			if(i == index || arr[i] != arr[index]) {
				exchange(arr,index,i);
				permutation(arr,array,index+1);
				exchange(arr,index,i);
			}
		}
	}
	public static void exchange(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
