package Question29;
/*
 * ��ת��ӡ����
 * ע�⣺
 * 1.��һ����Ȧ��ӡ
 * 2.�ڶ�������ÿһȦ��δ�ӡ:��Ҫ���������
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
	
	public static void printMatrix(int[][] arr) {    //��Ȧ��ӡ
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
	
	public static void printMatrix(int[][] arr,int rowLength,int columnLength,int start) {  //ÿһȦ��δ�ӡ
		int i = start;
		int j = start;
		while(j < columnLength-start) {     //��ӡһ��
			System.out.print(" "+arr[i][j]);
			j++;
		}
		j --;
		
		i ++;
		while(i < rowLength-start) {       //��ӡһ��
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
