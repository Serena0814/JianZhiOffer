package Question40;
/*
 * ͨ��������Ѱ����С��K����
 */
public class FindByHeap {
	public static void main(String args[]) {
		int[] arr = {4,5,1,6,2,7,3,8};
		int[] heap = findByHeap(arr,1);
		for(int i:heap) {
			System.out.print(" " + i);
		}
	}
	public static int[] findByHeap(int[] arr,int k) {
		if(k <= 0) {                 //�����ж�
			return null;  
		}
		int[] heap = new int[k];
		int length = arr.length;
		if(length < k) {
			return heap;
		}
		for(int i = 0;i < k;i++) {     //����һ������
			heap[i] = arr[i];
		}
	    buildHeap(heap,k);
	    for(int i = k;i < length;i++) {  //���бȽϵ���
	    	if(heap[0] > arr[i]) {
	    		heap[0] = arr[i];
	    		heapify(heap,0,k);
	    	}
	    }
	    return heap;
	}
	public static void buildHeap(int[] heap,int size) {
		for(int i = size / 2 - 1;i >= 0;i--) {
			heapify(heap,i,size);
		}
	}
	public static void heapify(int[] heap,int i,int size) {   //�������µ���
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int max = i;
		if(left < size && heap[left] > heap[max]) {
			max = left;
		}
		if(right < size && heap[right] > heap[max]) {
			max = right;
		}
		if(max != i) {
			swap(heap,max,i);
			heapify(heap,max,size);
		}
	}
	public static void swap(int[] heap,int i ,int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
