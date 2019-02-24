package Question38;

import java.util.ArrayList;

/*
 * �ʺ���
 */
public class Queue {
	public static void main(String args[]) {
		System.out.println(queue());
	}
	public static int queue() {
		int[] arr = {0,1,2,3,4,5,6,7};  //��֤���к��в���һ������
		ArrayList<int[]> array = new ArrayList<int[]>();
		permutation(array,arr,0);
		int count = 0;
		for(int[] number :array) {
			count ++;
			outer:for(int i = 0;i < 8;i++) {
				for(int j = i+1;j<8;j++) {
					if((number[i]-number[j]) == (i-j) || (number[i]-number[j]) == (j - i)) {
						count -- ;
						break outer;
					}
				}
			}
		}
		return count;
	}
	public static void permutation(ArrayList<int[]> array,int[] arr,int index) {
		if(index == 7) {
			int[] arrCopy = new int[8];
			for(int i = 0;i < 7;i++ ) {      //ע�⣬����Ҫ���ƺ����������������ֻ������arr�����ã�����Ч��
				arrCopy[i] = arr[i];
			}
			array.add(arrCopy);
			return;
		}
		for(int i = index;i < 8;i++) {
				exchange(arr,i,index);

				permutation(array,arr,index+1);
				exchange(arr,i,index);

		}
		return;
	}
	public static void exchange(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
