package Question43;
/*
 * 从1-n的整数中出现1的次数
 * 解法一：
 * 遍历每个数字统计每个数字出现1的次数，从而统计总次数
 */
public class HowManyTimes {
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(1000));
	}
	
	public static int NumberOf1Between1AndN_Solution(int n) {
	    if(n < 1) {
	    	return 0;
	    }
	    int num = 0; //总次数
	    for (int i = 1; i <= n; i++) {
	    	int count = 0; //每个数字出现1的次数
	    	int j = i;
	    	while( j != 0 ) {
	    		if(j % 10 == 1) {
	    			count++;
	    		}
	    		j = j / 10;
	    	}
	    	num += count;
	    }
	    return num;
    }
}
