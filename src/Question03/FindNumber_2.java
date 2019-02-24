package Question03;

public class FindNumber_2 {
	public static void main(String args[]) {
		int[] nums = {2,3,5,4,3,2,6,7};
		System.out.println("数组中重复数字为：" + findNumber(nums));
	}
	
	public static int findNumber (int[] nums) {
		int length = nums.length;
		if (length <= 0) {
			return -1;
		}
		int low = 1;
		int high = length - 1;
		int med = (low + high) / 2;
		while(low < high) {
			int count1 = 0;
			int count2 = 0;
			for(int i = 0; i < length; i ++) {
				if (nums[i] <= med && nums[i] >= low) {
					count1 ++;
				}
				else if(nums[i] > med && nums[i] <= high) {
					count2++;
				}
				else {}
			}
			if (count1 > (med - low + 1)) {
				high = med;
				med = (low + high) / 2;
			}
			else if (count2 > (high - med)) {
				low = med + 1;
				med = (low + high) / 2;
			}
			else {
				return -1;
			}
		}
		return low;
	}
}
