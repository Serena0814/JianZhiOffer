package Question50;
/*
 * �����Ŀ��
 * ɾ���ַ����������ظ����ֵ��ַ�
 * ������һ�����������ʾ
 */
public class DeleteRepeatChar {
	public static void main(String args[]) {
		String str1 = "ddfdggfh";
		System.out.println(deleteRepeatChar (str1));
	}
	
	public static String deleteRepeatChar(String str) {
		if(str == null)  return str;
		int length = str.length();
		if (length == 0 || length == 1) return str;
		
		boolean[] count = new boolean[256];
		char[] c = str.toCharArray();
		String s = new String();
		
		for (int i = 0 ; i < length; i++) {
			if(!count[c[i]]) {
				s += c[i];
				count[c[i]] = true;
			}
			else {}
		}
		return s;
	}
}
