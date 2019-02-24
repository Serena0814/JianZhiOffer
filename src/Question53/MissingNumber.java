package Question53;
/*
 * 0~n-1��ȱʧ������(��Ŀ��)
 * ע�⣺
 * 1.����Ŀ����ת��Ϊ���������������ҳ���һ��ֵ���±겻��ȵ�Ԫ�ء�
 * 2.����ѭ������ݹ�ķ�ʽ���
 */
public class MissingNumber {
	public static void main(String args[]) {
		int[] array = {0,2};
		System.out.println(missingNumber(array));
	}
	
	public static int missingNumber(int[] array) {
		int length = array.length;
		int start = 0;
		int end = length - 1;
		
		while(start <= end) {
			int med = (start + end) / 2;
			if(array[med] == med) {
				start = med + 1;
			}else if(med == 0 || array[med - 1] == med - 1){
				return med;
			}else {
				end = med - 1;
			}
		}
		return -1;
	}
}
