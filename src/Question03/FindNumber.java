package Question03;

public class FindNumber {
	public static void main(String args[]) {
		int[] nums = {2,3,1,0,2,5,3};
		System.out.println("数组中重复数字为：" + find(nums));
	}
	
	public static int find(int[] nums) {
		int length = nums.length;
		if (length == 0) {    //判别空数组
			return -1;
		}
		int i = 0;
		while(i < length) {
			if (nums[i] == i) {
				i++;
			}
			else if(nums[i] != nums[nums[i]]) {
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
			else if (nums[i] < 0 || nums[i] >= length) {   //判别无效数组
				return -1;
			}
			else {
				return nums[i];
			}
		}
		return -1;   //判别无效数组
	}
}
