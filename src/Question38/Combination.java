package Question38;

import java.util.ArrayList;

/*
 * �ַ������
 * ע�⣺
 * 1.ab��ba����ͬ���
 * 2.��ͷ��ʼɨ������ÿ����ĸ�У��������ĸ��ʣ�µĺ�����ַ���ѡm-1�����򲻼������ĸ��ʣ�µĺ�����ַ���ѡm����
 * 3.�ݹ������
 */
public class Combination {
	public static void main(String args[]) {
		String str = "abc";
		ArrayList<String> array = combination(str);
		for(String s:array) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> combination(String str) {
		if(str == null) {
			return null;
		}
		char[] arr = str.toCharArray();
		ArrayList<String> array = new ArrayList<String>();
		StringBuilder strbuild = new StringBuilder();
		for(int number = 1;number <= arr.length;number++) {
			combination(array,arr,0,number,strbuild);
		}
		return array;
	}
	
	public static void combination(ArrayList<String> array,char[] arr,int index,int number,StringBuilder strbuild) {
		int length = arr.length;
		if(number == 0) {                    //���������治һ��
			array.add(strbuild.toString());
			return;
		}
		if(index >= length) {
			return;
		}
		strbuild.append(arr[index]);
		combination(array,arr,index+1,number-1,strbuild);
		strbuild.deleteCharAt(strbuild.length()-1);
		combination(array,arr,index+1,number,strbuild);
	}
}
