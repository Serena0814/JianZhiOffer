package Question50;
/*
 * �����Ŀ��
 * ���������ַ������ӵ�һ���ַ�����ɾ���ڵڶ����ַ����г��ֵ������ַ�
 * ����������һ�����飨���߹�ϣ��
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
		int num = 0; //���ֶ��ٸ��ַ�
		//ͳ��ÿ����ĸ���ֵĴ���
		for(int i = 0;i < length2;i ++) {  
			count[(int) c2[i]] ++;
		}
		//ͳ�� ���ֶ��ٴ�
		for(int i = 0;i < 256;i ++) {
			if(count[i] > 0) {
				num ++;
			}
		}
		//�������ַ���
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
