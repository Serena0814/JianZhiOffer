package Question50;
/*
 * 相关问题：
 * 两个单词中出现的字母相同，每个字母出现的次数也相同，则这两个词为变位词。
 * 使用一个辅助数组来记录一个字符串中每个字母出现的次数
 * 另一个字符串使数组减一
 * 最后看数组是否全为0
 */
public class Anagram {
	public static void main(String args[]) {
		String str1 = "ddfdggfh";
		String str2 = "dffhgdgd";
		System.out.println(anagram (str1,str2));
	}
	
	public static boolean anagram (String s1, String s2) {
		int length1 = s1.length();
		int length2 = s2.length();
		if(length1 ==0 && length2 == 0) return true;
		else if(length1 == 0 && length2 != 0) return false;
		else if (length2 == 0 && length1 != 0) return false;
		else if(length1 != length2) return false;
		
		int[] number = new int[256];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		for(int i = 0; i < length1 ; i ++) {  //一个循环搞定两个字符串
			number[c1[i]] ++;
			number[c2[i]] --;
		}
		
		for (int i = 0; i < 256; i++) {  //检查是否全为0
			if(number[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
