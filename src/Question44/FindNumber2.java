package Question44;
/*
 * 方法二：采用某种规律大大减少时间，善于利用数学分析
 */
public class FindNumber2 {
	public static void main (String[] args) {
		System.out.println(findNumber(11));
	}
	
	public static int findNumber(int n) {
		if( n < 10) {
			return n;
		}
		int base = 90;
		int count = 2; //代表2位数
		int sum = 9 + base * count;
		while(sum < n) {
			base *= 10;
			count ++;
			sum += base * count;
		}
		sum -= base * count;
		int number = base10(count) + (n - sum) / count; //此为找出的数字
		int fromRightToLeft = count - (n - sum) % count; //从右往左的第n位
		for(int i = 1; i < fromRightToLeft; i++) {
			number /= 10;
		}
		return number % 10;
	}
	
	public static int base10 (int n) {
		int sum = 1;
		for(int i = 1; i < n; i ++) {
			sum *= 10;
		}
		return sum;
	}
}
