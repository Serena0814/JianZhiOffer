package Question48;
/*
 * 最长不含重复字符的子字符串
 * 注意：
 * 1.不要用数组来表示瞬态值，而使用两个变量来表示，节省空间
 * 2.递归分析但要用循环来写，避免重复求值
 * 3.采用一个数组position[]来存储每个字母上次出现的下标，不用每次遍历，这是一种空间换时间的方式
 */
public class LongestSubString {
	public static void main (String[] args) {
		String str = "abcdfgtrhj";
		System.out.println(longestSubString(str));
	}
	
	public static int longestSubString(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] strings = str.toCharArray();
		int length = strings.length;
		int[] position = new int[26];
		int curmax = 0; //以当前字母结尾的子字符串中最长无重复个数
		int max = 0;  //最大的无重复子字符串的个数
		for(int i = 0 ; i < 26; i ++) {
			position[i] = -1;
		}
		for (int i = 0 ; i < length; i ++) {
			int index = position[strings[i] - 'a']; //上次string[i]出现的索引
			if(index == -1) {  //如果strings[i]没有出现过
				curmax ++;
			}
			else if(curmax >= i - index) {   //如果字符出现过
				curmax = i - index;
			}
			else {
				curmax ++;
			}
			max = max > curmax ? max : curmax;
			position[strings[i] - 'a'] = i;
		}
		return max;
	}
}
