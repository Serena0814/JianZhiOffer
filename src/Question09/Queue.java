package Question09;

import java.util.Stack;

public class Queue {
	public static void main(String args[]) {
		CQueue q = new CQueue();
		for(int i = 0;i < 9;i++) {
			q.appendTail(i);
		}
		for(int i = 0;i < 9;i++) {
			System.out.print(q.deleteHead()+" ");
		}
	}
}

class CQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	void appendTail(int n) {
		stack1.push(n);
	}
	int deleteHead() {
		if(!stack2.empty()) {
			return stack2.pop();
		}
		while(!stack1.empty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	boolean empty() {
		if(stack1.empty() && stack2.empty()) {
			return true;
		}
		return false;
	}
}


