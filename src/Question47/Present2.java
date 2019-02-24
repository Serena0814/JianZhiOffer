package Question47;
/*
 * 方法二：
 * 采用一维数组代替二维数组
 */
public class Present2 {
	public static void main (String[] args) {
		int[][] number = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		int[][] number2 = {{1,2,3,4}};
		int[][] number3 = {{1},{2},{3}};
		System.out.println(present(number3));
	}
	
	public static int present(int[][] number) {
		if (number == null) {
			return 0;
		}
		int row = number.length; //行数
		int col = number[0].length; //列数
		if (row <= 0 || col <= 0) {
			return 0;
		}
		int[] newNum = new int[col];
		for (int i = 0 ; i < row; i++) {
			for (int j = 0; j < col; j ++) {
				int left = 0;
				int up = 0;
				
				if(i > 0) {
					up = newNum[j];
				}
				if(j > 0) {
					left = newNum[j - 1];
				}
				newNum[j] = left > up ? left : up;
				newNum[j] += number[i][j];
			}
		}
		return newNum[col - 1];
	}
}
