package Question56;
/*
 * 题目二：数组中唯一只出现一次的数字
 */
public class FindNumber {
	public static void main(String args[]) {
		int[] arr = {4,2,3,4,2,2,4};
		System.out.println(findNumber( arr));
	}
	
	public static int findNumber(int[] arr) {
		int[] ans = new int[32];
		int length = arr.length;
		for(int j = 31; j >= 0;j--) {
			int cur = 0;
			for(int i = 0 ; i < length;i++) {	
				cur += arr[i] % 2;
				arr[i] = arr[i] / 2;
			}
			if(cur % 3 == 0) {
				ans[j] = 0;
			}else {
				ans[j] = 1;
			}
		}
		int number = ans[31];
		int base = 2;
		for(int i = 1;i < 32;i++) {
			number = number + base * ans[31-i];
			base = base * 2;
		}
		return number;
	}
}
