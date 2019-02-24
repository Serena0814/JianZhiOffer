package Question20;
/*
 * 判断字符串是否表示数值
 */
public class StringNumber {
	public static void main(String args[]) {
		char[] str1 = {'+','1','0','0'};
		char[] str2 = {'5','e','2'};
		char[] str3 = {'-','1','2','3'};
		char[] str4 = {'3','.','1','4','1','6'};
		char[] str5 = {'-','1','E','-','1','6'};
		char[] str6 = {'1','2','e'};
		char[] str7 = {'1','a','3','.','1','4'};
		char[] str8 = {'1','.','2','.','3'};
		char[] str9 = {'+','-','5'};
		char[] str10 = {'1','2','e','+','5','.','4'};
		
		System.out.print(stringToNumber(str1)+" ");
		System.out.print(stringToNumber(str2)+" ");
		System.out.print(stringToNumber(str3)+" ");
		System.out.print(stringToNumber(str4)+" ");
		System.out.print(stringToNumber(str5)+" ");
		System.out.print(stringToNumber(str6)+" ");
		System.out.print(stringToNumber(str7)+" ");
		System.out.print(stringToNumber(str8)+" ");
		System.out.print(stringToNumber(str9)+" ");
		System.out.print(stringToNumber(str10)+" ");
	}	
	
	public static boolean stringToNumber(char[] str) {
		if (str.length == 0) {
			return false;
		}
		int index = 0;
		boolean num = checkSignedNumber(str,index);
		index = scanSignedNumber(str,index);
		if (index < str.length && str[index] == '.') {
			num = num || checkUnsignedNumber(str,index+1);   //重点
			index = scanUnsignedNumber(str,index+1);
		}
		if(index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			num = num && checkSignedNumber(str,index+1);    //重点
			index = scanSignedNumber(str,index+1);
		}
		return num && (index == str.length);    //重点
	}	
	
	public static int scanSignedNumber(char[] str,int index) {    //扫描带符号整数
		int length = str.length;
		if(index < length && (str[index] == '+' || str[index] == '-')) {
			return scanUnsignedNumber(str,index+1);
		}
		return scanUnsignedNumber(str,index);
	}
	
	public static boolean checkSignedNumber(char[] str,int index) {
		int length = str.length;
		if(index < length && (str[index] == '+' || str[index] == '-')) {
			return checkUnsignedNumber(str,index+1);
		}
		return checkUnsignedNumber(str,index);
	}
	
	public static boolean checkUnsignedNumber(char[] str,int index) {   //扫描无符号整数
		int oldindex = index;
		int length = str.length;
		if(index >= length) {
			return false;
		}
		while(index < length && str[index] <= '9' && str[index] >= '0') {
			index ++;
		}
		if(oldindex == index) {
			return false;
		}
		return true;
	}
	
	public static int scanUnsignedNumber(char[] str,int index) {
		int length = str.length;
		while(index < length && str[index] <= '9' && str[index] >= '0') {
			index ++;
		}
		return index;
	}
}
