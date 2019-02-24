package Question64;
/*
 * 求1-n的整数和
 */
public class Add {
	public static void main(String args[]) {
		System.out.println(add(100));
		System.out.println(addTest(100));
	}
	
	public static int add(int num) {
		int sum = num;
		boolean flag = (sum > 0) && ((sum += add(num - 1) ) > 0);
		return sum;
	}
	
	public static int addTest(int num) {
		return (1 + num) * num / 2;
	}
}
