package Question40;

import java.util.ArrayList;

/*
 * 找到数组中最小的k个数（方法一）
 * 注意：
 * 1.使用partition方法
 * 2.此方法修改了原数组
 */
public interface FindK {
	public static void main(String args[]) {
		int[] arr = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> list = findK(arr,4);
		for(int i:list) {
			System.out.print(" " + i);
		}
	}
	public static ArrayList<Integer> findK(int[] arr,int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int length = arr.length;
		if(length < k || k <= 0) {
			return list;
		}
		int start = 0;
		int end = length - 1;
		int index = partition(arr,start,end);
		while(index != k-1) {
			if(index > k - 1) {
				index = partition(arr,start,index - 1);
			}
			else {
				index = partition(arr,index + 1,end);
			}
		}
		
		for(int i = 0; i < k;i++) {
			list.add(arr[i]);
		}
		return list;
	}
	public static int partition(int[] arr,int start,int end) {
		int index = start -1;
		int temp = 0;
		for(int i = start;i < end;i++) {
			if(arr[i] < arr[end]) {
				index ++;
				if(i != index) {
					temp = arr[i];
					arr[i] = arr[index];
					arr[index] = temp;
				}
			}
		}
		index++;
		temp = arr[end];
		arr[end] = arr[index];
		arr[index] = temp;
		return index;
	}
}
