package Question57;

import java.util.ArrayList;

/*
 * 问题二：和为S的连续正整数序列
 * 注：
 * 双指针问题
 */
public class SumS2 {
	public static void main(String args[]) {
		
	}
	
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		int start = 1;
		int end = 2;
		int he = start + end;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(sum < 3) {
			return list;
		}
		
		while(start < end) {
			if( he < sum) {
				end ++;
				he = he + end;
			}else if(he > sum) {
				he = he - start;
				start ++;
			}else {
				ArrayList<Integer> inter = new ArrayList<Integer>();
				for(int i = start; i <= end;i++) {
					inter.add(i);
				}
				list.add(inter);
				end ++;
				he = he + end;
			}
		}
		return list;
	}
}
