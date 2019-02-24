package Question33;

/*
 * 判断数组是否为某二叉搜索树的后序序列
 * 注意点：
 * 1.二叉搜索树本身的定义
 * 2.后序序列最后一个数为根节点
 * 3.递归的运用
 */
public class SequenceOfBST {
	public static void main(String args[]) {
		int[] arr = {5,7,6,9,11,10,8};
		int length = arr.length;
		System.out.println(verifySequence(arr,0,length - 1));
		int[] arr2 = {7,4,6,5};
		int length2 = arr2.length;
		System.out.println(verifySequence(arr2,0,length2 - 1));
		int[] arr3 = {7,6,5};
		int length3 = arr3.length;
		System.out.println(verifySequence(arr3,0,length3 - 1));
	}
	
	public static boolean verifySequence(int[] arr,int start,int end) {
		if(arr == null) {
			return false;
		}
		if(start >= end) {
			return true;
		}
		int left = start;
		while(left < end && arr[left] < arr[end]) {
			left++;
		}
		int right = left;
		while(right < end && arr[right] > arr[end]) {
			right++;
		}
		if(right != end) {
			return false;
		}
		return verifySequence(arr,start,left - 1) && verifySequence(arr,left,end - 1);
	}

}

class BinaryTreeNode {
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode (int value) {
		this.value = value;
	}
}