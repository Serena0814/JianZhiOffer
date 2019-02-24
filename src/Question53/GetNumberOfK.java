package Question53;
/*
 * 数字在排序数组中出现的次数（题目一）
 * 注意：
 * 采用优化的二分查找法找到第一次出现的和最后一次出现的下标，之差就是出现的次数
 */
public class GetNumberOfK {
	public static void main(String args[]) {
		int[] array = {1,2,3,3,3,3,4,5};
		System.out.println(getNumberOfK(array , 3));
	}
	
	public static int getNumberOfK(int [] array , int k) {
		if (array == null) {
			return 0;
	    }
		int length = array.length;
	    
	    int first = getNumberFirst(array, k ,0 , length-1);
	    int last = getNumberLast(array, k ,0 , length-1);
	    if(first > -1 && last > -1) {
	    	return last - first + 1;
	    }
	    return 0;
    }
	
	public static int getNumberFirst(int[] array, int k , int start , int end) {
		if (start > end) {
			return -1;
		}
		int med = (start + end) / 2;
		if(array[med] == k) {
			if(med == 0 || array[med - 1] != k) {
				return med;
			} 
			return getNumberFirst(array, k , start , med - 1);
		} else if (array[med] > k) {
			return getNumberFirst(array, k , start , med - 1);
		} else {
			return getNumberFirst(array, k , med + 1 , end);
		}
	}
	
	public static int getNumberLast(int[] array, int k , int start , int end) {
		if (start > end) {
			return -1;
		}
		int med = (start + end) / 2;
		if(array[med] == k) {
			if(med == array.length - 1 || array[med + 1] != k) {
				return med;
			} 
			return getNumberLast(array, k , med + 1 , end);
		} else if (array[med] < k) {
			return getNumberLast(array, k , med + 1 , end);
		} else {
			return getNumberLast(array, k , start , med - 1);
		}
	}
}
