package Question14;
/*
 * 动态规划以及贪婪算法。
 * 应用：剪绳子。
 */
public class CutRope {
	public static void main(String args[]) {
		System.out.println(max1(8));
		System.out.println(max2(8));
	}
	
	public static int max1(int length) {  //动态规划
		int[] product = new int[length+1];
		if (length<2) {
			return 0;
		}
		if (length == 3) {
			return 2;
		}
		product[0] = 0;
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;
		
		for (int i = 4;i <= length; i++) {
			int max = 0;
			for (int j = 1;j <= i/2;j++) {
				int pro = product[j]*product[i-j];
				if (max < pro) {
					max = pro;
				}
			}
			product[i] = max;
		}
		return product[length];
	}
	
	public static int max2(int length) { //贪婪算法
		if (length<2) {
			return 0;
		}
		if (length == 3) {
			return 2;
		}
		int times3 = length/3;
		if(length - 3*times3 == 1) {
			times3 -= 1;
		}
		int times2 = (length - 3*times3)/2;
		return (int)Math.pow(3, times3)*(int)Math.pow(2, times2);
	}
}
