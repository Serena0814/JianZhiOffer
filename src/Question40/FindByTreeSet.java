package Question40;

import java.util.TreeSet;

/*
 * 方法三：使用TreeSet容器
 * 注意：
 * 1.其底层是用红黑树实现的
 * 2.是一个排序的容器
 * 3.可能需要实现comparable接口
 */
public class FindByTreeSet {
	public static void main(String args[]) {
		int[] arr = {4,5,1,6,2,7,3,8};
		TreeSet<Integer> set = findByTreeSet(arr,3);
		for(int i:set) {
			System.out.print(" " + i);
		}
	}
	public static TreeSet<Integer> findByTreeSet(int[] arr,int k) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		int length = arr.length;
		if(length == 0 || length < k ) {
			return set;
		}
		for(int i = 0;i < k;i++) {
			set.add(arr[i]);
		}
		for(int i = k;i < length;i++) {
			int high = set.pollLast();
			if(high > arr[i]  ) {
				set.add(arr[i]);
			}
			else {
				set.add(high);
			}
		}
		return set;
	}
} 
