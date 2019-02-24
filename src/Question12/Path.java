package Question12;
/*
 * 矩阵中的路径(回溯法)
 */
public class Path {
	public static void main(String args[]) {
		char[][] arr = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
		String s = "bft";
		System.out.println(haspath(arr,s));
	}
	
	public static boolean haspath(char[][] arr,String s) {
		if (arr == null) {
			return false;
		}
		int row = arr.length;
		int col = arr[0].length;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0;i < row;i++) {
			for (int j = 0;j < col;j++) {
				if (haspathCore(arr,row,col,i,j,s,0,visited)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean haspathCore(char[][] arr,int rows,int cols,int row,int col,String s,int index,boolean[][] visited) {
		if (index == s.length()) {
			return true;
		}
		if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || arr[row][col] != s.charAt(index)) {
			return false;
		}
		visited[row][col] = true;
		boolean ithaspath = haspathCore(arr,rows,cols,row+1,col,s,index+1,visited) || 
				haspathCore(arr,rows,cols,row-1,col,s,index+1,visited) ||
				haspathCore(arr,rows,cols,row,col+1,s,index+1,visited) ||
				haspathCore(arr,rows,cols,row,col-1,s,index+1,visited);
		if(!ithaspath) {
			visited[row][col] = false;
		}
		return ithaspath;
	}
}
