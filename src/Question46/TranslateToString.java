package Question46;
/*
 * 把数字翻译成字符串
 * 注意：
 * 从最后一位开始分析
 * 若从第一位开始分析并递归会有重复的问题
 * 从左或右分析都可以，但不能用递归
 */
public class TranslateToString {
	public static void main (String[] args) {
		int number = 12258;
		System.out.println(translateToString(number));
	}
	
	public static int translateToString(int number) {
		if (number <= 0 ) {
			return 0;
		}
		String str = "" + number;
		int length = str.length();
		int[] count = new int[length];
		count[length - 1] = 1;
		for (int i = length - 2; i >= 0;i --) {
			count[i] = count[i + 1];
			if (canBeTransfer(str,i)) {
				if ( i == length - 2) {
					count[i] ++;
				}
				else {
					count[i] += count[i + 2];
				}
			}
		}
		return count[0];
	}
	
	public static boolean canBeTransfer(String str, int i) { //判断第i位能否与第i+1位组成一个字母
		int a = str.charAt(i) - '0';
		int b = str.charAt(i + 1) - '0';
		int num = a * 10 + b;
		if (num >= 10 && num <= 25) {
			return true;
		}
		return false;
	}
}
