package Question40;

import java.util.TreeSet;

/*
 * ��������ʹ��TreeSet����
 * ע�⣺
 * 1.��ײ����ú����ʵ�ֵ�
 * 2.��һ�����������
 * 3.������Ҫʵ��comparable�ӿ�
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
