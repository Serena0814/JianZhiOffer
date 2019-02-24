package Question29;
/*
 * 旋转打印矩阵
 * 注意：
 * 1.第一步按圈打印
 * 2.第二步考虑每一圈如何打印:需要分情况讨论
 */
public class PrintMatrix {
	public static void main(String args[]) {
		int[][] arr1 = {{1,2,3}};
		int[][] arr2 = {{1},{2},{3}};
		int[][] arr3 = {{1}};
		int[][] arr4 = {{1,2,3},{4,5,6},{7,8,9}};
		printMatrix(arr1);
		printMatrix(arr2);
		printMatrix(arr3);
		printMatrix(arr4);
	}
	
	public static void printMatrix(int[][] arr) {    //按圈打印
		int rowLength = arr.length;
		if(rowLength == 0) {
			return ;
		}
		int columnLength = arr[0].length;
		int i = 0;
		while(i * 2 < rowLength && i * 2 < columnLength) {
			printMatrix(arr,rowLength,columnLength,i);
			i++;
		}
		System.out.println();
	}
	
	public static void printMatrix(int[][] arr,int rowLength,int columnLength,int start) {  //每一圈如何打印
		int i = start;
		int j = start;
		while(j < columnLength-start) {     //打印一行
			System.out.print(" "+arr[i][j]);
			j++;
		}
		j --;
		
		i ++;
		while(i < rowLength-start) {       //打印一列
			System.out.print(" "+arr[i][j]);
			i++;
		}
		i--;
		
		j--;
		while(i > start && j >= start) {
			System.out.print(" "+arr[i][j]);
			j--;
		}
		j++;
		
		i--;
		while(rowLength - 2*start >= 3 && columnLength - 2*start >= 2 && i > start) {
			System.out.print(" "+arr[i][j]);
			i--;
		}
	}
}
