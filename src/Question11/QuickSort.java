package Question11;
/*
 * 快排
 */
public class QuickSort {
	public static void main(String args[]) {
		int[] arr = {8,32,89,12,89,24,23,1,5,9,34,1,53,65,12,34};
		for (int i = 0;i < arr.length;i ++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		quickSort(arr,arr.length,0,arr.length-1);
		for (int i = 0;i < arr.length;i ++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void quickSort(int[] arr,int length,int start,int end) {
		if(start >= end) {
			return;
		}
		int index = partition(arr,length,start,end);
		if (index > start) {
			quickSort(arr,length,start,index-1);
		}
		if (index < end) {
			quickSort(arr,length,index+1,end);
		}
		
	}
	
	public static int partition(int[] arr,int length,int start,int end) {
		int index = start-1;//指向小于arr[end]的最后一个数字
		for(int i = start;i < end;i++) {
			if (arr[i] < arr[end]) {
				index ++;
				if (index != i) {
					int t = arr[i];
					arr[i] = arr[index];
					arr[index] = t;
				}
			}
		}
		index ++;
		int t = arr[end];
		arr[end] = arr[index];
		arr[index] = t;
		return index;
	}
}
