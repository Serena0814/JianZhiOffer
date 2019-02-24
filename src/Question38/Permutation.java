package Question38;

import java.util.ArrayList;
import java.util.Collections;
/*
 * 字符串的全排列
 * 注意:
 * 1.字符串每次都被分为两部分，第一个字母和后面
 * 2.递归的运用
 * 3.去重复
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
		Collections.sort(array);  //要排序
		return array;
	}
	
	public static void permutation(ArrayList<String> array,char[] arr,int indexStart,int indexEnd) {
		if(indexStart == indexEnd ) {
			String str = new String(arr);
			array.add(str);   //解空间的叶节点才add
			return;
		}
		for(int i = indexStart;i <= indexEnd;i++) {
			if(i == indexStart || arr[indexStart] != arr[i]) {   //去重复
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
