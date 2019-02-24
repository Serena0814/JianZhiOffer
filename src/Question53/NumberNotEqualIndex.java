package Question53;
/*
 * �ҳ���������ֵ���±���ȵ�Ԫ��
 * ���㣺���ֲ���˼�룬ѭ������ʵ��
 */
public class NumberNotEqualIndex {
	public static void main(String args[]) {
		int[] array = {0};
		System.out.println(numberEqualIndex(array));
	}
	
	public static int numberEqualIndex(int[] array) {
		int length = array.length;
		int start = 0;
		int end = length - 1;
		
		while(start <= end) {
			int med = (start + end) / 2;
			if(med == array[med]) {
				return med;
			}else if(med < array[med]) {
				end = med - 1;
			}else {
				start = med + 1;
			}
		}
		return -1;
	}
}
