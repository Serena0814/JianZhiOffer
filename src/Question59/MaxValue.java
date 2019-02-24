package Question59;

import java.util.ArrayList;

/*
 * 队列的最大值
 * 问题1:滑动窗口的最大值
 * 方法一:暴力破解
 * 方法二：巧解
 * 维护一个排序队列（近似排序的，递减队列）
 */
public class MaxValue {
	public static void main(String args[]) {
		int[] num = {2,3,4,2,6,2,5,1};
		maxInWindows(num,3);
	}
	public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();  //存的是值
        if(num == null || size <= 0) {
        	return list;
        }
        
        ArrayList<Integer> help = new ArrayList<Integer>();  //辅助列表，存的是下标

        int count = 0;
        int length = num.length;
        for(int i = 0; i < length;i++) {
        	if(count>= 1 && i - help.get(0) >= size ) {  //如果第一个数的下标已超出滑动框，则移除
        		help.remove(0);   		
        		count -- ;
        	}
        	
        	if(count == 0) {    //队列中没有数时，直接放入
        		help.add(i);
        		count ++;
        	}else if(num[help.get(count - 1)] > num[i]) {  //如果最小值 比新值还大，队尾直接加入新值
        		help.add(i);
        		count ++;
        	}else {                                   //如果最小值比新值小，则排除最小值，最后加入新值
        		while(count > 0 && num[help.get(count - 1)] <= num[i]) {
        			help.remove(count - 1);
        			count --;
        		}
        		help.add(i);
        		count ++;
        	}
        	
        	if( i >= size - 1) {
        		list.add(num[help.get(0)]);
        	}
        }
        return list;
    }
}
