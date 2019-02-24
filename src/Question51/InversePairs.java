package Question51;
/*
 * �����е������
 * ����һ�������ⷨ
 * ���������鲢�ⷨ
 * ������÷������Ľⷨ
 */
public class InversePairs {
	public static void main(String args[]) {
		int[] array = {7,5,6,4};
		System.out.println(inversePairs(array));
	}
	
	public static int inversePairs(int [] array) {
		int length = array.length;
        if(length == 0 || length == 1) {
        	return 0;
        }
        
        int[] copy = new int[length];
        for(int i = 0; i < length; i ++) {
        	copy[i] = array[i];
        }
        return inversePairsCore(array,copy,0,length - 1);
    }
	
	public static int inversePairsCore(int[] array, int[] copy,int start, int end) {
		if (start == end) {
			copy[start] = array[start];
			return 0;
		}
		
		int length = (end - start) / 2 ;
		int left = inversePairsCore(copy, array,start,start + length) % 1000000007;
		int right = inversePairsCore(copy, array,start + length + 1, end) % 1000000007;
		int i = start + length;  //��ʾ����������һλ
		int j = end;  //��ʾ�ұ��������һλ
		int indexCopy = end; //��ʾcopy������±�
		int count = 0;  //���������
		
		while(i >= start && j >= start + length + 1 ) {
			if(array[i] > array[j]) {
				copy[indexCopy] = array[i];
				indexCopy --;
				i--;
				count += j - start -length;
			}else {
				copy[indexCopy] = array[j];
				j--;
				indexCopy --;
			}
		}
		
		for(;i >= start;i--) {
			copy[indexCopy] = array[i];
			indexCopy --;
		}
		for(;j >= start + length + 1;j--) {
			copy[indexCopy] = array[j];
			indexCopy --;
		}
		if(count >= 1000000007) {
			count %= 1000000007;
		}
		return (left + right + count) % 1000000007;
	}
}
