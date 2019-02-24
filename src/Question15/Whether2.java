package Question15;
/*
 * 判断一个数是否是2的整数次方
 */
public class Whether2 {
	public static void main(String args[]) {
		System.out.println(whether2(5));
	}
	
	public static boolean whether2(int number) {
		if(number <= 0) {
			return false;
		}
		int t = number-1;
		number = number & t;
		if(number != 0) {
			return false;
		}
		return true;
	}
}
