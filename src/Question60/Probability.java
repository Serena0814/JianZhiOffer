package Question60;
/*
 * n个骰子的点数：
 * 解法一：递归 （自顶向下） 复杂度过高，重复运算多
 * 解法二：循环（自底向上）
 * 这里采用解法一 （不采用书上的格式）
 */
public class Probability {
	public static void main(String args[]) {
		solution(3);
	}
	
	public static void solution(int num) {
		if(num == 0) {
			System.out.println(0);
			return;
		}
		double [] counts = new double[5*num + 1];
		double total = 0;
		for(int i = num;i <= 6*num;i++) {
			counts[i - num] = (double)count(num,i);
			total += counts[i - num];
		}
		for(int i = num;i <= 6*num;i++) {
			counts[i - num] /= total;
			System.out.println(counts[i - num]);
		}	
	}
	
	public static int count(int num,int sum) {
		if(num <= 0 || sum <= 0 || sum > num*6) {
			return 0;
		}
		if(num == 1) {
			return 1;   //边界值
		}
		return count(num - 1, sum -1) + count(num - 1, sum -2)+
					count(num - 1, sum -3)+count(num - 1, sum -4)+count(num - 1, sum -5) 
					+count(num - 1, sum -6);
	}
}

