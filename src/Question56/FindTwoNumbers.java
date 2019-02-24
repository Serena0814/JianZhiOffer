package Question56;
/*
 * ���������ֳ��ֵĴ�����
 * ��Ŀһ:������ֻ����һ�ε���������
 * ע��
 * 1�������������
 * 2����ΰ�����ֵ��������ǹؼ�
 */
public class FindTwoNumbers {
	public static void main(String args[]) {
		int [] arr = {2,4,3,6,3,2,5,5};
		int[] num1 = new int[1];
		int[] num2 = new int[2];
		FindNumsAppearOnce(arr, num1 , num2);
		System.out.println(num1[0]+" "+num2[0]);
	}
	
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		if(array == null) {
			return;
		}
		int num = 0;
		int length = array.length;
		for(int i = 0;i<length;i ++ ) {
			num ^= array[i];
		}
		int index = findIndex(num);
		
		for(int i = 0; i < length ; i++) {
			if(findIndex(array[i]) == index) {
				num1[0] ^= array[i];
			}else {
				num2[0] ^= array[i];
			}
			
		}
		return;
	}
	public static int findIndex(int num)  {
		if(num == 0) {
			return -1;
		}
		int index = 0;   //�����Ƶ��ұߵ�indexλ
		while(num % 2 == 0) {
			num = num / 2;
			index ++;
		}
		return index;
	}
	
}
