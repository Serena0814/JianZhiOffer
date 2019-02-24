package Question45;
/*
 * �������ų���С����
 * ��һ��ȫ���У���question38���ƣ�
 * �ص��ڷ���
 * ����˼·��
 * �Ƚ���������ת����String���飬Ȼ��String������������ź�����ַ�������ƴ�ӳ������ؼ������ƶ��������
 * ����������£�
 * ��ab > ba �� a > b��
 * ��ab < ba �� a < b��
 * ��ab = ba �� a = b��
 * ����˵����
 * ���� "3" < "31"���� "331" > "313"������Ҫ������ƴ���������бȽ�
 */

import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {
	public static void main (String[] args) {
		int[] numbers = {3,32,321};
		System.out.println(PrintMinNumber(numbers));
	}
	
	public static String PrintMinNumber(int [] numbers) {
		int length = numbers.length;
		String[] str = new String[length];
		String ans = "";
		if (length == 0) {
			return "";
		}
		if (length == 1) {
			return "" + numbers[0];
		}
		for(int i = 0; i < length; i ++) {  //ת��Ϊstring
			str[i] = "" + numbers[i];
		}
		Arrays.sort(str, new Comparator<String> () {   //��д�Ƚ����������õ��������ڲ���
			public int compare (String s1, String s2) {
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);
 			}
		});
		for (int i = 0; i < length; i ++) {
			ans += str[i];
		}
		return ans;
    }
}
