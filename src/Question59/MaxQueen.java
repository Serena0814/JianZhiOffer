package Question59;

import java.util.ArrayList;

/*
 * 问题二：队列的最大值
 * 类似的思路 维护一个辅助链表
 */
public class MaxQueen {
	public static void main(String args[]) {
		QueueMax a = new QueueMax();
		a.push(1);
		a.push(2);
		a.push(-1);
		a.push(0);
		a.push(10);
		System.out.println(a.max());
		
	}
	
}

class QueueMax{
	private int count;
	private ArrayList<Integer> data;
	private ArrayList<Integer> list;
	
	QueueMax() {
		count = 0;    //辅助队列的长度
		data = new ArrayList<Integer>();  //真实队列
		list = new ArrayList<Integer>();  //辅助队列
	}
	
	void push(int num) {
		if(count == 0) {
			list.add(num);
			count ++;
		} else {
			while(count > 0 && list.get(count - 1) <= num) {
				list.remove(count - 1);
				count--;
			}
			list.add(num);
			count ++;
		}
		data.add(num);      //真实队列push
	}
	
	boolean pop() {
		if(count == 0) 	return false;
		if(list.get(0) == data.get(0)) {
			list.remove(0);
			count --;
		}
		data.remove(0);    //真实队列remove
		return true;
	}
	
	int max() {
		if (count == 0)  return -1;   //这里不合适
		return list.get(0);
	}
}
