package Question15;
/*
 * ����������1�ĸ�����
 * ������ȥ1�ٺ�ԭ����λ�����㣬�൱�ڰ�ԭ�����һλ1���0.
 */
public class BinaryNumber {
	public static void main(String args[]) {
		System.out.println(number1(1));
	}
	
	public static int number1(int number) {
		int count = 0;
		while(number != 0) {
			int t = number - 1;
			number = number & t;
			count ++;
		}
		return count;
	}
}
