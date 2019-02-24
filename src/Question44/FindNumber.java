package Question44;
/*
 * 数字序列中某一位的数字，有两种解法
 * 法一枚举法，一边枚举一边计算总位数
 * 法二找出数学关系
 * 先给出法一
 */
public class FindNumber {
	public static void main (String[] args) {
		System.out.println(findNumber(1000));
	}
	
	public static int findNumber(int n) {
		if( n < 10) {
			return n;
		}
		int sum = 9;
		int i = 9;
		while (sum < n) {
			i++;
			sum += numberCount(i);
		}
		int fromRightToLeft = sum - n + 1; //右边第n位
		return compute(i,fromRightToLeft);
	}
	
	public static int numberCount(int i) {
		int count = 0;
		while(i != 0) {
			count ++;
			i /= 10;
		}
		return count;
	}
	
	public static int compute(int num, int fromRightToLeft) {
		for(int i = 1; i < fromRightToLeft; i ++) {
			num /= 10;
		}
		return num % 10;
	}
}
