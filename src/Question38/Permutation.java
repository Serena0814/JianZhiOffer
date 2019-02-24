package Question38;

import java.util.ArrayList;
import java.util.Collections;
/*
 * �ַ�����ȫ����
 * ע��:
 * 1.�ַ���ÿ�ζ�����Ϊ�����֣���һ����ĸ�ͺ���
 * 2.�ݹ������
 * 3.ȥ�ظ�
 */
public class Permutation {
	public static void main(String args[]) {
		String str = "abc";
		ArrayList<String> array = permutation(str);
		for(String s:array) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> permutation(String str) {
		if(str == null) {
			return null;
		}
		char[] arr = str.toCharArray();
		ArrayList<String> array = new ArrayList<String>();
		permutation(array,arr,0,arr.length-1);
		Collections.sort(array);  //Ҫ����
		return array;
	}
	
	public static void permutation(ArrayList<String> array,char[] arr,int indexStart,int indexEnd) {
		if(indexStart == indexEnd ) {
			String str = new String(arr);
			array.add(str);   //��ռ��Ҷ�ڵ��add
			return;
		}
		for(int i = indexStart;i <= indexEnd;i++) {
			if(i == indexStart || arr[indexStart] != arr[i]) {   //ȥ�ظ�
				exchange(arr,indexStart,i);
				permutation(array,arr,indexStart + 1,indexEnd);
				exchange(arr,indexStart,i);
			}
		}
		return;
	}
	
	public static void exchange(char[] arr,int i,int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
