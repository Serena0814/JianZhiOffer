package Question15;
/*
 * 统计两个数的二进制数有多少位不同：
 * 1.将两个数进行异或；
 * 2.统计结果中1的个数。
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
