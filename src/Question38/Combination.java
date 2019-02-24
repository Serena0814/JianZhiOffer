package Question38;

import java.util.ArrayList;

/*
 * 字符的组合
 * 注意：
 * 1.ab与ba是相同组合
 * 2.从头开始扫，对于每个字母有：加入此字母从剩下的后面的字符中选m-1个，或不加入此字母从剩下的后面的字符中选m个。
 * 3.递归的运用
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
		if(number == 0) {                    //此语句和下面不一样
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
