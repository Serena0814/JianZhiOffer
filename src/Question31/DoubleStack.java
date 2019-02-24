package Question31;

import java.util.Stack;

/*
 * 判断第二个序列是否为栈的弹出序列
 * 注意：
 * 1.辅助栈的运用
 * 2.简化分析：所有数字均不相等
 */
public class DoubleStack {
	public static void main(String args[]) {
		int[] arrIn = {1,2,3,4,5};
		int[] arrOut1 = {4,5,3,2,1};
		int[] arrOut2 = {4,3,5,1,2};
		System.out.println(doubleStack(arrIn,arrOut1));
		System.out.println(doubleStack(arrIn,arrOut2));
	}
	
	public static boolean doubleStack(int[] stackIn,int[] stackOut) {
		Stack<Integer> assistStack = new Stack<Integer>();
		if(stackIn == null && stackOut == null) {
			return true;
		}
		if(stackIn == null || stackOut == null) {
			return false;
		}
		int indexIn = 0;
		int indexOut = 0;
		int length = stackOut.length;
		
		while(indexIn < length && indexOut < length) {
			assistStack.push(stackIn[indexIn]);
			while(indexOut < length && indexIn < length && !assistStack.empty() && assistStack.peek() == stackOut[indexOut]) {
				indexOut ++;
				assistStack.pop();
			}
			indexIn++;
		}
		if(indexOut >= length && indexIn >= length && assistStack.empty()) {
			return true;
		}
		return false;
	}
}
