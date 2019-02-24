package Question43;
/*
 * 从1-n的整数中出现1的次数
 * 解法二：
 * 采用数学手段和递归的方式解答
 */
public class HowManyTimes2 {
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(1000));
	}
	
	public static int NumberOf1Between1AndN_Solution(int n) {
	    if(n < 1) {
	    	return 0;
	    }
	    else if (n < 10) {
	    	return 1;
	    }
	    int length = LengthOfNumber(n);               //计算数字的位数
	    return digui(n,length);
    }
	
	public static int LengthOfNumber(int n) {
		if(n < 10) {
			return 1;
		}
		int count = 0;
		while(n != 0) {
			count ++;
			n = n / 10;
		}
		return count;
	}
	
	public static int digui(int n , int length) {
		if (n == 0) {
			return 0;
		}
		else if ( n < 10) {
			return 1;
		}
		int first = firstNumber(n,length); //first为高位
		int count = firstCount(length);
		int removeHigh = n - first * count;  //去掉高为后的数字
		int pianyi = 0;
		if ( first == 1) {
			pianyi = removeHigh + 1 + first * (length - 1) * firstCount(length - 1);
		}
		else {
			pianyi = count + first * (length - 1) * firstCount(length - 1);
		}
		return pianyi + digui(removeHigh,length - 1);
	}
	
	public static int firstNumber(int n, int length) { //计算最高位的数字
		return n/firstCount(length);
	}
	
	public static int firstCount(int length) {
		int sum = 1;
		for(int i = 1;i < length; i++) {
			sum *= 10;
		}
		return sum;
	}
}
