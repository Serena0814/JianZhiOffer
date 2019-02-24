package Question19;
/*
 * 正则表达式匹配字符串
 * 1.若模式字符下一个字符为不为“*”，则只需判断字符串当前字符与模式字符是否相同，或是否为“.”
 * 2.若模式字符下一个字符为“*”，则若相同：1.字符串下标不变，模式字符向后移动两位；2.字符串下标向后移动一位，模式字符不变；3.字符串下标向后移动一位，模式字符向后移动两位；
 * 若不相同：字符串下标不变，模式字符向后移动两位。
 */
public class Zhengze {
	public static void main(String args[]) {
		char[] pattern= {'a','.','a'};
		char[] pattern2 = {'a','b','*','a','c','*','a'};
		char[] pattern3 = {'a','a','.','a'};
		char[] pattern4 = {'a','b','*','a'};
		char[] str = {'a','a','a'};
		System.out.println(zhengze(str,str.length,pattern,pattern.length));
		System.out.println(zhengze(str,str.length,pattern2,pattern2.length));
		System.out.println(zhengze(str,str.length,pattern3,pattern3.length));
		System.out.println(zhengze(str,str.length,pattern4,pattern4.length));
	}
	
	public static boolean zhengze(char[] str,int strLength,char[] pattern,int patternLength) {
		if(strLength == 0 || patternLength == 0) {
			return false;
		}
		return zhengzeDigui(str,strLength,0,pattern,patternLength,0);
	}
	
	public static boolean zhengzeDigui(char[] str,int strLength,int strindex,char[] pattern,int patternLength,int patternindex) {
		if(strindex >= strLength && patternindex >= patternLength) {
			return true;
		}
		if(strindex < strLength && patternindex >= patternLength) {
			return false;
		}
		if(strindex >= strLength && patternindex < patternLength) {
			return false;
		}
		if(patternindex+1 == patternLength) {
			if(pattern[patternindex] == str[strindex] || str[strindex] == '.') {
				return zhengzeDigui(str,strLength,strindex+1,pattern,patternLength,patternindex+1);
			}
			else {
				return false;
			}
		}
		if(patternindex+1 < patternLength && pattern[patternindex+1] != '*') {
			if(pattern[patternindex] == str[strindex] || pattern[strindex] == '.') {
				return zhengzeDigui(str,strLength,strindex+1,pattern,patternLength,patternindex+1);
			}
			else
			{
				return false;
			}
		}

		if(pattern[patternindex] == str[strindex] || pattern[strindex] == '.') {
			return zhengzeDigui(str,strLength,strindex+1,pattern,patternLength,patternindex+2) || 
					zhengzeDigui(str,strLength,strindex+1,pattern,patternLength,patternindex) ||
					zhengzeDigui(str,strLength,strindex,pattern,patternLength,patternindex+2);
		}
		else {
			return zhengzeDigui(str,strLength,strindex,pattern,patternLength,patternindex+2);
		}

	}
}
