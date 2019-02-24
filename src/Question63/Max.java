package Question63;
/*
 * 股票的最大利润
 * 
 */
public class Max {
	public static void main(String args[]) {
		int[] num = {9,11,8,5,7,12,16,14};
		System.out.println(getMax(num));
	}
	
	public static int getMax(int[] num) {
		int length = num.length;
		if(length < 2) {
			return 0;
		}
		int min = num [0];
		int maxP = 0;
		
		for(int i = 1; i < length;i++) {
			if(num[i] < min) {
				min = num[i];
			}else if(num[i] - min > maxP){
				maxP = num[i] - min;
			}
		}
		return maxP;
	}
}
