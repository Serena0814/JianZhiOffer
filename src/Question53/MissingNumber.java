package Question53;
/*
 * 0~n-1中缺失的数字(题目二)
 * 注意：
 * 1.该题目可以转化为：在排序数组中找出第一个值和下标不相等的元素。
 * 2.采用循环代替递归的方式解答
 */
public class MissingNumber {
	public static void main(String args[]) {
		int[] array = {0,2};
		System.out.println(missingNumber(array));
	}
	
	public static int missingNumber(int[] array) {
		int length = array.length;
		int start = 0;
		int end = length - 1;
		
		while(start <= end) {
			int med = (start + end) / 2;
			if(array[med] == med) {
				start = med + 1;
			}else if(med == 0 || array[med - 1] == med - 1){
				return med;
			}else {
				end = med - 1;
			}
		}
		return -1;
	}
}
