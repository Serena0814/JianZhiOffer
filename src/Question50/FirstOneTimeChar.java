package Question50;
/*
 * 第一次只出现一次的字符：
 * 题目一：返回字符串中第一次出现的没有重复的字符
 * 注意：
 * 使用一个长度为256的数组（书中是哈希表）
 * 对应的是ascii码
 * 只需扫描字符串两次即可
 */
public class FirstOneTimeChar {
	public static void main(String args[]) {
		String str = "ssgsggre";
		System.out.println(FirstNotRepeatingChar(str));
	}
	
	public static char FirstNotRepeatingChar(String str) {
		if(str == null) {
			return 0;
		}
		char[] c = str.toCharArray();
		int length = c.length;
		int[] count = new int[256];
		for (int i = 0; i < length; i++) {
			count[(int) c[i]] ++;
		}
		for(int i = 0; i < length; i ++ ) {
			if(count[(int) c[i]] == 1) {
				return c[i];
			}
		}
		return 0;
	}
}
