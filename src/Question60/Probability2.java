package Question60;
/*
 * 解法二：用循环的方式
 * 用两个数组（或是二维数组）
 * falg == 0时为一个数组，falg == 1时为另一个数组
 */
public class Probability2 {
	public static void main (String args[]) {
		probability(3);
	}
	
	public static void probability(int num) {
		if(num < 1) {
			System.out.println("无");
			return;
		}
		int[][] temp = new int[2][num * 6 + 1];
		int falg = 0;
		for(int i = 1;i <= 6;i++) {    //初始化数组
			temp[falg][i] = 1;
		}
		
		for(int i = 2;i <= num;i++) {
			for(int j = i; j <= 6*i;j++ ) {
				int t = 0;
				for(int m = 1; m <= 6;m++) {
					if(j-m > 0) {
						t += temp[falg][j-m];
					}
				}
				temp[1-falg][j] = t;
			}
			falg = 1 - falg;
		}
		
		int tatal = 0;
		for(int i = num; i <= num*6;i++) {
			tatal += temp[falg][i];
		}
		for(int i = num;i <= num *6;i++) {
			System.out.println(((double)temp[falg][i] / tatal));
		}
	}
}
