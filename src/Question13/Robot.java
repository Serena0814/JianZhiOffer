package Question13;
/*
 * 回溯法：机器人题。
 */
public class Robot {
	public static void main(String args[]) {
		int[][] nums = new int[6][6];
		System.out.println(robot(nums,4));
	}
	
	public static int robot(int[][] num,int k) {
		int row = num.length;
		if (row == 0 || k < 0) {
			return 0;
		}
		int col = num[0].length;
		if(col == 0) {
			return 0;
		}
		boolean [][] visited = new boolean[row][col]; 
		return ithaspath(row,col,0,0,k,visited);
	}
	
	public static int ithaspath(int rows,int cols,int row,int col,int k,boolean[][] visited) {
		int number = 0;
		if(check(rows,cols,row,col,k,visited)) {
			visited[row][col] = true;
			number = 1 + ithaspath(rows,cols,row+1,col,k,visited)+
					ithaspath(rows,cols,row-1,col,k,visited)+
					ithaspath(rows,cols,row,col+1,k,visited)+
					ithaspath(rows,cols,row,col-1,k,visited);
		}
		return number;
	}
	
	public static boolean check(int rows,int cols,int row,int col,int k,boolean[][] visited) {
		if( row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col]) {
			return false;
		}
		int sum = 0;
		while(row > 0) {
			sum += row % 10;
			row /= 10;
		}
		while(col > 0) {
			sum += col % 10;
			col /= 10;
		}
		if( sum <= k) {
			return true;
		}
		return  false;
	}
}
