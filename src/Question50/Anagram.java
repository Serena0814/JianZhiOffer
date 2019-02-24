package Question50;
/*
 * ������⣺
 * ���������г��ֵ���ĸ��ͬ��ÿ����ĸ���ֵĴ���Ҳ��ͬ������������Ϊ��λ�ʡ�
 * ʹ��һ��������������¼һ���ַ�����ÿ����ĸ���ֵĴ���
 * ��һ���ַ���ʹ�����һ
 * ��������Ƿ�ȫΪ0
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
		
		for(int i = 0; i < length1 ; i ++) {  //һ��ѭ���㶨�����ַ���
			number[c1[i]] ++;
			number[c2[i]] --;
		}
		
		for (int i = 0; i < 256; i++) {  //����Ƿ�ȫΪ0
			if(number[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
