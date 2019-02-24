package Question47;
/*
 * ���������ֵ
 * ����һ��
 * ����һ����ά���飬newNum[i][j]ÿ��ֵ��ʾ���ǵ���number[i][j]��һ�յ�ʱ�������
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
		int row = number.length; //����
		int col = number[0].length; //����
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
