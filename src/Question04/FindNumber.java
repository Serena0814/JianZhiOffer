package Question04;

public class FindNumber {
	public static void main(String args[]) {
		int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int number = 7;
		if (findNumber(nums,number)) {
			System.out.println("数组中含有该整数");
		}
		else {
			System.out.println("数组中不含该整数");
		}
	}
	
	public static boolean findNumber (int[][] nums,int number) {
		int row_number = nums.length;
		if (row_number <= 0) {
			return false;
		}
		int column_number = nums[0].length;
		if (column_number <= 0) {
			return false;
		}
		int i = 0;
		int j = column_number - 1;
		while (i < row_number && j >= 0) {
			if (nums[i][j] == number) {
				return true;
			}
			else if (nums[i][j] > number) {
				j--;
			}
			else {
				i++;
			}
		}
		return false;
	}
}
