package Question15;
/*
 * ͳ���������Ķ��������ж���λ��ͬ��
 * 1.���������������
 * 2.ͳ�ƽ����1�ĸ�����
 */
public class HowMuchNumber {
	public static void main(String args[]) {
		System.out.println(howMuch1(10,13));
	}
	public static int howMuch1(int number1,int number2) {
		int num = number1 ^ number2;
		int count = 0;
		while(num != 0) {
			int t = num - 1;
			num = num & t;
			count ++;
		}
		return count;
	}
}
