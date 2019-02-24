package Question47;
/*
 * 礼物的最大价值
 * 方法一：
 * 保存一个二维数组，newNum[i][j]每个值表示的是到达number[i][j]这一终点时最大的礼物。
 */
public class Present {
	public static void main (String[] args) {
		int[][] number = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		System.out.println(present(number));
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
		int[][] newNum = new int[row][col];
		for (int i = 0; i < row; i ++) { 
			for (int j = 0 ; j < col; j ++) {
				if (i > 0 && j > 0) {
					newNum[i][j] = newNum[i - 1][j] > newNum[i][j - 1] ? newNum[i - 1][j] : newNum[i][j - 1];
					newNum[i][j] += number[i][j];
				}
				else if( i == 0 && j == 0) {
					newNum[i][j] = number[i][j];
				}
				else if( i == 0 && j > 0) {
					newNum[i][j] = newNum[i][j - 1] + number[i][j];
				}
				else {
					newNum[i][j] = newNum[i - 1][j] + number[i][j];
				}
			}
		}
		return newNum[row - 1][col - 1];
	}
}
