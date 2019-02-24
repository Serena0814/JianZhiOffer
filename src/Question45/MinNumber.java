package Question45;
/*
 * 把数组排成最小的数
 * 法一：全排列（与question38类似）
 * 重点在法二
 * 解题思路：
 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * 排序规则如下：
 * 若ab > ba 则 a > b，
 * 若ab < ba 则 a < b，
 * 若ab = ba 则 a = b；
 * 解释说明：
 * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
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
		for(int i = 0; i < length; i ++) {  //转化为string
			str[i] = "" + numbers[i];
		}
		Arrays.sort(str, new Comparator<String> () {   //重写比较器，这里用到了匿名内部类
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
