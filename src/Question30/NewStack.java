package Question30;

import java.util.Stack;

/*
 * 包含min函数的栈，定义栈的数据结构：
 * 双栈的思想
 */
public class NewStack {
	public static void main(String args[]) {
		MinStack minstack = new MinStack();
		minstack.push(3);
		minstack.push(2);
		minstack.push(4);
		minstack.push(0);
		
		System.out.println(minstack.min());
		System.out.println(minstack.pop());
		System.out.println(minstack.min());
	}
}

class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	void push(int num) {
		stack.push(num);
		if(minStack.empty()) {
			minStack.push(num);
		}
		else if(minStack.peek() < num) {
			minStack.push(minStack.peek());
		}
		else {
			minStack.push(num);
		}
	}
	
	int pop() {
		minStack.pop();
		return stack.pop();
	}
	
	int min() {
		return minStack.peek();
	}
}
