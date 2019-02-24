package Question15;
/*
 * 二进制数中1的个数，
 * 把数减去1再和原数做位与运算，相当于把原数最后一位1变成0.
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
