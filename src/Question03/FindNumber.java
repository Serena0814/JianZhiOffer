package Question03;

public class FindNumber {
	public static void main(String args[]) {
		int[] nums = {2,3,1,0,2,5,3};
		System.out.println("�������ظ�����Ϊ��" + find(nums));
	}
	
	public static int find(int[] nums) {
		int length = nums.length;
		if (length == 0) {    //�б������
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
			else if (nums[i] < 0 || nums[i] >= length) {   //�б���Ч����
				return -1;
			}
			else {
				return nums[i];
			}
		}
		return -1;   //�б���Ч����
	}
}
