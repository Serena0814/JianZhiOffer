package Question19;
/*
 * ������ʽƥ���ַ���
 * 1.��ģʽ�ַ���һ���ַ�Ϊ��Ϊ��*������ֻ���ж��ַ�����ǰ�ַ���ģʽ�ַ��Ƿ���ͬ�����Ƿ�Ϊ��.��
 * 2.��ģʽ�ַ���һ���ַ�Ϊ��*����������ͬ��1.�ַ����±겻�䣬ģʽ�ַ�����ƶ���λ��2.�ַ����±�����ƶ�һλ��ģʽ�ַ����䣻3.�ַ����±�����ƶ�һλ��ģʽ�ַ�����ƶ���λ��
 * ������ͬ���ַ����±겻�䣬ģʽ�ַ�����ƶ���λ��
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
