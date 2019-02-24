package Question48;
/*
 * ������ظ��ַ������ַ���
 * ע�⣺
 * 1.��Ҫ����������ʾ˲ֵ̬����ʹ��������������ʾ����ʡ�ռ�
 * 2.�ݹ������Ҫ��ѭ����д�������ظ���ֵ
 * 3.����һ������position[]���洢ÿ����ĸ�ϴγ��ֵ��±꣬����ÿ�α���������һ�ֿռ任ʱ��ķ�ʽ
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
		int curmax = 0; //�Ե�ǰ��ĸ��β�����ַ���������ظ�����
		int max = 0;  //�������ظ����ַ����ĸ���
		for(int i = 0 ; i < 26; i ++) {
			position[i] = -1;
		}
		for (int i = 0 ; i < length; i ++) {
			int index = position[strings[i] - 'a']; //�ϴ�string[i]���ֵ�����
			if(index == -1) {  //���strings[i]û�г��ֹ�
				curmax ++;
			}
			else if(curmax >= i - index) {   //����ַ����ֹ�
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
