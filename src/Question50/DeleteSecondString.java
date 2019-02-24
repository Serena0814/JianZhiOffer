package Question50;
/*
 * 相关题目：
 * 输入两个字符串，从第一个字符串中删除在第二个字符串中出现的所有字符
 * 方法：建立一个数组（或者哈希表）
 */
public class DeleteSecondString {
	public static void main(String args[]) {
		String str1 = "fjfxfb";
		String str2 = "fb";
		System.out.println(deleteSecondString (str1,str2));
	}
	
	public static String deleteSecondString (String s1, String s2) {
		if (s1 == null || s2 == null)   return s1;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int length1 = c1.length;
		int length2 = c2.length;
		
		if(length1 == 0 || length2 == 0) return s1;
		
		int[] count = new int[256];
		int num = 0; //出现多少个字符
		//统计每个字母出现的次数
		for(int i = 0;i < length2;i ++) {  
			count[(int) c2[i]] ++;
		}
		//统计 出现多少次
		for(int i = 0;i < 256;i ++) {
			if(count[i] > 0) {
				num ++;
			}
		}
		//建立新字符串
		char[] copy = new char[length1 - num];
		int index = 0;
		for(int i = 0 ; i < length1; i++) {
			if(count[(int) c1[i]] == 0) {
				copy[index] = c1[i];
				index ++;
			}
		}
		return String.valueOf(copy);
	}
}
