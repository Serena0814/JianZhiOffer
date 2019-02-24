package Question17;
/*
 * 打印从1到最大的n位数
 * 注意：
 * 1.大数据问题，用字符串或数组表示；
 * 2.打印时要忽略高位的0；
 */
public class PrintN {
	public static void main(String args[]) {
		printN(2);
	}
	
	public static void printN (int n) {
		if (n <= 0) {
			System.out.println("输入位数错误");
			return ;
		}
		int[] number = new int[n];
		printDigui(number,n,0);
	}
	
	public static void printDigui(int[] number,int length,int index) {
		if (index == length) {
			printNumber(number,length);
			return ;
		}
		for (int i = 0;i<10;i++) {
			number[index] = i;
			printDigui(number,length,index+1);
		}
	}
	
	public static void printNumber (int[] number,int n) {
		int i = 0;
		for(;i < n;i++) {
			if(number[i]!=0) {
				break;
			}
		}
		if(i == n) {
			return ;
		}
		while(i < n) {
			System.out.print(number[i]);
			i++;
		}
		System.out.print(" ");
		return ;
	}
}
