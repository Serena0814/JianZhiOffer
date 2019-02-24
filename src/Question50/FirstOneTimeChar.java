package Question50;
/*
 * ��һ��ֻ����һ�ε��ַ���
 * ��Ŀһ�������ַ����е�һ�γ��ֵ�û���ظ����ַ�
 * ע�⣺
 * ʹ��һ������Ϊ256�����飨�����ǹ�ϣ��
 * ��Ӧ����ascii��
 * ֻ��ɨ���ַ������μ���
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
